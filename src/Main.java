import java.io.IOException;
import java.util.ArrayList;

import javax.net.ssl.SSLHandshakeException;

public class Main 
{

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub

		ArrayList <Keyword> kLst = new ArrayList<Keyword>();
		kLst.add(new Keyword("聖誕節", 5));
		kLst.add(new Keyword("耶誕節", 5));
		kLst.add(new Keyword("景點", 4.5));
		kLst.add(new Keyword("聖誕樹", 4.5));
		kLst.add(new Keyword("2020", 3.5));
		kLst.add(new Keyword("網美", 2));
		kLst.add(new Keyword("打卡", 3));
		kLst.add(new Keyword("聖誕市集", 4.5));
		kLst.add(new Keyword("裝置藝術", 4));
		kLst.add(new Keyword("燈光秀", 4));
		kLst.add(new Keyword("北部", 1.5));
		kLst.add(new Keyword("中部", 1.5));
		kLst.add(new Keyword("南部", 1.5));
			
		System.out.println("Keywords for 聖誕節景點");
		for(Keyword k: kLst) 
		{
			System.out.println(k.toString1());
		}
		
		System.out.println("\n------------------------------------------\n");
		GoogleSearch google = new GoogleSearch("聖誕節景點");
		System.out.println(google.query());
		System.out.println("\n------------------------------------------\n");
		
		try 
		{			
			for(String title: google.query().keySet()) 
			{
				String webUrl = google.query().get(title);

				if(!webUrl.contains("welcome")) 
				{
					WebPage rootPage = null;
					if(webUrl.contains("&")) 
					{
						rootPage = new WebPage(webUrl.substring(7, webUrl.indexOf("&")), title);
					}
					else if(webUrl.contains("%")) 
					{
						rootPage = new WebPage(webUrl.substring(7, webUrl.indexOf("%")), title);
					}
					
					WebTree tree = new WebTree(rootPage);
					tree.setPostOrderScore(kLst);
					tree.eularPrintTree();
					System.out.println("\n------------------------------------------\n");
				}
				
				
				
				//build childnode
/*				tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Publications.html","Publication")));
				tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Projects.html","Projects")));
				tree.root.children.get(1).addChild(new WebNode(new WebPage("https://vlab.cs.ucsb.edu/stranger/", "Stranger")));
				tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Members.html", "MEMBER")));
				tree.root.addChild(new WebNode(new WebPage("http://www3.nccu.edu.tw/~yuf/course.htm","Course")));
*/													
				
			}
		} 

		catch(IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
