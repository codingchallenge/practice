package audible.catalog.maps;

import java.util.Map;
import java.util.HashMap;

public class ContigiousSequence {

	private static int getLengthOfSequence(String[] input, String[] toFind){
		if (input == null || input.length == 0 || toFind == null || toFind.length == 0){
			return -1;
		}
		Map<String,Integer> shorterMap = new HashMap<String,Integer>();
		int[] lastIndex = new int[toFind.length];
		int[] lengthOfSequence = new int[toFind.length];
		
		for (int i = 0; i< toFind.length; i++){
			shorterMap.put(toFind[i], i);
			lastIndex[i] = -1;
			lengthOfSequence[i] = -1;
		}
		
		int minLength = input.length;
		for (int i = 0; i<input.length; i++){
			if (shorterMap.get(input[i]) != null){
				int j = shorterMap.get(input[i]);
				lastIndex[j] =i;
				if (j == 0){
					lengthOfSequence[j] = 0;
				} 
				else if (lastIndex[j-1] != -1 && lastIndex[j-1] < lastIndex[j] && lengthOfSequence[j-1]  != -1){
					lengthOfSequence[j] = i-lastIndex[j-1] + lengthOfSequence[j-1];
				}
				if (j == toFind.length -1){
					if (lengthOfSequence[j] < minLength){
						minLength = lengthOfSequence[j];
					}
				}
			}
		}
		return minLength;
		}
}
