package BTree;

import BTree.Node;

//internal nodes: only use key and next
// external nodes: only use key and value
public class Entry {
    public Comparable key;
    public Object val;
    public Node next;     // helper field to iterate over array entries
    public Entry(Comparable key, Object val, Node next) {
        this.key  = key;
        this.val  = val;
        this.next = next;
    }
}
