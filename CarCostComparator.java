package genericSorting;

import java.util.Comparator;

public class CarCostComparator implements Comparator<Car>{
	@Override
	public int compare(Car a, Car b) {
		return Double.compare(b.getCost(), a.getCost()); /*Want it to sort in ascending order*/
	}
}
