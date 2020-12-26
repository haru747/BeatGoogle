import java.io.IOException;
import java.util.ArrayList;

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
			
		try 
		{
			GoogleSearch searchEngine = new GoogleSearch("聖誕節景點");
			System.out.println(searchEngine.query());
			System.out.println("------------------------------------------");	
			
			for(String title: searchEngine.query().keySet()) 
			{
				String webUrl = searchEngine.query().get(title);
				WebPage rootPage = new WebPage(webUrl.substring(6), title);
				WebTree tree = new WebTree(rootPage);
/*
				tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Publications.html","Publication")));
				tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Projects.html","Projects")));
				tree.root.children.get(1).addChild(new WebNode(new WebPage("https://vlab.cs.ucsb.edu/stranger/", "Stranger")));
				tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Members.html", "MEMBER")));
				tree.root.addChild(new WebNode(new WebPage("http://www3.nccu.edu.tw/~yuf/course.htm","Course")));
*/				
				tree.setPostOrderScore(kLst);
				tree.eularPrintTree();
			}
		} 
		
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
