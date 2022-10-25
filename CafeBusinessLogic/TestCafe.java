import java.util.*;

public class TestCafe {
    public static void main(String[] args) {
        CafeUtil appTest = new CafeUtil();
        System.out.println("\n----- Streak Goal Test -----");
        Scanner sc= new Scanner(System.in); 
        System.out.print("Enter number \n");
        int a= sc.nextInt();
        System.out.printf("Purchases needed by week 10: %s \n\n", appTest.getStreakGoal(a));
    
        System.out.println("----- Order Total Test-----");
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        System.out.printf("Order total: %s \n\n",appTest.getOrderTotal(lineItems));
        
        System.out.println("----- Display Menu Test-----");
        
        List<String> loadMenu = Arrays.asList(
            "drip coffee",
            "cappucino",
            "latte",
            "mocha"
        );
        ArrayList<String> menu = new ArrayList<String>();
        menu.addAll(loadMenu);
        appTest.displayMenu(menu);
    
        System.out.println("\n----- Add Customer Test-----");
        ArrayList<String> customers = new ArrayList<String>();
        // --- Test 4 times ---
        for (int i = 0; i < 4; i++) {
            appTest.addCustomer(customers);
            System.out.println("\n");
        }
    }
}
