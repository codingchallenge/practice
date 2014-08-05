package amazon.practise.strings;

import java.util.Arrays;

public class LexioGraphicNumber {

	public int lexNumber(String s){
		char[] arr = s.toCharArray();
		char[] sorted = s.toCharArray();
		Arrays.sort(sorted,0,sorted.length);
		return lexNumberRec(s)+1;
	
		
		
	}
	
	public int lexNumberRec(String s){
		if (s == null || s.length() == 0){
			return 0;
		} else {
			char[] sorted = s.toCharArray();
			Arrays.sort(sorted,0,sorted.length);
			int index = findChar(sorted,s.charAt(0) );
			return (index*findFact(s.length()-1) + lexNumberRec(s.substring(1,s.length())));
		}
		
	}
	
	public int findChar(char[] sort,char c){
		for (int i = 0; i<sort.length;i++){
			if (sort[i] ==c){
				return i;
			}
		}
		return -1;
	}
	
	public int findFact(int n){
		if (n == 0){
			return 0;
		}
		int tot = 1;
		while (n>0){
			tot = tot*n;
			n = n-1;
		}
		return tot;
	}
	
	public static void main(String[] args){
		LexioGraphicNumber n = new LexioGraphicNumber();
		System.out.println(n.lexNumber("CBA"));
	}
}
