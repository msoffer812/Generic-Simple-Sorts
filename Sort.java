package genericSorting;

import java.util.Comparator;

public class Sort<T> implements Sorter<T>{
	protected Comparator<T> comparator;			 /*Comparator for sorting*/
	protected StringBuilder comparisonsAsString; /*Holds all the comparisons made as a string*/
	protected int swaps;						 /*amount of swaps made in a given sort*/
	protected int comparisons;					 /*amount of comparisons made in a given sort*/
	
	/**
	 * Constructor if the user wants to input their custom comparator
	 * @param array
	 * @param comparer
	 */
	public Sort(Comparator<T> comparator) {
		this.comparator = comparator;
		comparisons = 0;
		swaps = 0;
		comparisonsAsString = new StringBuilder();
	}
	
	/**
	 * Default no-arg constructor that sets the comparator to
	 * natural ordering using a lambda expression
	 */
	@SuppressWarnings("unchecked")
	public Sort() {
		this.comparator = (a, b) -> ((Comparable<T>)a).compareTo(b);
		comparisons = 0;
		swaps = 0;
		comparisonsAsString = new StringBuilder();
	}
	
	/**
	 * @return the amount of comparisons
	 * made in the most recent sort
	 */
	@Override
	public int getAmountOfComparisons() {
		return this.comparisons;
	}
	
	@Override
	public int getAmountOfSwaps() {
		return this.swaps;
	}
	
	@Override
	public String getComparisons() {
		return this.comparisonsAsString.toString();
	}
	
	/**
	 * method that employs a sort to sort the array -
	 * dummy method that is overridden by children
	 */
	@Override
	public void sort(T[] array) {
	}
	
	/**
	 * helper method that swaps the values
	 * at the given index, necessary for the search
	 * @param indexA
	 * @param indexB
	 */
	protected void swap(int indexA, int indexB, T[] array) {
		T temp = array[indexA];
		array[indexA] = array[indexB];
		array[indexB] = temp;
		this.swaps++;
	}
	/**
	 * Reset all the stats to 0 when sorting again
	 */
	protected void resetStats() {
		this.swaps = 0;
		this.comparisons = 0;
		this.comparisonsAsString = new StringBuilder();
	}
	/**
	 * save the current comparison in the string representation
	 * of the comparisons for the sort 
	 * @param a
	 * @param b
	 * @param indexA
	 * @param indexB
	 */
	protected void saveComparison(T a, T b, int indexA, int indexB) {
		comparisons++;
		comparisonsAsString.append("Comparing " + a.toString() + " at index " + indexA + " to " + b.toString() + " at index " + indexB + "\n");
	}
}
