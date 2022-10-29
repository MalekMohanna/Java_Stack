package main;

import java.util.ArrayList;

public class Order {
    private String name;
    private boolean ready;
    ArrayList<Item> items;
    
    public  Order(String myName, double Mytotal, boolean ready1, ArrayList<Item> myItems) {
        this.name=myName;
        this.setReady(ready1);
        this.items=new ArrayList<Item>();
    }

    public Order(String myName){
    	this.name=myName;
    	this.items=new ArrayList<Item>();
    }
    public Order(){
    	this.items=new ArrayList<Item>();
    }
    public void setName(String myName){
        this.name=myName;
    }
    public String getName(){
        return name;
    }


	public boolean isReady() {
		return ready;
	}

	public void setReady(boolean ready) {
		this.ready = ready;
	}
	
	public double getOrderTotal() {
		double total = 0 ;
		for(int i=0;i<this.items.size();i++) {
			total+= items.get(i).getPrice();
		}
		return total;
	}
	
	public void addItem(Item item) {
		this.items.add(item);
		
	}
	public String getStatusMessage() {
		String response;
		if(ready) {
			 response ="Your order is ready";
		}
		else {
			 response ="Thank you for waiting. Your order will be ready soon.";
		}
		return response;
	}
	public void display() {
		int listItemsnum = this.items.size();
		System.out.println("***********************************************");
		System.out.println("Customer name : "+ this.name);
		for(int i=0;i<listItemsnum;i++) {
			System.out.println(this.items.get(i).getName()+ " $"+this.items.get(i).getPrice());
		}
		System.out.println("Total : $"+ this.getOrderTotal());
		System.out.println("***********************************************");
		
	}
    public void setReady() {
        this.ready = true;
    }
}