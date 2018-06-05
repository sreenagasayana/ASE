
public class BuilderPatternMain {

	public static void main(String[] args) {
		
		VehicleBuilder vehicleBuilder = new VehicleBuilder();

	      Vehicle twoWheeler = vehicleBuilder.create2Wheeler();
	      System.out.println("Semi-Automatic");
	      twoWheeler.showItems();

	      Vehicle fourWheeler = vehicleBuilder.create4Wheeler();
	      System.out.println("\n\nFully-Automatic");
	      fourWheeler.showItems();

	}

}
