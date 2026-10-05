class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       
        Deque<Integer> d = new ArrayDeque<>();
        int n =nums.length;
        int[] result= new int[n-k+1];
        int index =0;
        for(int right=0;right<n;right++){

            while(!d.isEmpty()&& d.peekFirst()<=right-k){
                d.pollFirst();
            }
            while(!d.isEmpty() && nums[d.peekLast()]<=nums[right]){
                d.pollLast();
            }
            d.offerLast(right);

            if(right>=k-1){
             result[index++]=nums[d.peekFirst()];
            }
        
    }
    return result;
}
}