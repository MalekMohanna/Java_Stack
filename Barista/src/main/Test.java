package main;

public class Test {

    public static void main(String[] args) {


        // Menu items
//        Item item1 = new Item("mocha", 3.50);
//        Item item2 = new Item("Drip Coffee", 2.00);
//        Item item3 = new Item("latte", 4.50);
//        Item item4 = new Item("Cappuccino" , 4.50);
//
//        //Orders
//        Order order1 = new Order();
//        Order order2 = new Order();
//        Order order3 = new Order("Malek");
//        Order order4 = new Order("Ahmad");
//        Order order5 = new Order("Jamal");
//
//        order1.addItem(item1); 
//        order1.addItem(item3); 
//        order2.addItem(item2); 
//        order2.addItem(item2); 
//        order3.addItem(item4); 
//        order3.addItem(item1); 
//        order4.addItem(item1); 
    	
//        order4.addItem(item2);
//        order5.addItem(item3); 
//        order5.addItem(item4); 
//        order1.setReady();
//        order3.setReady();
//        order5.setReady();
//
//        order1.display();
//        order2.display();
//        order3.display();
//        order4.display();
//        order5.display();
//    	OrderKiosk order1=new OrderKiosk();
//    	OrderKiosk.addItem(new Item("item1",3.5));
//    	OrderKiosk.addItem(new Item("item2",4.5));
//    	OrderKiosk.addItem(new Item("item3",3.5));
//    	OrderKiosk.addItem(new Item("item4",4.5));
//    	OrderKiosk.addItem(new Item("item5",3.5));
//    	OrderKiosk.addItem(new Item("item6",4.5));
//    	OrderKiosk.printMenu();
//    	System.out.println(OrderKiosk.menu.get(1).getIndex());
//    	order1.newOrder();
        OrderKiosk coffeeKiosk = new OrderKiosk();

        coffeeKiosk.addMenuItem("drip coffee", 3.50);
        coffeeKiosk.addMenuItem("cappuccino", 1.50);
        coffeeKiosk.addMenuItem("latte", 4.00);
        coffeeKiosk.addMenuItem("mocha", 4.50);


        coffeeKiosk.newOrder();

    
    }
}