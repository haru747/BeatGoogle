import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
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
			int numOfKeywords = scanner.nextInt();
			ArrayList<Keyword> keywords = new ArrayList<Keyword>();
			
			for(int i = 0; i < numOfKeywords; i++)
			{
				String name = scanner.next();
				double weight = scanner.nextDouble();
				Keyword k = new Keyword(name, weight);//store key
				keywords.add(k);
			}
			
			tree.setPostOrderScore(keywords);
			tree.eularPrintTree();
		}
		
		scanner.close();
		
		try 
		{
			System.out.println(new GoogleSearch("NCCU").query());
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
