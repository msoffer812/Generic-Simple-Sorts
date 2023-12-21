package genericSorting;
import java.time.Year;
import java.util.*;

public class UserInterface {
	public static void main(String[] args) {
		int playAgain;
		Scanner in = new Scanner(System.in);
		do {
			playSorter(in);
			playAgain = getIntInput("1.Play again\n2.Exit", in, 1, 2);
		}while(playAgain == 1);
		System.out.println("Goodbye!");
		in.close();
		System.exit(0);
	}
	
	public static void playSorter(Scanner in) {
		String comparableOrNot = getStringInput("Press 1 to make the car have a natural ordering, anything else if not: ", in);
		boolean shouldBeComparable = false;
		if(comparableOrNot.equals("1")) {
			shouldBeComparable = true;
		}
		Car[] cars = initializeCars(in, shouldBeComparable);
		String sortAgain = "1";
		do {
			initializeSort(cars, in, shouldBeComparable);
			sortAgain = getStringInput("Press 1 to do another sort, any other key to exit", in);
		}while(sortAgain.equals("1"));
	}
	
	public static void initializeSort(Car[] cars, Scanner in, boolean carsAreComparables) {
		String sortTypeSelectionMenu = "1.Sort by Cost\n2.Sort by Year\n3.Sort by Name";
		int max = 3;
		if(carsAreComparables) {
			sortTypeSelectionMenu = sortTypeSelectionMenu + "\n4.Sort by Natural Order";
			max = 4;
		}
		int sortType = getIntInput(sortTypeSelectionMenu, in, 1, max);
		int sortingAlgorithm = getIntInput("1.Bubble Sort\n2.Selection Sort", in, 1, 2);
		Sort<Car> sorter = createSortingObject(sortType, sortingAlgorithm);
		sorter.sort(cars);
		checkIfShouldDisplayList(cars, in);
		checkIfShouldDisplayStats(sorter, in);
	}
	
	public static void checkIfShouldDisplayList(Car[] cars, Scanner in) {
		String displayList = getStringInput("Press 1 to display the list, any other key otherwise", in);
		if(displayList.equals("1")) {
			displayArray(cars);
		}
	}
	
	public static void checkIfShouldDisplayStats(Sort<Car> sorter, Scanner in) {
		String displayList = getStringInput("Press 1 to display the log of the last sort, any other key otherwise", in);
		if(displayList.equals("1")) {
			displaySortStats(sorter);
		}
	}
	
	public static void displaySortStats(Sort<Car> sort) {
		System.out.println("Sorting log: ");
		System.out.println(sort.getComparisons());
		System.out.println("");
		System.out.println("Swaps: " + sort.getAmountOfSwaps());
		System.out.println("");
		System.out.println("Comparisons: " + sort.getAmountOfComparisons());
	}
	public static void displayArray(Car[] cars){
		System.out.println("Array:");
		for(Car car: cars) {
			System.out.println(car.toString());
		}
	}
	
	public static Sort<Car> createSortingObject(int sortType, int sortingAlgorithm) {
		Sort<Car> sort = null;
		switch(sortType) {
		case 1:
			sort = initializeSortByCost(sortingAlgorithm);
			break;
		case 2:
			sort = initializeSortByYear(sortingAlgorithm);
			break;
		case 3:
			sort = initializeSortByName(sortingAlgorithm);
			break;
		case 4:
			sort = initializeSortByDefault(sortingAlgorithm);
			break;
		}
		return sort;
	}
	
	public static Sort<Car> initializeSortByName(int sortAlgorithm) {
		Sort<Car> sort = null;
		if(sortAlgorithm == 1) {
			sort = new BubbleSort<Car>(new CarNameComparator());
		}else {
			sort = new SelectionSort<Car>(new CarNameComparator());
		}
		return sort;
	}
	
	public static Sort<Car> initializeSortByYear(int sortAlgorithm) {
		Sort<Car> sort = null;
		if(sortAlgorithm == 1) {
			sort = new BubbleSort<Car>(new CarYearComparator());
		}else {
			sort = new SelectionSort<Car>(new CarYearComparator());
		}
		return sort;
	}
	
	public static Sort<Car> initializeSortByCost(int sortAlgorithm) {
		Sort<Car> sort = null;
		Comparator<Car> comparator = new CarCostComparator();
		if(sortAlgorithm == 1) {
			sort = new BubbleSort<Car>(comparator);
		}else {
			sort = new SelectionSort<Car>(comparator);
		}
		return sort;
	}
	
	public static Sort<Car> initializeSortByDefault(int sortAlgorithm) {
		Sort<Car> sort = null;
		if(sortAlgorithm == 1) {
			sort = new BubbleSort<Car>();
		}else {
			sort = new SelectionSort<Car>();
		}
		return sort;
	}
	
	public static Car[] initializeCars(Scanner in, boolean shouldBeComparable) {
		List<Car> cars = new ArrayList<>();
		int continueToCreate = 1;
		do {
			Car car = makeACar(in, shouldBeComparable);
			cars.add(car);
			continueToCreate = getIntInput("1.Continue creating cars\n2.Finish and go to sort", in, 1, 2);
		}while(continueToCreate == 1);
		return cars.toArray(new Car[cars.size()]);
	}
	
	public static Car makeACar(Scanner in, boolean shouldBeComparable) {
		String carMake = getStringInput("Enter the car's make: ", in);
		String carModel = getStringInput("Enter the car's model: ", in);
		int carYear = getIntInput("Enter the car's year: ", in, 1885, Year.now().getValue());
		double carCost = getDoubleInput("Enter the car's cost: ", in, 0, 1000000000);
		if(shouldBeComparable) {
			return new ComparableCar(carModel, carMake, carYear, carCost);
		}
		return new Car(carModel, carMake, carYear, carCost);
	}
	
	/**
	 * Get user's string input, validate and return
	 * @param message
	 * @param in
	 * @return user's string input
	 */
	private static String getStringInput(String message, Scanner in)
	{
		String ans = "";
		boolean cont = false;
		do
		{
			System.out.println(message);
			cont = false;
			ans = in.nextLine();
			if(ans.length() == 0)
			{
				message = "Invalid input; Please reenter:";
				cont = true;
			}
		}while(cont);
		return ans;
	}
	
	private static int getIntInput(String message, Scanner in, int min, int max)
	{
		int ans = 0;
		boolean cont = false;
		do
		{
			System.out.println(message);
			message = "Invalid input; Please reenter:";
			cont = false;
			try
			{
				ans = in.nextInt();
				in.nextLine();
			}catch(InputMismatchException e)
			{
				cont = true;
				in.nextLine();
			}
			if(ans < min || ans>max)
			{
				cont = true;
			}
		}while(cont);
		return ans;
	}
	private static double getDoubleInput(String message, Scanner in, int min, int max)
	{
		double ans = 0;
		boolean cont = false;
		do
		{
			System.out.println(message);
			message = "Invalid input; Please reenter:";
			cont = false;
			try
			{
				ans = in.nextDouble();
				in.nextLine();
			}catch(InputMismatchException e)
			{
				cont = true;
				in.nextLine();
			}
			if(ans < min || ans>max)
			{
				cont = true;
			}
		}while(cont);
		return ans;
	}
}
