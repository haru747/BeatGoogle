import java.util.ArrayList;

public class WordComparator 
{
	private ArrayList<Keyword> lst;
	
	public WordComparator()
	{
		this.lst = new ArrayList<Keyword>();
    }
	
	public void add(Keyword keyword)
	{
		lst.add(keyword);
		System.out.println("Done");
    }
	
	public void find(String s)
	{
		int maxValue = -1;
		int maxIndex = -1;
		
		for(int i = 0; i < lst.size(); i++)
		{
			int lcs = findLCS(lst.get(i).name, s);
			System.out.println(lcs);
			
			if(lcs > maxValue)
			{
				maxValue = lcs;
				maxIndex = i;
			}
		}
		System.out.println(lst.get(maxIndex).toString());
	}
	
	public int findLCS(String x, String y)
	{
		int[][] lcs = new int[x.length() + 1][y.length() + 1];
		for(int i = 0; i < x.length() + 1; i++) 
		{
			lcs[i][0] = 0;
		}
		
		for(int j = 0; j < y.length() + 1; j++) 
		{
			lcs[0][j] = 0;
		}
		
		for(int i = 1; i < x.length() + 1; i++) 
		{
			for(int j = 1; j < y.length() + 1; j++) 
			{
				if(x.substring(i - 1, i).equals(y.substring(j - 1, j))) 
				{
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				}
				else 
				{
					lcs[i][j]  = Math.max(lcs[i - 1][j], lcs[i][j - 1]);	
				}
			}
		}
		
		return lcs[x.length()][y.length()];
	}
}