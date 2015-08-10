import java.util.HashMap;

class MinStack {
    /**
    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
    */
    private StackNode first;
    
    public MinStack () {
        first = null;
        }
    
    public boolean isEmpty () {
        // returns true if Stack is empty
        return first == null;
    }
    
    public void push(int x) {
        // pushes element x on to the stack, and keeps track of current min
        int min;
        if (first == null) min = x;
        else min = x < first.min ? x : first.min;
        StackNode newNode = new StackNode (x, min, this.first);
        this.first = newNode;
    }

    public void pop() {
        if (first != null) {
            first = first.next;
        }
    }

    public int top() {
        if (first != null) return first.val;
        else return -1;
    }

    public int getMin() {
        return this.first.min;
    }
    
    private class StackNode {
        // Class that represents a single node in a Stack
        int val;
        int min;
        StackNode next;
        
        public StackNode (int val, int min) {
            this.val = val;
            this.min = min;
            next = null;
        }
        
        public StackNode (int val, int min, StackNode next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
    
    public static void main (String[] args) {
        MinStack minStack = new MinStack ();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        
    }
}