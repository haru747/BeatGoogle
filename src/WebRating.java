import java.util.ArrayList;

public class WebRating 
{
	private ArrayList<WebNode> lst;
	
	public WebRating()
	{
		this.lst = new ArrayList<WebNode>();
    }
	
	public WebRating(ArrayList<WebNode> lst)
	{
		this.lst = lst;
    }

	public void sort()
	{
		quickSort(0, lst.size() - 1);
	}
	
	private void quickSort(int leftbound, int rightbound)
	{
		int pivot = rightbound;
		if(leftbound < rightbound) 
        {
        	int i = leftbound - 1;        	
            for(int j = leftbound; j < rightbound; j++) 
            { 
                if(lst.get(j).nodeScore >= lst.get(pivot).nodeScore) 
                { 
                    i++; 
                    swap(i, j); 
                } 
            } 
            swap(i + 1, pivot);
        	
        	int partition = i + 1;
        	quickSort(leftbound, partition - 1); 
            quickSort(partition + 1, rightbound); 
        }
	}
	
	private void swap(int aIndex, int bIndex)
	{
		WebNode temp = lst.get(aIndex);
		lst.set(aIndex, lst.get(bIndex));
		lst.set(bIndex, temp);
	}
	
	public String output()
	{
		StringBuilder sb = new StringBuilder();
		int number = 0;
		
		for(int i = 0; i < lst.size(); i++)
		{
			number++;
			WebNode web = lst.get(i);			
			sb.append("NO." + number + " (" + web.webPage.name + ", " + web.children.size() + ", " + web.nodeScore + ")\n");
		}
		
		return sb.toString();	
	}
}