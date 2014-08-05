package amazon.practise.strings;

public class StringMatch {

	public static boolean findPattern(String pattern, String origString){
		if (pattern == null && origString == null || (pattern.isEmpty() && origString.isEmpty())){
			return true;
		} else if (pattern == null && origString != null && !origString.isEmpty()){
			return false;
		} else if (pattern.isEmpty() && origString != null && !origString.isEmpty()){
			return false;
		} else if ((origString == null || origString.isEmpty())){
			return false;
		}
		
		else {
			if (pattern.charAt(0) != '.' && pattern.charAt(0) != origString.charAt(0)){
				return false;
			} else if (pattern.charAt(0) == '.' && !isAlpha(origString.charAt(0))){
				return false;
			}
			else if(pattern.length() > 1 && (pattern.charAt(1) == '*' || pattern.charAt(1) == '?')){
				if(pattern.charAt(1) == '*'){
					boolean ret = findPattern(pattern,origString.substring(1,origString.length()))
							     || findPattern(pattern.substring(2,pattern.length()), origString.substring(1,origString.length()));
					return ret;
					
				} else if (pattern.charAt(1)== '?'){
					String substr = pattern.charAt(0) + pattern.substring(2,pattern.length());
					boolean ret =  findPattern(pattern.substring(2,pattern.length()), origString.substring(1,origString.length()))
							   || findPattern(substr, origString.substring(1,origString.length()));
				
					return ret;
				}
			} else if (pattern.charAt(0) == '.' || (isAlpha(pattern.charAt(0)) && pattern.charAt(0) == origString.charAt(0) )){
				return findPattern(pattern.substring(1,pattern.length()), origString.substring(1,origString.length()));
			}
		}
		
		return false;
	}
	
	public static boolean isAlpha(char c){
		if ((c >= 'a' && c <= 'z')|| (c >='A' && c<='Z')){
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args){
		System.out.println(StringMatch.findPattern("abcdeg", "abcdeg"));
		System.out.println(StringMatch.findPattern("abcdef", "abcdeg"));
		System.out.println(StringMatch.findPattern("abcde.","abcdeg"));
		System.out.println(StringMatch.findPattern("a?cdeg","abcdeg"));
		System.out.println(StringMatch.findPattern("a*g","aaaaaag"));
		System.out.println(StringMatch.findPattern("a*g","bacde"));
		
	}
	
}
