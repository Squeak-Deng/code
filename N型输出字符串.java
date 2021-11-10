class Solution {
	//N型输出字符串
	 public String convert(String s, int numRows) {
			if(s.length()<numRows)
				return s;
	        if(numRows == 1)
	            return s;
	        List<StringBuilder> rows = new ArrayList<>();
	        for(int i = 0 ; i < numRows ; i++) {
	        	StringBuilder s1 = new StringBuilder();
	        	rows.add(s1);
	        }
	        
	        
	        int index = 0;
	        boolean down = true;
	        for(char ch:s.toCharArray()) {
	        	rows.get(index).append(ch);
	        	if(down)
	        		index++;
	        	else
	        		index--;
	        	if(index == numRows) {
	        		index-=2;
	        		down = false;
	        	}
	        	if(index == -1) {
	        		index+=2;
	        		down = true;
	        	}
	        }
	        
	        StringBuilder temp = new StringBuilder();
	        for(StringBuilder ss:rows) {
	        	temp.append(ss);
	        }
	        return temp.toString();
	    }
}