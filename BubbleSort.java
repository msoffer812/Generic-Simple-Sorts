package genericSorting;

import java.util.Comparator;

public class BubbleSort<T> extends Sort<T>{
	
	public BubbleSort() {
		super();
	}
	
	public BubbleSort(Comparator<T> comparator) {
		super(comparator);
	}
	
	/**
	 * method that employs a bubbleSort to sort the algorithm
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void sort(T[] array) {
		resetStats();
		for(int last=array.length-1; last>=0;last--) {
			for(int index=0;index<last;index++) {
				saveComparison(array[index], array[index+1], index, index+1);//Call the method that saves the comparisons
				if(comparator.compare(array[index], array[index+1]) > 0) {
					swap(index, index+1, array);
				}
			}
		}
	}
}
