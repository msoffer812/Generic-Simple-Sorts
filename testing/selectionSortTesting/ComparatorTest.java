package genericSorting.testing.selectionSortTesting;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import genericSorting.BubbleSort;
import genericSorting.Car;
import genericSorting.CarCostComparator;
import genericSorting.CarNameComparator;
import genericSorting.CarYearComparator;
import genericSorting.SelectionSort;

class ComparatorTest {

	static Car[] cars;
	static Car[] sortedCars;
	static Car c1, c2, c3, c4, c5, c6, c7;
	static Comparator<Car> comparator;
	static SelectionSort<Car> sort;
	
	@BeforeAll
	static void initializeCars() {
		c1 = new Car("BMW", "3 Series", 1960, 20000.99); 
		c2 = new Car("Chevrolet", "Malibu", 2023, 56);
		c3 = new Car("Ford", "Mustang", 2021, 4352.89); 
		c4 = new Car("Honda", "Accord", 1988, 45222);
		c5 = new Car("Mercedes-Benz", "C-Class", 1997, 900500.50); 
		c6 = new Car("Nissan", "Altima", 2006, 10000.25);
		c7 = new Car("Toyota", "Camry", 2001, 50000.99);
	}
	
	@BeforeEach
	void initializeUnsortedArray() {
		cars = new Car[]{c7, c3, c4, c2, c1, c6, c5};
	}
	
	@Test
	void selectionSortOfCarsSortsWithCustomComparatorByNameCorrectly() {
		sortedCars = new Car[] {c1, c2, c3, c4, c5, c6, c7};
		comparator = new CarNameComparator();
		sort = new SelectionSort<Car>(comparator);
		sort.sort(cars);
		assertArrayEquals(cars, sortedCars);
	}
	
	@Test
	void selectionSortOfCarsSortsWithCustomComparatorByYearCorrectly() {
		sortedCars = new Car[] {c1, c4, c5, c7, c6, c3, c2};
		comparator = new CarYearComparator();
		sort = new SelectionSort<Car>(comparator);
		sort.sort(cars);
		assertArrayEquals(sortedCars, cars);
	}
	
	@Test
	void selectionSortOfCarsSortsWithCustomComparatorByCostCorrectly() {
		sortedCars = new Car[] {c5, c7, c4, c1, c6, c3, c2};
		comparator = new CarCostComparator();
		sort = new SelectionSort<Car>(comparator);
		sort.sort(cars);
		assertArrayEquals(cars, sortedCars);
	}

}
