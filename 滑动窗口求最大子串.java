public class Test {
	    public static int lengthOfLongestSubstring(String s) {
	        int[] last  = new int[128];
	        int index,max=0,start=0;		//max代表窗口目前的最大值，start代表当前窗口的起始位置
	        
	        for(int i = 0 ; i < 128  ; i++)
	        	last[i] = -1;
	        
	        for(int i = 0 ; i < s.length() ; i++) {
	        	index = s.charAt(i);
	        	start = Math.max(start, last[index]+1);
	        	max = Math.max(max, i-start+1);
	        	last[index] = i;
	        }
	        return max;
	    }
	
	public static void main(String args[]) {
		 	System.out.println(lengthOfLongestSubstring("abcabcbb"));
		}
}
