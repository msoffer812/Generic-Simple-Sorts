package genericSorting;

public class Car {
	private String name;
	private int year;
	private double cost;
	
	public Car(String mk, String md, int yr, double c) {
		this.name = mk + " " + md;
		this.year = yr;
		this.cost = c;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public double getCost() {
		return this.cost;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Car Specs:");
		str.append("\n");
		str.append("Name: ");
		str.append(name);
		str.append("\n");
		str.append("Year: ");
		str.append(year);
		str.append("\n");
		str.append("Cost: ");
		str.append(cost);
		return str.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		Car car = (Car)o;
		return this.getName().equals(car.getName()) && 
				this.getYear() == car.getYear() && 
					this.getCost() == car.getCost();
	}
}
