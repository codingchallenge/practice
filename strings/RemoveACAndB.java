package amazon.practise.strings;

public class RemoveACAndB {

	public String removeACAndB(String s){
		if (s== null || s.isEmpty()){
			return s;
		} else if (s.length() > 1 && s.charAt(0) == 'a' && s.charAt(1) == 'c'){
				return removeACAndB(s.substring(2));
			
		}else if(s.charAt(0) == 'b'){
				return removeACAndB(s.substring(1));
		} else {
			return String.valueOf(s.charAt(0)) + removeACAndB(s.substring(1));
		}
 		
	}
	
	public static void main(String[] args){
		RemoveACAndB r = new RemoveACAndB();
		System.out.println(r.removeACAndB("acbac"));
		System.out.println(r.removeACAndB("aaac"));
		
	}
}
