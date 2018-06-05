
public abstract class Automatic implements Item {

	@Override
	public Product product() {
		return new Model();
	}

	@Override
	public abstract float price();

}
