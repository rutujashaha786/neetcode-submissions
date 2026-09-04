class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int maxArea = Integer.MIN_VALUE;

        int left = 0;
        int right = n - 1;

        while(left < right){
            int height = Math.min(heights[left], heights[right]);
            int width = right - left;

            int area = height * width;
            maxArea = Math.max(area, maxArea);

            if(heights[left] < heights[right]){
                left++;
            }
            else{
                right--;
            }
        }

        return maxArea;
    }
}
