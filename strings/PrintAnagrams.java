package amazon.practise.strings;

import java.util.Arrays;
import java.util.Comparator;
public class PrintAnagrams {

	private static class Anagram{
		String s;
		int index;
		
		public Anagram(String s, int index){
			this.s= s;
			this.index = index;
		}
		
		public void sortlettersWithinWord(){
			if (s == null){
				return;
			}
			char[] chars = s.toCharArray();
			Arrays.sort(chars,0,chars.length);
			this.s = new String(chars);
		}
	}
	
	private static class AnaComparator implements Comparator<Anagram>{

		@Override
		public int compare(Anagram arg0, Anagram arg1) {
		    if (arg0 == null && arg1 == null){
		    	return 0;
		    } else if (arg0 == null){
		    	return -1;
		    } else if (arg1 == null){
		    	return 1;
		    }
			return arg0.s.compareTo(arg1.s);
		}
		
	}
	public static String[] getAnagrams(String[] anagrams){
		if (anagrams == null || anagrams.length == 0){
			return anagrams;
		}
		Anagram[] words = new Anagram[anagrams.length];
		for (int i = 0; i< anagrams.length; i++){
			words[i] = new Anagram(anagrams[i],i);
			words[i].sortlettersWithinWord();
		}
		
		Arrays.sort(words,0, words.length,new AnaComparator());
		
		String[] ret = new String[anagrams.length];
		for (int i = 0; i< anagrams.length; i++){
			ret[i] = anagrams[words[i].index];
		}
		
		return ret;
		
	}
	
	public static void main(String[] args){
		String[] ret = PrintAnagrams.getAnagrams(new String[]{"cat","dog","act","tac","god"});
		for (int i = 0;i<ret.length; i++){
			System.out.println(ret[i]);
		}
	}
}
