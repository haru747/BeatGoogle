import java.util.ArrayList;

public class KeywordList
{
	private ArrayList<Keyword> keywords;

	public KeywordList() 
	{
		this.keywords = new ArrayList<Keyword>();
		keywords.add(new Keyword("聖誕節", 5));
		keywords.add(new Keyword("耶誕節", 5));
		keywords.add(new Keyword("景點", 4.5));
		keywords.add(new Keyword("聖誕樹", 4.5));
		keywords.add(new Keyword("2020", 3.5));
		keywords.add(new Keyword("網美", 2));
		keywords.add(new Keyword("打卡", 3));
		keywords.add(new Keyword("聖誕市集", 4.5));
		keywords.add(new Keyword("裝置藝術", 4));
		keywords.add(new Keyword("燈光秀", 4));
		keywords.add(new Keyword("北部", 1.5));
		keywords.add(new Keyword("中部", 1.5));
		keywords.add(new Keyword("南部", 1.5));
	}
	
	public void printKeywordList(ArrayList<Keyword> kLst) 
	{
		System.out.println("Keyword for 聖誕節景點: ");
		for(Keyword k: kLst) 
		{
			System.out.println(k.toString1());
		}
	}
	
	public ArrayList<Keyword> getKeywords() 
	{
		return keywords;
	}
}
