class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }

        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();

        for(char ch: t.toCharArray()){
            need.put(ch,need.getOrDefault(ch,0)+1);
        }

        int left=0;
        int minlen=Integer.MAX_VALUE;
        int start=0;
        int formed=0;
        int required= need.size();

        for(int right=0;right<s.length();right++){
            char ch = s.charAt(right);
            window.put(ch,window.getOrDefault(ch,0)+1);

            if(need.containsKey(ch)&& window.get(ch).intValue() == need.get(ch).intValue()){
                formed++;
            }
            while(formed==required){
                int len = right-left+1;

                if(len<minlen){
                    minlen=len;
                    start=left;
                }

                char charleft = s.charAt(left);
                window.put(charleft,window.get(charleft)-1);

                 if(need.containsKey(charleft) && window.get(charleft)<need.get(charleft)){
                formed--;
            }
            left++;
            }
        }
         if(minlen == Integer.MAX_VALUE){
                return "";
            }
            return s.substring(start,start+minlen);
    }
     
}