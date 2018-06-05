
public class VehicleBuilder {

	public Vehicle create2Wheeler() {
		Vehicle vehicle = new Vehicle();
		vehicle.addItem(new SemiAutomatic());
		return vehicle;
	}

	public Vehicle create4Wheeler() {
		Vehicle vehicle = new Vehicle();
		vehicle.addItem(new FullyAutomatic());
		return vehicle;
	}
}
