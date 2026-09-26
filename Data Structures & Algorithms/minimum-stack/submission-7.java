class MinStack {
    Stack<Long> st;
    long min;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push((long) val);
            min = val;
            return;
        }
        if((long) val > min){
            st.push((long) val);
        }
        else{
            st.push((long) val + (long)val - min);
            min = val;
        }
    }
    
    public void pop() {
        if(st.peek() < min){
            //revert point for min
            min = 2 * min - st.peek();
        }
        st.pop();
    }
    
    public int top() {
        if(st.peek() < min){
            return (int)min;
        }
        else{
            return (int)(long) st.peek();
        }
    }
    
    public int getMin() {
        return (int) min;
    }
}
