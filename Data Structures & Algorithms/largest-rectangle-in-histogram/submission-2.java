class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = Integer.MIN_VALUE;

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int height = heights[st.pop()];
                int nse = i;
                // int pse = st.peek(); ---exception will throw
                int pse = st.isEmpty() ? -1 : st.peek();

                int area = height * (nse - pse - 1);
                maxArea = Math.max(maxArea, area);
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int height = heights[st.pop()];
            int nse = n;
            int pse = st.isEmpty() ? -1 : st.peek();

            int area = height * (nse - pse - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
