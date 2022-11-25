/**
232. Implement Queue using Stacks

Note: .isEmpty() also can write .empty() 
*/

class MyQueue {
    
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue() {
        // initialize the stackIn and stackOut
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }
    
    // insert element.
    public void push(int x) {
        stackIn.push(x);
    }
    
    //  Removes the element from in front of queue and returns that element.
    public int pop() {
        dumpStackIn();
        return stackOut.pop();
    }
    
    public int peek() {
        dumpStackIn();
        return stackOut.peek();
    }
    
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
    
    
    public void dumpStackIn() {
        if (!stackOut.isEmpty()) return;
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
    }
}






/**
225. Implement Stack using Queues

*/
class MyStack {
    Queue<Integer> q;
        
    public MyStack() {
         q = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q.add(x);
        int sz = q.size();
        
        while(sz-- > 1) {
            q.add(q.remove());
        }
        
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q.remove();
    }
    
    /** Get the top element. */
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}