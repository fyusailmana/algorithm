package jason.algorithm.sort;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BinarySearch extends TestSetup {
	
	public static int binarySearch(int[] input, int value){
		if (input.length==0){
			return 0;
		}
		return binarySearch(input, 0, input.length-1, value);
	}
	
	/*
	 * Return the first index that has a value larger than value.
	 * 
	 * To ensure sort is stable, any input with value=value should be left side. 
	 * 
	 */
	public static int binarySearch(int[] input, int startIndex, int endIndex, int value){
		
		
		//end case
		if (startIndex==endIndex){
			if (input[startIndex]<=value){
				return startIndex+1;
			} else {
				return startIndex;
			}
		}
		
		//when we come here: endIndex-startIndex>1
		int middle=(int) Math.floor( ((double)startIndex)/2 +((double)endIndex)/2 );
		//Here middle >=startIndex
		
		//is the middle the one we want?
		if (input[middle]<=value){
			//middle can not be since middle is not larger than right.
			return binarySearch(input, middle+1, endIndex, value);
		} else {
			return binarySearch(input, startIndex, middle, value);
		}
	}
	
	
	
	@Test
	public void testBinarySearchOneElement() {
		assertThat(BinarySearch.binarySearch( new int[]{2}, 1), equalTo(0));
		assertThat(BinarySearch.binarySearch( new int[]{2}, 3), equalTo(1));
		
		assertThat(BinarySearch.binarySearch( new int[]{2, 2}, 1), equalTo(0));
		assertThat(BinarySearch.binarySearch( new int[]{2, 2}, 2), equalTo(2));
		
		assertThat(BinarySearch.binarySearch( new int[]{2, 4}, 2), equalTo(1));
		
		assertThat(BinarySearch.binarySearch( new int[]{2, 4}, 3), equalTo(1));
		
		assertThat(BinarySearch.binarySearch( new int[]{2, 4}, 5), equalTo(2));
		
		
	}
	
	@Test
	public void testBinarySearch() {
		input=new int[inputLen];
		for (int i=0; i<inputLen; i++) {
			input[i]=i;
		}
		int[] needles= {0, 20, 100, 200, 855,  1000, 101, 102, 103, inputLen-1};
		for (int needle: needles) {
			int j=BinarySearch.binarySearch(input, 0, inputLen-1, needle);
			assertThat(needle, equalTo(input[j-1]));
		}
	}
	
}
