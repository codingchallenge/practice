package amazon.practise.strings;

public class NextPermutationLexioGraphic {

	public String nextPermutation(String s){
		if (s == null || s.isEmpty()){
			return s;
		}
		int index = findFirstLessThanIndexFromBack(s);
		if (index == -1){
			return null;
		}
		int nextGreatestIndex = findNextGreatestIndexToRight(index, s);
		// swap the characters;
		String s2 = swap(s, index, nextGreatestIndex);
		return sortInIncreasingOrderAfterIndex(s2, index);
		
	}
}
