package amazon.practise.strings;

public class RemoveAdjacent {

	public String recursiveRemove(String s){
		if (s == null || s.isEmpty() || s.length() == 0){
			return null;
		} else{
			char c = s.charAt(0);
			System.out.println("Print "+ s.substring(1,s.length()));
			String s2 = recursiveRemove(s.substring(1,s.length()));
			if (s2 == null || s2.length() == 0){
				return String.valueOf(c);
			}
			
			System.out.println("Hello" + s2.length());
			if (s2.charAt(0) == c){
				return s2.substring(1,s2.length());
			} else {
				return (c + s2);
			}
		}
	}
	
	public static void main(String[] args){
		RemoveAdjacent a = new RemoveAdjacent();
		//System.out.println(a.recursiveRemove("azxxzy"));
		System.out.println(a.recursiveRemove("geeksforgeeg"));
	}
}
