import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Please input the keyword: ");
		String keyword = sc.next();
		sc.close();
	
		KeywordList kLst = new KeywordList();	
		System.out.println("-------------------------------------------------------\nRelative Word List: ");
		kLst.printKeywordList(kLst.getKeywords());
		System.out.print("-------------------------------------------------------\nValid Web Pages for Keyword [" + keyword + "]: \n");
		GoogleSearch google = new GoogleSearch(keyword);
		System.out.print(google.toString());
		
		ArrayList<WebNode> wLst = new ArrayList<WebNode>();	
		
		try 
		{		
			for(String title: google.query().keySet()) 
			{
				String webUrl = google.query().get(title);	
				WebPage rootPage = new WebPage(webUrl, title);
				WebTree tree = new WebTree(rootPage);
					
				ChildPageQuery childQ = new ChildPageQuery(webUrl);
				int count = 0;
				if(childQ.query() != null) 
				{			
					for(String childUrl: childQ.query()) 
					{			
						count++;							
						tree.root.addChild(new WebNode(new WebPage(childUrl, count + "")));
					}
						
					tree.setPostOrderScore(kLst.getKeywords());
					wLst.add(tree.root);
				}
			}	
			
			WebRating rating = new WebRating(wLst);
			rating.sort();
			System.out.println("-------------------------------------------------------\n★★★Rating★★★\n(Title, Total Child Pages, Total Root Page Score)");
			System.out.print(rating.output());
		} 

		catch(IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}