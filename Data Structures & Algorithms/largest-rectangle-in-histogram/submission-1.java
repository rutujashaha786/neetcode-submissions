class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = Integer.MIN_VALUE;

        int[] nse = nextSmaller(heights);
        int[] pse = PrevSmaller(heights);

        for(int i = 0; i < n; i++){
            int area = heights[i] * (nse[i] - pse[i] - 1);
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;

    }

    public int[] nextSmaller(int[] heights){
        int n = heights.length;
        int[] nse = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }

            if(st.isEmpty()){
                nse[i] = n;
            }
            else{
                nse[i] = st.peek();
            }

            st.push(i);
        }

        return nse;

     }

     public int[] PrevSmaller(int[] heights){
        int n = heights.length;
        int[] pse = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }

            if(st.isEmpty()){
                pse[i] = -1;
            }
            else{
                pse[i] = st.peek();
            }

            st.push(i);
        }

        return pse;

     }
}
