package amazon.practise.strings;

public class LongestPalindrome {

	public String longestPalnidrome(String s){
		
		if (s == null || s.isEmpty() || s.length() == 1){
			return s;
			
		}
		
		int start = 0;
		int maxLength = 0;
		for (int i = 0; i< s.length(); i++){
			
			// even length;
			int low = i-1;
			int high = i;
			while (low>=0 && high<s.length() && s.charAt(low) == s.charAt(high)){
				low --;
				high++;
				if (high-low > maxLength){
					start = low;
					maxLength = high-low;
				}
			}
			
			// odd length;
			low = i-1;
			high = i+1;
			while (low>=0 && high<s.length() && s.charAt(low) == s.charAt(high)){
				low --;
				high++;
				if (high-low > maxLength){
					start = low;
					maxLength = high-low;
				}
			}
		}
		return s.substring(start, start+maxLength);
	}
}
