class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;

    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        //Wrong
        // minSt.isEmpty() ? minSt.push(val) : minSt.push(Math.min(minSt.peek(), val));
        minSt.push(minSt.isEmpty() ? val : Math.min(minSt.peek(), val));
    }
    
    public void pop() {
        st.pop();
        minSt.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minSt.peek();
    }
}
