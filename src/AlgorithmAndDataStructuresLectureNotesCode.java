/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class Node {

    //
    //  constructors
    //
    public Node() {
    }

    public Node(Object e, Node n) {//create a node given element and next reference
        element = e;
        next = n;
    }

    //
    // methods: getters
    //
    public Object getElement() {
        return element;
    }

    public Node getNext() {
        return next;
    }

    //
    //  methods: setters
    //
    public void setElement(Object newElem) {
        element = newElem;
    }

    public void setNext(Node newNext) {
        next = newNext;
    }

    //
    //  fields
    //
    private Object element;  // element stored in this node
    private Node next; // reference to the next node in the list

} // end of class Node

class LinkedStack {

    private Node top;         // reference to the top node
    private int size;      // number of elements in the stack

    public LinkedStack() {     	// Initialize the stack
        top = null;
        size = 0;
    }

    public int size() {
        // Returns the current stack size
        return size;
    }

    public boolean isEmpty() {
// Returns true if the stack is empty
        if (top == null) {
            return true;
        } else {
            return false;
        }
    }

    public Object top() {  // Return the top stack element
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        }

        return top.getElement();
    }

    public void push(Object obj) {
// Push a new object on the stack
        Node n = new Node();
        n.setElement(obj);
        n.setNext(top);
        top = n;
        size++;
    }

    public Object pop() {
// Pop off the top stack element
        Object temp;
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        }
        temp = top.getElement();
        top = top.getNext();       // adjust the top node
        size--;
        return temp;
    }
}

class LinkedQueue {

    private Node head, tail;
    private int qSize;

    // constructor
    public LinkedQueue() {
        head = tail = null;
        qSize = 0;
    }

    // accessor methods
    public int size() {
        return qSize;
    }

    public Node getTail() {
        return tail;
    }

    public boolean isEmpty() {
        return (qSize == 0);
    }

    public Object front() {
//		if (isEmpty())
//			System.out.println("Queue is Empty");
//		else
        return head.getElement();
    }

    // update methods
    public void append(Object obj) // insert an element 
    {
        Node node = new Node();

        node.setElement(obj);
        node.setNext(null);     	// node will be new tail node
        if (qSize == 0) {
            head = node;      	// special case of  a previously 					// empty queue
        } else {
            tail.setNext(node); // add node at the tail of the list
        }
        tail = node;    // update the reference to the tail node
        qSize++;
    }

    public Object serve() // Remove the first object from the queue
    {

//		if (qSize == 0)
//		 System.out.println("Queue is empty.");
//		else {
        Object obj = head.getElement();
        head = head.getNext();
        qSize--;

        if (qSize == 0) {
            tail = null; // the queue is now 				   // empty
        }
        return obj;
    }

    public void clear() {
        while (!isEmpty()) {
            serve();

        }
    }
//this was where i reversed the data 
    public void reverse() { 
        LinkedStack stack = new LinkedStack();
        while (!isEmpty()) {// removing data until the queue is empty
            Object data = serve();// this takes item from queue
            stack.push(data); // it puts the item into the stack
           
        }
        while (!stack.isEmpty()) {   // it empties the stack back into the queue         
           Object data = stack.pop();// this takes away from the stack
           this.append(data);// this hold data into the stack.
            
        }
    }

    public String print() {

        String text = "";
        for (Node i = head; i != null; i = i.getNext()) {
            text += i.getElement().toString();
            text += " ";
        }
        return text;
    }
}
