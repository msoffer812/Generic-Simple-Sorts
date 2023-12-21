package genericSorting;

import java.util.Comparator;

public class SelectionSort <T> extends Sort<T>{
	public SelectionSort() {
		super();
	}
	
	public SelectionSort(Comparator<T> comparator) {
		super(comparator);
	}
	/**
	 * method that employs a selectionSort to sort the algorithm
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void sort(T[] array) {
		/*
		 * Call the method to reset all the stats
		 * for the sort
		 */
		resetStats();
		for(int start=0; start<array.length; start++) {
			int minIndex = start;
			for(int currIndex=start+1; currIndex<array.length; currIndex++) {
				saveComparison(array[minIndex], array[currIndex], minIndex, currIndex);//Call the method that saves the comparisons
				if(comparator.compare(array[minIndex], array[currIndex]) > 0) {
					minIndex = currIndex;
				}
			}
			swap(start, minIndex, array);
		}
	}
}
