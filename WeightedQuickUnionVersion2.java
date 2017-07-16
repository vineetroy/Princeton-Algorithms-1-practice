import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnionVersion2  /* Path Compression*/
{

	private int [] id;
	private int [] sz;
	
	public WeightedQuickUnionVersion2(int N) //constructor with N(number of objects) as inputs
	{
		id = new int[N]; //create an array to hold N integer objects
		
		for (int i=0;i<N;i++)
			
			{
				id[i]=i;
				sz[i]=1;
				
			}
		
	}
	
	private int root(int p)
	{
		while(p!=id[p])
		{
			id[p]=id[id[p]];//extra line for path compression
			p=id[p];
		}
		
		return p;
		
	}
	
	public boolean connected(int p, int q)
	{
		return root(p) ==  root(q);
	}
	
	public void union(int p, int q)
	{
		int i = root(p);
		int j = root(q);
		
		if(sz[i]<sz[j])
		{
			id[i]=j;
			sz[j]+=sz[i];
		}
		 
		 else
			 {
			id[j]=i;
			sz[i]+=sz[j];
		}
			 
		 
		
	}
	
	public static void main( String args[])
	{
		int n= StdIn.readInt();
		
		QuickFindVersion1 qf = new QuickFindVersion1(n);
		while(!StdIn.isEmpty())
		{
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			
			if(!qf.connected(p,q))
			{
				qf.union(p,q);
				StdOut.println(p+" "+q);
			}
				
		}
		
		
		//play
		
		StdOut.println( "connected "+ 1+" "+5+ " "+ qf.connected(1,5) );
		StdOut.println( "connected "+ 2+" "+7+ " "+ qf.connected(2,7) );
		StdOut.println( "connected "+ 9+" "+5+ " "+ qf.connected(9,5) );
		
		
		
	}
	

}
