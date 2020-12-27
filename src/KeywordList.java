import java.util.ArrayList;

public class KeywordList extends ArrayList
{
	public KeywordList() 
	{
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
		printKeywordList(kLst);
	}
	
	public void printKeywordList(ArrayList<Keyword> kLst) 
	{
		System.out.println("Keyword for Christmas spots: ");
		for(Keyword k: kLst) 
		{
			System.out.println(k.toString1());
		}
		System.out.println();
	}
}
