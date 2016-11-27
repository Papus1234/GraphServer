package Estructuras_Basicas.BTree;

public class Entry {
	public Comparable key;
    public final Object val;
    public Node next;     // helper field to iterate over array entries
    public Entry(Comparable key, Object val, Node next) {
        this.key  = key;
        this.val  = val;
        this.next = next;
    }

}
