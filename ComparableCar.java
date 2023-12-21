package genericSorting;
/**
 * The same as car except has a compareTo so has
 * a natural ordering
 * @author mbrso
 *
 */
public class ComparableCar extends Car implements Comparable<Car>{
	
	public ComparableCar(String md, String mk, int yr, double c) {
		super(md, mk, yr, c);
	}
	
	@Override
	public int compareTo(Car car) {
		return this.getName().compareTo(car.getName());
	}
}
