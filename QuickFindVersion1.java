import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickFindVersion1
{

	private int [] id; 
	
	public QuickFindVersion1(int N) //constructor with N(number of objects) as inputs
	{
		id = new int[N]; //create an array to hold N integer objects
		
		for (int i=0;i<N;i++)
			
				id[i]=i;
		
	}
	
	
	public boolean connected(int p, int q)
	{
		return id[p] == id[q];
	}
	
	public void union(int p, int q)
	{
		int pid = id[p];
		int qid = id[q];
		
		for(int i=0;i<id.length;i++)
			
			if ( id[i] == pid)
				id[i]=qid;
		
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
