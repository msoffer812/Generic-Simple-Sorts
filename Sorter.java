package genericSorting;

public interface Sorter<T>{
	public void sort(T[] array); 		 /* Sorts the given array*/
	public int getAmountOfComparisons(); /* returns the number of comparisons after the most recent sort */
	public String getComparisons();		 /* return the string representations of all the comparisons made in the most recent sort*/
	public int getAmountOfSwaps();		 /* return the amount of swaps made in a given sort*/
}
