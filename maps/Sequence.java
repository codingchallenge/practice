package audible.catalog.maps;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

public class Sequence {

	String[] array;
	
	public Sequence(String[] array){
		this.array = array;
	}
	
	
	private static class coordinates{
		int start;
		int end;
		
		public coordinates(int start, int end){
			this.start = start;
			this.end = end;
		}
	}
	public coordinates getSmallestContainingCoordinates(List<String> input){
		
		Map<String,Integer> countMap = new HashMap<String,Integer>();
		int start = 0;
		int end = -1;
		int minStart = 0;
		int minEnd = 0;
		for(int i=0; i< array.length; i++){
			if (input.contains(array[i])){
				if (countMap.size() == 0){
					start = i;
					
					countMap.put(array[i], 1);
				} else {
					if (countMap.containsKey(array[i])){
						int value = countMap.get(array[i]);
						countMap.put(array[i],value);
					} else {
						countMap.put(array[i], 1);
					}
					
				}
				
				if (countMap.size() == input.size()){
					end = i;
					if((minStart == 0 && minEnd== 0) || (minEnd-minStart) > (end-start)){
						minStart = start;
						minEnd  = end;
					}
					
					for (int k = start; k<=end;k++){
						if (input.contains(array[k])){
							int value = countMap.get(array[k]);
							if (value == 1){
								countMap.remove(array[k]);
								start = k;
								break;
							} else {
								countMap.put(array[k], value-1);
								minStart = k;
								start = k;
							}
						}
					}
					
					
				}
				
			}
		}
		
		for (int k = start; k<=end;k++){
			if (input.contains(array[k])){
				int value = countMap.get(array[k]);
				if (value == 1){
					countMap.remove(array[k]);
					start = k;
					break;
				} else {
					countMap.put(array[k], value-1);
					minStart = k;
					start = k;
				}
			}
		}
		return new coordinates(minStart, minEnd);
	}
}
