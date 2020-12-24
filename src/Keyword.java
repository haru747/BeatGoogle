
public class Keyword 
{
	public String name;
    public int count;
    public double weight;
    
    public Keyword(String name, int count, double weight)
    {
		this.name = name;
		this.count = count;
		this.weight = weight;
    }
    
    public Keyword(String name, double weight) 
    {
		this.name = name;
		this.weight = weight;
		this.count = 0;
	}

	@Override
    public String toString()
    {
    	return "[" + name + "," + count + "," + weight + "]";
    }
    
    public int getCount()
    {
    	return count;
    }
    
    public String getName()
    {
    	return name;
    }
    
    public double getWeight()
    {
    	return weight;
    }
    
    public void setCount(int count) 
    {
    	this.count = count;
    }
}