package de.dakror.jagui.parser;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.yaml.snakeyaml.Yaml;

import de.dakror.gamesetup.util.Helper;

/**
 * @author Dakror
 */
public class NGuiParser
{
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
			JFileChooser jfc = new JFileChooser(new File(NGuiParser.class.getProtectionDomain().getCodeSource().getLocation().toURI()));
			jfc.setMultiSelectionEnabled(false);
			jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			jfc.setFileFilter(new FileNameExtensionFilter("Unity ngui Gui-Skin (*.guiskin)", "guiskin"));
			
			if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
			{
				p("Collecting GUIDs");
				HashMap<String, File> guids = collectGUIDs(jfc.getCurrentDirectory());
				
				p("Parsing Guiskin file");
				String s = Helper.getFileContent(jfc.getSelectedFile());
				String[] lines = s.split("\n");
				ArrayList<String> l = new ArrayList<>(Arrays.asList(lines));
				String string = "";
				for (int i = 0; i < l.size(); i++)
					if (!l.get(i).startsWith("%") && !l.get(i).startsWith("---")) string += l.get(i) + "\n";
				
				Yaml yaml = new Yaml();
				for (Iterator<Object> iter = yaml.loadAll(string).iterator(); iter.hasNext();)
				{
					JSONObject o = new JSONObject((Map<?, ?>) iter.next());
					p("Cconverting Guiskin");
					replaceGuidDeep(o, guids, jfc.getSelectedFile());
					p("Writing converted file");
					Helper.setFileContent(new File(jfc.getSelectedFile().getParentFile(), jfc.getSelectedFile().getName() + ".json"), o.toString(4));
					p("DONE");
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static JSONObject replaceGuidDeep(JSONObject data, HashMap<String, File> guids, File sel)
	{
		for (String key : JSONObject.getNames(data))
		{
			try
			{
				if (data.get(key) instanceof JSONArray)
				{
					for (int i = 0; i < data.getJSONArray(key).length(); i++)
					{
						if (data.getJSONArray(key).get(i) instanceof JSONObject) data.getJSONArray(key).put(i, replaceGuidDeep(data.getJSONArray(key).getJSONObject(i), guids, sel));
					}
				}
				else if (data.get(key) instanceof JSONObject)
				{
					if (data.getJSONObject(key).has("r") && data.getJSONObject(key).has("g") && data.getJSONObject(key).has("b") && data.getJSONObject(key).has("a"))
					{
						String r = Integer.toHexString((int) Math.round(data.getJSONObject(key).getDouble("r") * 255));
						r = r.length() == 1 ? "0" + r : r;
						String g = Integer.toHexString((int) Math.round(data.getJSONObject(key).getDouble("g") * 255));
						g = g.length() == 1 ? "0" + g : g;
						String b = Integer.toHexString((int) Math.round(data.getJSONObject(key).getDouble("b") * 255));
						b = b.length() == 1 ? "0" + b : b;
						
						data.getJSONObject(key).remove("r");
						data.getJSONObject(key).remove("g");
						data.getJSONObject(key).remove("b");
						
						data.getJSONObject(key).put("rgb", "#" + r + g + b);
						continue;
					}
					if (data.getJSONObject(key).has("fileID") && data.getJSONObject(key).getInt("fileID") == 0)
					{
						data.put(key, JSONObject.NULL);
						continue;
					}
					if (data.getJSONObject(key).has("guid") && (data.getJSONObject(key).get("guid") instanceof String))
					{
						File f = guids.get(data.getJSONObject(key).getString("guid"));
						if (f != null)
						{
							data.put(key, f.getPath().replace(sel.getParentFile().getPath() + "\\", "").replace("\\", "/"));
							continue;
						}
					}
					
					data.put(key, replaceGuidDeep(data.getJSONObject(key), guids, sel));
				}
			}
			catch (JSONException e)
			{
				e.printStackTrace();
			}
		}
		
		return data;
	}
	
	public static void p(String s)
	{
		System.out.println(s);
	}
	
	public static HashMap<String, File> collectGUIDs(File dir) throws Exception
	{
		HashMap<String, File> hash = new HashMap<>();
		
		for (File f : dir.listFiles())
		{
			if (f.isDirectory()) hash.putAll(collectGUIDs(f));
			else if (f.getName().endsWith(".meta"))
			{
				File represents = new File(dir, f.getName().substring(0, f.getName().lastIndexOf(".meta")));
				if (represents.exists())
				{
					JSONObject o = new JSONObject((Map<?, ?>) new Yaml().load(new FileReader(f)));
					hash.put(o.getString("guid"), represents);
				}
			}
		}
		
		return hash;
	}
}
