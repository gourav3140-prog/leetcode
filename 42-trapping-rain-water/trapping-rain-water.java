class Solution {
    public int trap(int[] height) {
        int left=0;
        int right=height.length-1;

        int water=0;
        int leftmost=height[left];
        int rightmost=height[right];

        while(left<right){
            if(leftmost<rightmost){
                left++;
               leftmost= Math.max(leftmost,height[left]);
                water+=leftmost-height[left];}
                else{
                    right--;
                   rightmost = Math.max(rightmost,height[right]);
                    water+=rightmost-height[right];
                }
                 }
        
        return water;
    }
}