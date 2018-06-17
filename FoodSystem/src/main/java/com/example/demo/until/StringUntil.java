package com.example.demo.until;

public class StringUntil {
	
	
	/**
	 * 如果是数字串，返回真
	 * @param str
	 * @return
	 */
	public static boolean StringOrNumber(String str){
		
		char[] chars=str.toCharArray();
		for (char c : chars) {
			if(!Character.isDigit(c)){
				return false;
			}
		}
		
		return true;
	}

}
