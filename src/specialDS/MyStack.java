class MyStack {

    Queue<Integer> q;
    Queue<Integer> holder;
    /** Initialize your data structure here. */
    public MyStack() {
        q = new LinkedList<>();
        holder = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        while (!q.isEmpty()) {
            holder.offer(q.poll());
        }
        q.offer(x);
        while (!holder.isEmpty()) {
            q.offer(holder.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return q.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
