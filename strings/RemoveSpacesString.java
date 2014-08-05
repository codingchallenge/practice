package amazon.practise.strings;

import java.util.Arrays;
import java.io.Externalizable;
import java.io.Serializable;
public class RemoveSpacesString implements Serializable{

	public static String removeSpacesString(String string){
		if (string == null || string.isEmpty()){
			return string;
		}  else {
			char[] charArray = string.toCharArray();
			int length = charArray.length;
			int i = charArray.length-1;
			while (i>=0){
				if (charArray[i] == ' ' || charArray[i] == '\t'){
					int j= i;
					while (j >=0 && (charArray[j] == ' ' || charArray[j] == '\t')){
						j--;
					}
					int k = i+1;
					int last = j+1;
					while (k<length){
						charArray[last++]= charArray[k++]; 
					}
					length = last;
					i = j;
				}else {
					i--;
				}
				
			}
			char[] newArray = Arrays.copyOfRange(charArray,0,length);
			return new String(newArray);
			
		}
		
	}
	
	
	public static void main(String[] args){
		String charArray = "Divya Is  A Good Girl";
		System.out.println(RemoveSpacesString.removeSpacesString(charArray));
		System.out.println(RemoveSpacesString.removeSpacesString("     Testing      for spaces"));
		System.out.println(RemoveSpacesString.removeSpacesString("   ").length());
		
	}
}
