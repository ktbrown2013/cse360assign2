/**
 *Kaden Brown
 *190
 *Assignment Number 2
 *This class contains tests using assert statements to determine if each method of the 
 *SimpleList class functions as intended.Each method is supplied a success and failure test, 
 *testing whether or not they operate as they should and whether they fail under those conditions respectively. 
 */

package cse360assign2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cse360assign2.SimpleList;

class SimpleListTest {

	/**
	 * This test validates whether or not the constructor actually creates an object.
	 */
	@Test
	public void testConstructorSuccess() {
		SimpleList testList = new SimpleList();
		assertNotNull(testList);
	}
	
	/**
	 * The testConstructorFailure test validates whether or not 
	 * the "count" variable has been properly initialized.
	 */
	@Test
	public void testConstructorFailure() {
		SimpleList testList = new SimpleList();
		assertNotEquals(testList.count(),1);
	}
	
	/**
	 * The addSuccess test tells whether or not the indeces of the elements will be 
	 * properly incremented with the addition of new integers.
	 */
	@Test
	public void addSuccess() {
		SimpleList testList = new SimpleList();
		testList.add(1);
		testList.add(2);
		testList.add(3);
		assertEquals(testList.getList()[2],1);
	}
	
	/**
	 * The addSuccess test tells whether or not the indeces of the elements will be 
	 * properly incremented, with new indeces being added. 
	 */
	@Test
	public void addSuccessUpdated() {
		SimpleList testList = new SimpleList();
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		testList.add(5);
		testList.add(6);
		testList.add(7);
		testList.add(8);
		testList.add(9);
		testList.add(10);
		testList.add(11);
		assertEquals(testList.getList()[10],1);
	}
	
	/**
	 * The addFailureUpdated test tells whether or not the insertion of an element
	 * beyond the current array size will properly increase the size of the list.
	 */
	@Test 
	public void addFailureUpdated() {
		SimpleList testList = new SimpleList();
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		testList.add(5);
		testList.add(6);
		testList.add(7);
		testList.add(8);
		testList.add(9);
		testList.add(10);
		testList.add(11);
		assertNotEquals(testList.getList().length,10);
	}
	
	/**
	 * The addFailure test determines that after overflow of the bounds of the 
	 * array has been achieved, the first added item will be tossed out.
	 */
	@Test 
	public void addFailure() {
		SimpleList testList = new SimpleList();
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		testList.add(5);
		testList.add(6);
		testList.add(7);
		testList.add(8);
		testList.add(9);
		testList.add(10);
		testList.add(11);
		assertNotEquals(testList.getList()[9],1);
	}
	
	/**
	 * The removeSuccess test determines if the removal method is correctly removing
	 * the desired element(s) and re-aligning the remaining integers properly.
	 */
	@Test
	public void removeSuccess() {
		SimpleList testList = new SimpleList();
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		testList.remove(2);
		assertEquals(testList.getList()[2],1);
	}
	
	/**
	 * The removeSuccessUpdated test determines whether or not the method correctly
	 * can delete empty indeces if more than 25% are empty. 
	 */
	@Test
	public void removeSuccessUpdated() {
		SimpleList testList = new SimpleList();
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		testList.remove(2);
		assertEquals(testList.getList().length,3);
	}
	
	/**
	 * The removeFailure test works to demonstrate the ability of the remove method
	 * to correctly increment remaining elements into their proper positions after removal.
	 */
	@Test
	public void removeFailure() {
		SimpleList testList = new SimpleList();
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		testList.remove(2);
		assertNotEquals(testList.getList()[2],2);
	}
	
	/**
	 * The removeFailureUpdated test determines whether or not the method is still capable of 
	 * making deletions after the changes to the method that allow it to delete empty indeces. 
	 */
	@Test
	public void removeFailureUpdated() {
		SimpleList testList = new SimpleList();
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		testList.add(5);
		testList.add(6);
		testList.remove(3);
		assertNotEquals(testList.getList()[3],3);
	}
	
	/**
	 * The countSuccess test demonstrates the efficacy of the count method which 
	 * returns the count of the amount of elements in the array.
	 */
	@Test
	public void countSuccess() {
		SimpleList testList = new SimpleList();
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		testList.remove(4);
		assertEquals(testList.count(),3);
	}
	
