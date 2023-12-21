package genericSorting.testing.bubbleSortTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import genericSorting.BubbleSort;
import genericSorting.Car;
import genericSorting.ComparableCar;
import genericSorting.SelectionSort;

class ComparableTest {
	Car[] cars;
	Car[] sortedCars;
	Integer[] ints;
	Integer[] sortedInts;
	String[] strings;
	String[] sortedStrings;
	
	@BeforeEach
	void initializeSorts() {
		Car c1 = new ComparableCar("BMW", "3 Series", 1960, 20000.99), c2 = new ComparableCar("Chevrolet", "Malibu", 2023, 56),
				c3 = new ComparableCar("Ford", "Mustang", 2021, 4352.89), c4 = new ComparableCar("Honda", "Accord", 1988, 45222),
					c5 = new ComparableCar("Mercedes-Benz", "C-Class", 1997, 900500.50), c6 = new ComparableCar("Nissan", "Altima", 2006, 10000.25),
						c7 = new ComparableCar("Toyota", "Camry", 2001, 50000.99);
		cars = new Car[]{c7, c3, c4, c2, c1, c6, c5};
		sortedCars = new Car[]{c1, c2, c3, c4, c5, c6, c7};
		
		ints = new Integer[] {5, 6, 2, 0, 1, 3, 5, 3, 98, 22, 0, 45, 71, 42, 49, 9, 427, 12, 32, 9, 475, 96, 100};
		sortedInts = new Integer[] {0, 0, 1, 2, 3, 3, 5, 5, 6, 9, 9, 12, 22, 32, 42, 45, 49, 71, 96, 98, 100, 427, 475};
		
		strings = new String[]{"Orange", "Banana", "Apple", "Grapes", "Cherry", "Pear", "Kiwi", 
									"Mango", "Pineapple", "Strawberry"};
		sortedStrings = new String[]{"Apple", "Banana", "Cherry", "Grapes", "Kiwi", "Mango", "Orange", "Pear",  
				 "Pineapple", "Strawberry"};
	}
	
	@Test
	void bubbleSortOfCarsSortsByDefaultOrderCorrectly() {
		BubbleSort<Car> sort = new BubbleSort<Car>();
		sort.sort(cars);
		assertArrayEquals(cars, sortedCars);
	}
	
	@Test
	void bubbleSortOfStringsSortsByDefaultOrderCorrectly() {
		BubbleSort<String> sort = new BubbleSort<String>();
		sort.sort(strings);
		assertArrayEquals(strings, sortedStrings);
	}
	
	@Test
	void bubbleSortOfIntsSortsByDefaultOrderCorrectly() {
		BubbleSort<Integer> sort = new BubbleSort<Integer>();
		sort.sort(ints);
		assertArrayEquals(ints, sortedInts);
	}
}
