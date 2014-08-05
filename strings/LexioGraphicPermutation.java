package amazon.practise.strings;

import java.util.Arrays;

public class LexioGraphicPermutation {

	public void lexioGraphicPermutations(String a){
		printPerm(a.toCharArray(),0, a.length()-1);
	}
	
	public static void main(String[] args){
		LexioGraphicPermutation perm = new LexioGraphicPermutation();
		perm.lexioGraphicPermutations("ABC");
	}
	public void printPerm(char[] arr, int s, int e){
		
		
		if (arr == null){
			return;
		}else if (s > e){
			System.out.println(new String(arr));
		}else {
			char[] sorted = new char[e-s+1];
			for (int i = s; i<= e;i++){
				sorted[i-s] = arr[i]; 
			}
			Arrays.sort(sorted,0,sorted.length);
			for (int i = s; i<=e; i++){
				int k = findInArray(sorted[i-s],arr,s,e);
				swap(arr,s,k);
				printPerm(arr,s+1,e);
				swap(arr,k,s);
			}
		}
	}
	
	public int findInArray(char c, char[] arr,int s, int e){
		for (int i =s;i<=e;i++){
			if (arr[i] == c){
				return i;
			}
		}
		return -1;
	}
	public int findMin(int start, int end, char[] arr){
		int min = 400;
		int minIndex = 0;
		for (int i = start; i<=end; i++){
			//System.out.println(arr[i]-'0');
			if (arr[i]-'0' <min){
				minIndex=i;
				min= arr[i]-'0';
			}
		}
		return minIndex;
	}
	
	public void swap(char[] array, int start, int end){
		char c = array[end];
		array[end] = array[start];
		array[start] =c ;
	}
}
