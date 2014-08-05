package amazon.practise.strings;

import java.util.Comparator;
import java.util.Arrays;
public class SuffixArray {

	private static class Suffix{
		public int index;
		public int[] rank = new int[2];
		
		public Suffix(int index){
			this.index = index;
		}
	}
	
	private static class SuffixCompare implements Comparator<Suffix>{

		@Override
		public int compare(Suffix arg0, Suffix arg1) {
			if (arg0 == null && arg1 == null){
				return 0;
			} else {
				int ret = (arg0.rank[0] == arg1.rank[0]) ? ((arg0.rank[1] > arg1.rank[1]) ? 1 : -1) 
						: ((arg0.rank[0] > arg1.rank[0]) ? 1 : -1);
				return ret;
			}
	
		}
		
	}
	public int[] suffixArray(String s){
		
		Suffix[] sArray = new Suffix[s.length()];
		// First Store the ranks of the first two indexes;
		for (int i =0; i<s.length(); i++){
			sArray[i] = new Suffix(i);
			sArray[i].rank[0]= s.charAt(i) - 'a';
			sArray[i].rank[1] = i+1 < s.length() ? s.charAt(i+1)-'a' : -1;
		}
		Arrays.sort(sArray,0,s.length(),new SuffixCompare() );
		
		for (int i = 4; i<2*s.length() ; i = 2*i){
			int prevRank = sArray[0].rank[0];
			sArray[0].rank[0] = 0;
			int[] ind = new int[s.length()];
			
			ind[sArray[0].index]  = 0;
			for (int j = 1; j< sArray.length; j++){
				if (sArray[j].rank[0] == prevRank && sArray[j].rank[1] == sArray[j-1].rank[1]){
					prevRank = sArray[j].rank[0];
					sArray[j].rank[0] = sArray[j-1].rank[0];
				} else {
					prevRank = sArray[j].rank[0];
					sArray[j].rank[0] = sArray[j-1].rank[0]+1;
				
				}
				ind[sArray[j].index]= j;
			}
			
			for (int k = 0; k<sArray.length; k++){
				int nextIndex = sArray[k].index + i/2;
				sArray[k].rank[1] = nextIndex < sArray.length?sArray[ind[nextIndex]].rank[0] : -1;
			}
			
			Arrays.sort(sArray,0,s.length(),new SuffixCompare());
		}
		
		int[] ret = new int[sArray.length];
		
		for (int i = 0; i<s.length();i++){
			ret[i] = sArray[i].index;
		}
		
		return ret;
	}
	
	
	public static void main(String[] args){
		SuffixArray array = new SuffixArray();
		int[] intArray = array.suffixArray("banana");
		
		for (int i = 0; i< intArray.length; i++){
			System.out.println(intArray[i]);
		}
		
	}
}

