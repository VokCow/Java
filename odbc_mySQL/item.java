package northwind2;

public class Item {
	private String name;
	private float price;
	
	public Item(String name, float price) {
		this.name=name;
		this.price=price;
	}

	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPrice(float price) {
		this.price=price;
	}
	
	public float getPrice() {
		return price;
	}
	
	@Override 
	public String toString() {
		return "ITEM: " + " name: " + name + " price: " + price ;
	}

}
