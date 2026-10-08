class Solution {
    public String reverseWords(String s) {
        StringBuilder result= new StringBuilder();
        int right= s.length()-1;
             
        while(right>=0){
            while(right>=0 && s.charAt(right)==' '){
                right--;
            }
            if(right<0){
                break;
            }
            int left=right;
            while(left>=0 && s.charAt(left)!=' '){
                left--;
            }
            if(result.length()>0){
                result.append(' ');
            }
            result.append(s.substring(left+1,right+1));
            right=left-1;
        }
        return result.toString();
    }
}