	/**
	 * The count failure test demonstrates further that the method is capable
	 * of accurately keeping count of the amount of elements. 
	 */
	@Test
	public void countFailure() {
		SimpleList testList = new SimpleList();
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		testList.add(5);
		assertNotEquals(testList.count(),4);
	}
	
	/**
	 * The toStringSuccess test shows that the toString method accurately
	 * writes each of the elements in the array to a singular string.
	 */

	@Test
	public void toStringSuccess() {
		SimpleList testList = new SimpleList();
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		testList.add(5);
		assertEquals(testList.toString(),"5 4 3 2 1");
	}
	
	/**
	 * The toStringFailure test further demonstrates the reliability of the
	 * toString method.
	*/
	@Test
	public void toStringFailure() {
		SimpleList testList = new SimpleList();
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		testList.add(5);
		assertNotEquals(testList.toString(),"5 4 3 2");
	}
	
	/**
	 * The searchSuccess test shows that the search method can 
	 * properly identify the index of the desired element. 
	 */
	@Test
	public void searchSuccess() {
		SimpleList testList = new SimpleList();
		testList.add(1);
		testList.add(2);
		testList.add(3);
		assertEquals(testList.search(2),1);
	}
	
	/**
	 * The searchFailure method demonstrates further that the method search
	 * is reliable.
	 */
	@Test
	public void searchFailure() {
		SimpleList testList = new SimpleList();
		testList.add(1);
		testList.add(2);
		testList.add(3);
		assertNotEquals(testList.search(2),2);
	}
	
	/**
	 * The appendSuccess test determines whether the method can correctly
	 * add the intended element to the end of the list. 
	 */
	@Test
	public void appendSuccess() {
		SimpleList testList = new SimpleList();
		testList.append(1);
		testList.append(2);
		testList.append(3);
		testList.append(4);
		testList.append(5);
		assertEquals(testList.search(4),3);
	}
	
	/**
	 * The appendFailure test determines whether the append method can
	 * increase the size of the list if overflow occurs
	 */
	@Test
	public void appendFailure() {
		SimpleList testList = new SimpleList();
		testList.append(1);
		testList.append(2);
		testList.append(3);
		testList.append(4);
		testList.append(5);
		testList.append(1);
		testList.append(2);
		testList.append(3);
		testList.append(4);
		testList.append(5);
		testList.append(1);
		testList.append(2);
		testList.append(3);
		testList.append(4);
		testList.append(5);
		assertNotEquals(testList.getList().length,10);
	}
	
	/**
	 * The firstSuccess test determines if the method returns 
	 * the first element in the list
	 */
	@Test
	public void firstSuccess() {
		SimpleList testList = new SimpleList();
		testList.append(1);
		testList.append(2);
		testList.append(3);
		testList.append(4);
		testList.append(5);
		assertEquals(testList.first(),1);
	}
	
	/**
	 * The firstFailure test determines if the first method is 
	 * capable of dealing with shifts in the length of the list.
	 */
	@Test
	public void firstFailure() {
		SimpleList testList = new SimpleList();
		testList.append(1);
		testList.append(2);
		testList.append(3);
		testList.append(4);
		testList.append(5);
		testList.remove(1);
		assertNotEquals(testList.first(),1);
	}
	
	/**
	 * The sizeSuccess test determines if the method is able to correctly
	 * return the size of the list.
	 */
	@Test
	public void sizeSuccess() {
		SimpleList testList = new SimpleList();
		testList.append(1);
		testList.append(2);
		testList.append(3);
		testList.append(4);
		testList.append(5);
		assertEquals(testList.size(),10);
	}
	
	/**
	 * The sizeFailure test determines if the method can correctly
	 * return the size of the list after manipulation. 
	 */
	@Test
	public void sizeFailure() {
		SimpleList testList = new SimpleList();
		testList.append(1);
		testList.append(2);
		testList.append(3);
		testList.remove(2);
		for(int i = 0;i < testList.getList().length; i++) {
			System.out.print(testList.getList()[i]+" ");
		}
		assertNotEquals(testList.size(),10);
	}
}
