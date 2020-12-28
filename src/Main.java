import java.io.IOException;

public class Main 
{

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		KeywordList kLst = new KeywordList();	
		kLst.printKeywordList(kLst.getKeywords());
		
		System.out.println("\n------------------------------------------\n\nValid Web Pages:");
		GoogleSearch google = new GoogleSearch("聖誕節景點");
		System.out.println(google.toString());
		System.out.println("------------------------------------------\n\nRating\n(Title, Total Child Pages, Total Root Page Score)");
		
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
					tree.printRootPage();
				}
			}				
		} 

		catch(IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}