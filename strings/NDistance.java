package amazon.practise.strings;

import java.util.Map;
import java.util.HashMap;
public class NDistance {

	public String getNDistanceString(String s){
		char[] cA = s.toCharArray();
		Map<Character,Integer> m = new HashMap<Character,Integer>();
		for (int i = 0; i< cA.length; i++){
			if (!m.containsKey(cA[i])){
				m.put(cA[i], 1);
			} else {
				int val = m.get(cA[i]);
				m.put(cA[i], val+1);
			}
		}
		
		
	}
}
