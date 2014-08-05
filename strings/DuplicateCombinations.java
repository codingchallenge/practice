package amazon.practise.strings;

public class DuplicateCombinations {

	
	public void printCombinations(String s){
		printCombinations(s,"");
	}
	
	public void printCombinations(String s1, String s2){
		if (s1 == null){
			return;
		} else if (s1.length() == s2.length()){
			System.out.println(s2);
		} else {
			
			for (int i = 0; i<s1.length(); i++){
				
				s2 = s2+ Character.toString(s1.charAt(i));
				printCombinations(s1,s2);
				s2 = s2.substring(0,s2.length()-1);
			}
		}
	}
	
	
	public static void main(String[] args){
		DuplicateCombinations c = new DuplicateCombinations();
		c.printCombinations("AB");
		c.printCombinations("ABC");
	}
}
