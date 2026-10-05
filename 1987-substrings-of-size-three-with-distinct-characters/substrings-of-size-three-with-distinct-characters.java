class Solution {
    public int countGoodSubstrings(String s) {
        
        HashMap<Character,Integer> map = new HashMap<>();
        int k = 3;
      int result = 0;
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);

            if(right>=k){
                char left = s.charAt(right-k);
                map.put(left,map.get(left)-1);

                if(map.get(left)==0){
                    map.remove(left);
                }
            }
            if(right>=k-1 && map.size()==k){
               
                result++;
            }
        }
        return result;
    }
}