package audible.catalog.maps;

import java.util.Map;
import java.util.HashMap;

public class LongestSubArray {

	public static <T extends Comparable<T>>  int getLongestLengthSubSequence(T[] array){
		Map<T,Integer> map = new HashMap<T,Integer>();
		int startIndex = 0, endIndex=0, length= 0;
		int maxStart = 0, maxEnd = 0;
		for (int i = 0; i < array.length;i++){
			if (map.get(array[i]) != null){
				endIndex = i-1;
				if ((endIndex-startIndex)+1 > length){
					length = (endIndex-startIndex)+1;
					maxStart=startIndex;
					maxEnd = endIndex;
				} 
				startIndex = map.get(array[i]) +1;
				
				
			} else if (map.isEmpty()){
				startIndex = 0;
				
			} 
			map.put(array[i],i);
			endIndex = i;
		}
		if ((endIndex-startIndex)+1 > length){
			length = (endIndex-startIndex)+1;
			maxStart = startIndex;
			maxEnd = endIndex;
		}
		return length;
	}
	
	
	
	public static void main(String[] args){
		Integer[] array1 = {1,2,3,4,5,6};
		int length = LongestSubArray.getLongestLengthSubSequence(array1);
		System.out.println(length);
		
		Integer[] array2 = {1,2,1,3,4,5};
		System.out.println(LongestSubArray.getLongestLengthSubSequence(array2));
		
		Integer[] array3 = {1,1,1,1,1,1};
		System.out.println(LongestSubArray.getLongestLengthSubSequence(array3));
		
	}
}
