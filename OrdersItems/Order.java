import java.util.*;
public class Order {
    private String name;
    private double total = 0;
    private boolean ready;
    ArrayList<Item> items;
    public  Order(String myName, double Mytotal, boolean ready1, ArrayList<Item> myItems) {
        this.name=myName;
        this.total=Mytotal;
        this.ready=ready1;
        this.items=myItems;
    }

    public Order(){

    }
    public void setName(String myName){
        this.name=myName;
    }
    public String getName(){
        return name;
    }
}
