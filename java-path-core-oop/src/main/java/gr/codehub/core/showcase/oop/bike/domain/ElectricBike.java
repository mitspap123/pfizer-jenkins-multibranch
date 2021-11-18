package gr.codehub.core.showcase.oop.bike.domain;

public class ElectricBike extends Bike {
	private int numberOfBatteries;

	public ElectricBike(String name, String color, int numberOfBatteries) {
		super(name, color, 0);
		this.numberOfBatteries = numberOfBatteries;
	}

	public int getNumberOfBatteries() {
		return numberOfBatteries;
	}

	public void setNumberOfBatteries(int numberOfBatteries) {
		this.numberOfBatteries = numberOfBatteries;
	}

	@Override
	public String cyclingSound() {
		return "bzzzz";
	}

	@Override
	public String toString() {
		return "ElectricBike{" + super.toString() + ",numberOfBatteries=" + numberOfBatteries + '}';
	}
}
