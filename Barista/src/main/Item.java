package main;

public class Item {
    private String name;
    private double price;
    private int index;
    
    public Item(String myName, double myPrice) {
        this.setName(myName);
        this.setPrice(myPrice);

    }
    
    public Item(){

    }

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
