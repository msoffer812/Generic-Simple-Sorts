package genericSorting;

import java.util.Comparator;

public class CarNameComparator implements Comparator<Car>{
	@Override
	public int compare(Car a, Car b) {
		return a.getName().compareTo(b.getName());
	}

}
