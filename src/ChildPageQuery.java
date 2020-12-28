import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ChildPageQuery 
{
	public String url;
	public String content;

	public ChildPageQuery(String url)
	{
 		this.url = url;
	}
	
	private String fetchContent() throws IOException
	{
		String retVal = "";
		URL u = new URL(url);
		URLConnection conn = u.openConnection();
		conn.setRequestProperty("User-agent", "Chrome/7.0.517.44");
		InputStream in = conn.getInputStream();
		InputStreamReader inReader = new InputStreamReader(in, "utf-8");
		BufferedReader bufReader = new BufferedReader(inReader);
		String line = null; 
			
		while((line=bufReader.readLine()) != null)
		{
			retVal += line;
		}
		return retVal;
	}
	
	public ArrayList<String> query() throws IOException
	{
		if(content == null)
		{
			content = fetchContent();
		}

		ArrayList<String> retVal = new ArrayList<String>();
		
		Document doc = Jsoup.parse(content);
		Elements lis = doc.select("a");
				
		for(Element li : lis)
		{
			try 
			{
				String citeUrl = li.attr("href");
				
				if(citeUrl.contains("&")) 
				{
					citeUrl = citeUrl.substring(7, citeUrl.indexOf("&"));
				}
				else if(citeUrl.contains("%")) 
				{
					citeUrl = citeUrl.substring(7, citeUrl.indexOf("%"));
				}
				
				retVal.add(citeUrl);
			} 
			
			catch (IndexOutOfBoundsException e) 
			{
//				e.printStackTrace();
			}
		}
		
		return retVal;
	}
}
