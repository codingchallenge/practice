package amazon.practise.stack;

public class StringFunctions {

	public static  String reverseString(String a){
		if (a== null){
			return a;
		} else {
			char[] charArray = a.toCharArray();
			int mid = charArray.length/2;
			int j = charArray.length -1;
			for (int i = 0; i< mid; i++){
				swap(i, j, charArray);
				
				j--;
			}
			return new String(charArray);
		}
	
	}
	
	public static void swap(int i, int j, char[] charArray){
		char temp = charArray[j];
		charArray[j] = charArray[i];
		charArray[i] = temp;
	}
	
	public static int atoi(String s){
		if (s == null || s.isEmpty()){
			throw new RuntimeException("Invalid Input");
		}
		char[] charArray = s.toCharArray();
		int tens = 1;
		int ret = 0;
	
		for(int i = charArray.length-1; i >= 0; i--){
			System.out.println(charArray[i]);
			int num = Character.getNumericValue(charArray[i]);
			if (num < 0 || num > 9){
				throw new RuntimeException("Exception occurred while processing input");
			}
			ret = ret + num*tens;
			tens = tens*10;
		}
		
		return ret;
	}
	public static void main(String[] args){
		
		String name = "divya";
		System.out.println(StringFunctions.reverseString("divya"));
		System.out.println(StringFunctions.reverseString(""));
		System.out.println(StringFunctions.reverseString("d"));
		
		System.out.println(StringFunctions.atoi("12345"));
		System.out.println(StringFunctions.atoi("123.45"));
	}
}
