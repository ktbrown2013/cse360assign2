/**
 *Kaden Brown
 *190
 *Assignment Number 2
 *Assignment Number 1
 *This class contains a constructor which creates a list (array of integers)
 * along with an integer representing the amount of elements it contains. 
 *Furthermore, the class also contains several methods that can be used to
 * manipulate the contents of the array, along with some that allow its contents to be read and output.
 * Changes have been made to the add method, allowing for the expansion of the array to include 
 * more indeces if overflow occurs, and the remove method, allowing for the deletion of empty 
 * indeces if more than 25% are empty towards the end. The append method allows for the addition of
 * elements at the end of the list, while the first method returns the first item in the list and
 * the size method returns the length of the current list. 
 * Github repository URL:
 * https://github.com/ktbrown2013/cse360assign2/tree/master/CSE360/src/cse360assign2
 */

package cse360assign2;

public class SimpleList {
	
	private int count;
	private int[] list; 
	private int currentLength;
	private int removalThreshhold;
	
	/**
	 * The constructor initializes the array to be 10 integers long.
	 * The count is initialized to 0, as the array is empty.
	 */
	public SimpleList() {
		list = new int[10];
		count = 0;
		currentLength = 10;
	}
	
	/**
	 * The add method takes an integer input and inserts it onto the left side of the array.
	 * All pre-existing elements are shifted to the right.
	 * If this would cause the array to overflow, the array capacity is increased by 50% to accomodate. 
	 * @param num
	 */
	public void add(int num) {
		if(count == currentLength) {
			currentLength = (int)(currentLength + (currentLength*.5));
			int[] newList = new int[currentLength];
			for(int index = 0; index < count; index++) {
				newList[index] = list[index];
			}
			list = newList;
		}
		for(int index = currentLength-1; index > 0; index--) {
			list[index] = list[index - 1];
		}
		list[0] = num;
		if (count < currentLength) {
			count = count + 1;
		}
	}
	
	/**
	 * The remove method takes an integer value and searches for and eliminates 
	 * each instance of the integer occurring in the array.
	 * The remaining elements are then shifted to the left if need be.
	 * If more than 25% of the values are empty places, the size of the list will be decreased.
	 * @param num
	 */
	public void remove(int num) {
		removalThreshhold = (int)(currentLength * .25);
		for(int index = 0; index < count; index++) {
			if(list[index] == num) {
				for(int jIndex = index; jIndex < count; jIndex++) {
					if(jIndex + 1 != currentLength) {
					list[jIndex] = list[jIndex + 1];
					}
					else {
						list[jIndex] = 0;
					}
				}
				count = count - 1;
			}
		}
		int countEmpty = currentLength-count;
		if(countEmpty >= removalThreshhold) {
			currentLength = currentLength-countEmpty;
			int[] newList = new int[currentLength];
			for(int index = 0; index < count; index++) {
				newList[index] = list[index];
			}
			list = newList;
		}
	}
	
	/**
	 * The count method returns the value of count, the amount of elements in the array.
	 * @return
	 */
	public int count() {
		return count;
	}
	
	/**
	 * The toString method takes each integer element in the array 
	 * and places them into a string separated by spaces.
	 */
	public String toString() {
		String listToString = "";
		for(int index = 0; index < count; index++) {
			if(index == 0) {
				listToString = String.valueOf(list[index]);
			}
			else{
				listToString = listToString + " " + String.valueOf(list[index]);
			}
		}
		return listToString;
	}
	
	/**
	 * The search method will attempt to find the index of the specified
	 * integer and return it; if it cannot be found then "-1" will be returned.
	 * @param num
	 * @return
	 */
	public int search(int num) {
		for(int index = 0; index < count; index++) {
			if(num == list[index]) {
				return index;
			}
		}
		return -1;
	}
	
	/**
	 * This method allows for the use of the private list in the testing class.
	 * @return
	 */
	public int[] getList() {
		return list;
	}
	
	/**
	 * This method appends the given value to the end of the list. If this would cause the 
	 * list to overflow, the list size will be increased by 50%. 
	 * @param num
	 */
	public void append(int num) {
		if(count < currentLength-1) {
			list[count] = num;
			count++;
		}
		else {
			currentLength = (int)(currentLength + (currentLength*.5));
			int[] newList = new int[currentLength];
			for(int index = 0; index < count; index++) {
				newList[index] = list[index];
			}
			list = newList;
			list[count] = num;
			count++;
		}
	}
	
	/**
	 * This method returns the first element of the list.
	 * @return
	 */
	public int first() {
		return list[0];
	}
	
	/**
	 * This method returns the current number of possible locations in the list. 
	 * @return
	 */
	public int size() {
		return currentLength;
	}
	
}
