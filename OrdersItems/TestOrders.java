import java.util.*;
public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items
        Item item1 = new Item("mocha",3.5);
        Item item2 = new Item("latte",5);
        Item item3 = new Item("drip coffee",2.5);
        Item item4 = new Item("capuccino",6);
        // Order variables -- order1, order2 etc.
        Order order1 = new Order();
        order1.setName("Cindhuri");
        System.out.println(order1.getName());
        Order order2 = new Order();
        Order order3 = new Order();
        Order order4 = new Order();
        // Application Simulations
        // Use this example code to test various orders' updates
        // System.out.printf("Name: %s\n", order1.name);
        // System.out.printf("Total: %s\n", order1.total);
        // System.out.printf("Ready: %s\n", order1.ready);
    }
}
