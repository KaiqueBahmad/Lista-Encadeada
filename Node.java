public class Node {
    private Object value;
    private Node pointer;
    
    public Node(Object value, Node pointer ) {
        this.value = value;
        this.pointer = pointer;
    }
    public Node(Object value) {
        this.value = value;
        this.pointer = null;
    }
    public Object getValue() {
        return this.value;
    }
    public boolean hasNext() {
        return pointer != null;
    }
    public void pointTo(Node who) {
        this.pointer = who;
    }
    public Node next() {
        return this.pointer;
    }
}
