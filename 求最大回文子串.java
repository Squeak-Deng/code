class Solution {
	//给你一个字符串s，求出其中最大回文子串
    public String longestPalindrome1(String s) {	//方法一：动态规划：最主要找出其状态转移方程以及边界
        int start = 0, end = 1,maxlength = 1;
        if(s.length()<2)
        	return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        char[] ch = s.toCharArray();
        
        for(int i = 0;i < s.length(); i++)
        	dp[i][i] = true;
        
        for(int j = 1; j < s.length(); j++)
        	for(int i = 0 ; i < j ; i++) {
        		if(ch[i] == ch[j])
        		{
        			if(j - i < 3)
        				dp[i][j] = true;
        			else {
        				dp[i][j] = dp[i+1][j-1];
        			}
        		}else
        			dp[i][j] = false;
        		if(dp[i][j] && j-i+1>maxlength) {
        			start = i;
        			end = j;
        			maxlength = j-i+1;
        		}
        	}
    	return s.substring(start, end+1);
    }
    
    public String longestPalindrome(String s) {			//方法二：中间往外延伸
    	int start = 0, end = 0, max1 = 0, max2 = 0, length = 0;
    	char[] ch = s.toCharArray();
    	for(int i = 0; i<s.length()-1; i++) {
    		max1 = justice(ch,i,i+1);
    		max2 = justice(ch,i,i);
    		if(length < Math.max(max1, max2)) {
    			length = Math.max(max1, max2);
    			start = i-(length-1)/2;
    			end = i + length/2;
    		}
    		
    	}
    	return s.substring(start, end+1);
    }
    public int justice(char[] ch,int x,int y) {
    	int left = x, right = y;
    	while(left>=0 && right<ch.length && ch[left] == ch[right])
    	{
    		left--;
    		right++;
    	}
    	return right-left-1;
    }
    
    
    
}