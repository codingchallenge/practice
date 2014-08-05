package amazon.practise.strings;

public class CountWords {

	public int countWords(String s){
		
		boolean out = false;
		int wc = 0;
		int i = 0;
		for (i = 0; i<s.length(); i++){
			if (s.charAt(i) == ' ' || s.charAt(i) == '\n' || s.charAt(i) == '\t'){
				out = false;
			} else {
				if (out == false){
				wc++;
				out = true;
				}
				
			}       
		}
		
		
		
		return wc;
	}
	
	public static void main(String[] args){
		CountWords words = new CountWords();
		System.out.println(words.countWords("Testing the word count method"));
	}
	
}
