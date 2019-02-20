import java.util.Scanner;


public class Graph {
	
	private final int nodes;
	static int choice;
	static int noOfNodes;
	static int noOfEdges;
	Graph graph;
	private int[][] adjacencyMatrix;
	private static String[][] adjacencyMatrix1;
	public Graph(int noOfNodes) {
		nodes=noOfNodes;
		adjacencyMatrix=new int[nodes+1][nodes+1];
		adjacencyMatrix1=new String[nodes+1][nodes+1];
	}
	public void incidentEdges(int Node)
	{
		int pos = 0,ipos=0;
		
		for(int i=0;i<noOfNodes;i++)
		{
			if(adjacencyMatrix[i][0]==Node)
			{
				pos=adjacencyMatrix[i][0];
				ipos=i;
				break;
			}
		}
		for(int i=0;i<noOfNodes;i++)
		{
			if(adjacencyMatrix[i][0]!=0)
			{
			System.out.println("For node "+Node+"Adjacent edges are :" +adjacencyMatrix[i][0]);
			}
		}
	}
	public void Edge(int to, int from, int weight) 
	{
		try 
		{
			adjacencyMatrix[to][from] = weight;
        }
		catch (ArrayIndexOutOfBoundsException index) 
        {
            System.out.println("The nodes does not exists");
        }

    }
	public void EdgeLable(int to,int from, String Lable)
	{
		try
		{
			adjacencyMatrix1[to][from]=Lable;
		}
		catch (ArrayIndexOutOfBoundsException index) 
        {
            System.out.println("The nodes does not exists");
        }
	}
	
	public void source_destination_node(String edgeLable)
	{
		String lable=edgeLable; 
		String temp;
		System.out.println("Label value"+lable);
		 for(int i=1;i<=noOfNodes;i++)
		 {
         for(int j=1;j<=noOfNodes;j++)
         {
        	 
        	 if(adjacencyMatrix1[i][j]!=null)
        	 {
        		 System.out.println("  "+adjacencyMatrix1[i][j]);
        		 temp=adjacencyMatrix1[i][j];
        		 System.out.println("temp"+temp);
        	     if(temp.equalsIgnoreCase(lable));
        	     {
        	    	
        	    	 System.out.println("Source node  "+adjacencyMatrix1[0][j]);
        	    	 System.out.println("destination node  "+adjacencyMatrix1[i][0]);
        	     }
        	 }
         }
  
		 }
		 
	}
	
	public void in_out_degree(int node)
	{
		int inCount=0,outCount=0;
		for(int i=0;i<noOfNodes;i++)
		{
			if(adjacencyMatrix[node][i]!=0)
			{
				outCount++;
			}
		}
		for(int i=0;i<noOfNodes;i++)
		{
			if(adjacencyMatrix[i][node]!=0)
			{
				inCount++;
			}
		}
		System.out.println("For node "+node+" In-degree: "+inCount);
		System.out.println("For node "+node+" Out-degree "+outCount);
	}
	
	public int returnEdge(int to, int from) 
    {
        try 
        {
            return adjacencyMatrix[to][from];
        }
        catch (ArrayIndexOutOfBoundsException index) 
        {
            System.out.println("The vertices does not exists");
        }
        return -1;
    }

	public static void main(String argv[])
	{
		int to=0,from=0,count=1,weight=0;
		String lable;
		
		Graph graph;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of nodes :");
		noOfNodes=sc.nextInt();
		System.out.println("Enter number of Edges :");
		noOfEdges=sc.nextInt();
		graph=new Graph(noOfNodes);
		
		System.out.println("Enter edges: <to> <from> <weight> ,<Lable>");
		while(count<=noOfEdges)
		{
			to=sc.nextInt();
			from=sc.nextInt();
			weight=sc.nextInt();
			lable=sc.nextLine();
			graph.Edge(to,from,weight);
			graph.EdgeLable(to, from, lable);
			count++;
		}
		
		
		 System.out.println("The adjacency matrix for the given graph is: ");
         System.out.print("  ");
         for (int i=1;i<=noOfNodes;i++)
             System.out.print(i + " ");
         System.out.println();

         for (int i = 1; i <= noOfNodes; i++) 
         {
             System.out.print(i + " ");
             for (int j = 1; j <= noOfNodes; j++) 
                 System.out.print(graph.returnEdge(i, j) + " ");
             System.out.println();
         }
         
         System.out.println("The adjacency matrix1 for the given graph is: ");
         System.out.print("  ");
         for (int i=1;i<=noOfNodes;i++)
             System.out.print(i + " ");
         System.out.println();

         for (int i = 1; i <= noOfNodes; i++) 
         {
             System.out.print(i + " ");
             for (int j = 1; j <= noOfNodes; j++) 
                 System.out.print("   "+adjacencyMatrix1[i][j]);
             System.out.println();
         }
         
         
         System.out.println("1. in and out degree of node");
         System.out.println("2. Source and destination nodes of edge.");
         System.out.println("3. Incident edges of node");
         System.out.println("Enter choice:");
         choice=sc.nextInt();
        switch(choice)
        {
        case 1:
        	int node = 0;
        	System.out.println("Enter node value");
        	node=sc.nextInt();
			//in-out degree of node
        	graph.in_out_degree(node);
        	break;
        case 2:
        	//source and destination of edge
        	String Label;
        	System.out.println("Enter Edge Label");
        	Label=sc.next();
        	System.out.println("Lable :"+Label);
        	graph.source_destination_node(Label);
        	break;
        case 3:
        	//incident edges of node
        	int Node;
        	System.out.println("Enter Node:");
        	Node=sc.nextInt();
        	graph.incidentEdges(Node);
        	
        	break;
        default:
        	break;
        }
        sc.close();
	}
}
