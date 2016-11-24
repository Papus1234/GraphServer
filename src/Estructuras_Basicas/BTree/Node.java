package BTree;
public class Node {
	
	private static final int M = 4;
	public int m;                             // number of children
    public Entry[] children = new Entry[M];   // the array of children
    

    // create a node with k children
    public Node(int k) {
        m = k;
    }
	
}

