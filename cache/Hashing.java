import java.util.ArrayList;
import java.util.HashMap;


public class Hashing {

	public static void main(String args[]) {
		
		
		ArrayList<String> s = new ArrayList<String>();
		s.add("All");
		s.add("Work");
		s.add("and");
		s.add("no");
		s.add("Work");
		s.add("fun");
		s.add("and");
		s.add("no");
		s.add("srorklu");
		s.add("Work");
		
		
	//	System.out.println(canPalindrom("a"));
	// kSuspicious(s,3);
		Cache<String,Integer> cache = Cache.getInstance(5);
		cache.put("hello", 1);
		cache.put("h", 2);
		cache.put("hel", 3);
		cache.put("hel2", 4);
		cache.put("hell", 5);
		cache.put("he", 6);
		System.out.println(cache.get("he"));
		
	}
	
	public static void kSuspicious(ArrayList<String> s, int k) {
		
		HashMap<String,ArrayList<Integer>> hash = new HashMap<String,ArrayList<Integer>>();
		int j =0;
		for(String c : s) {
			int len = c.length();
			for(int i=0; i+k<=len; i++ ) {
				String sub = c.substring(i, i+k);
				ArrayList<Integer> count = hash.get(sub);
				if(count == null) {
					ArrayList<Integer> node = new ArrayList<Integer>();
					node.add(j);
					hash.put(sub,node);
				}
				else {
					count.add(j);
					hash.put(sub,count);
				}
			}
			j++;
		}
		
		for(String key : hash.keySet()) {
			ArrayList<Integer> c = hash.get(key);
			System.out.println(key);
			for(Integer i : c) {
				System.out.println(s.get(i));
			}
			System.out.println("-----------");
		}
	}
	
	public static void closestStrings(ArrayList<String> s) {
		
		int min = Integer.MAX_VALUE;
		String r = null;
		Hash<String,Integer> h = new Hash<String,Integer>(31);
		
		for(int i=0; i < s.size(); i++) {
			String k = s.get(i);
			if(h.get(k) != null) {
				int index = h.get(k);
				int diff = i - index;
				if(diff < min) { 
					min = diff;
					r = k;
				}
				h.put(k, i);
			} else {
				h.put(k, i);
			}
		}
		
		System.out.println(min);
		System.out.println(r);
	}
	
	public static boolean canPalindrom(String s) {
		
		HashMap<Character,Integer> hash = new HashMap<Character,Integer>();
		
		char[] characters = new char[s.length()];
		s.getChars(0, s.length(), characters, 0);
		
		for(Character c : characters) {
			if(hash.get(c) == null)
				hash.put(c, 1);
			else {
				int count = hash.get(c) + 1;
				hash.put(c, count);
			}
		}
		
		int len = s.length();
		for(Character c : characters) {
			int count = hash.get(c);
			if(count % 2 != 0 && len % 2 == 0)
				return false;
			else if (count % 2 != 0 && len % 2 != 0) {
				len--;
			}
		}
	
		return true;
	}
}
