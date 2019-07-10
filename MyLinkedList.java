class MyLinkedList {
    class Node {
        int val;
        Node next;
        Node(int value) {
            this.val = value;
        }
    }

    private Node head;
    
    public Node getNode(int index){
        if(index < 0){
            return null;
        }
        Node cur = head;
        
        for(int i=0; i < index && cur != null; i++){
            cur = cur.next;
        }
        return cur;
    }
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node cur = getNode(index);
        
        if(cur == null){
            return -1;
        }
        
        return cur.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node cur = new Node(val);
        cur.next = head;
        head = cur;
        return;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(head == null){
            addAtHead(val);
            return;
        }
        
        Node m = head;
        while (m != null && m.next != null) {
            m = m.next;
        }
        Node cur = new Node(val);
        m.next = cur;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        
        if(index <= 0){
            addAtHead(val);
            return;
        }
        Node n = getNode(index - 1);
        if(n == null){
            return;
        }
        Node cur = new Node(val);
        cur.next = n.next;
        n.next = cur;
    }
    
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        Node cur = getNode(index);
        
        if(cur == null){
            return;
        }
        
        Node m = getNode(index - 1);
        
        if(m != null){
            m.next = cur.next;
        }else{
            head = cur.next;
        }
    }
}
