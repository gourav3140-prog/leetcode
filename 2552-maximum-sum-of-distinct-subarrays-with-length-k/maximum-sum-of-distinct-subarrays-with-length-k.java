class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        long n = nums.length;
        long sum = 0;
        long max_sum=0;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);

            if(right>=k){
                int left = nums[right-k];
                sum-=left;
                map.put(left,map.get(left)-1);

             if(map.get(left)==0){
                map.remove(left);
            }
            }
           
            if(right>=k-1 && map.size()==k){
                max_sum=Math.max(sum,max_sum);
            }
        }
        return max_sum;
    
    }
}