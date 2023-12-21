package genericSorting;

import java.util.Comparator;

public class CarYearComparator implements Comparator<Car>{
	/**
	 * For sorting oldest to newest
	 */
	@Override
	public int compare(Car a, Car b) {
		return a.getYear() - b.getYear();
	}

}
