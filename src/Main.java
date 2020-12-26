import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
			
			for(int i = 1; i <= searchEngine.query().size(); i++) 
			{
				
			}
			WebPage rootPage = new WebPage("http://soslab.nccu.edu.tw/Welcome.html", "Soslab");		
			WebTree tree = new WebTree(rootPage);

			tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Publications.html","Publication")));
			tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Projects.html","Projects")));
			tree.root.children.get(1).addChild(new WebNode(new WebPage("https://vlab.cs.ucsb.edu/stranger/", "Stranger")));
			tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Members.html", "MEMBER")));
			tree.root.addChild(new WebNode(new WebPage("http://www3.nccu.edu.tw/~yuf/course.htm","Course")));

			Scanner scanner = new Scanner(System.in);
			while(scanner.hasNextLine())
			{
				int numOfKeywords = scanner.nextInt();//2
				ArrayList<Keyword> keywords = new ArrayList<Keyword>();
				
				for(int i = 0; i < numOfKeywords; i++)
				{
					String name = scanner.next();//Yu
					double weight = scanner.nextDouble();//1.2
					Keyword k = new Keyword(name, weight);//store key
					keywords.add(k);
				}
				
				tree.setPostOrderScore(kLst);
				tree.eularPrintTree();
			}
			scanner.close();
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
