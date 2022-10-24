public class CafeJava {
    public static void main(String[] args) {

        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        

        double mochaPrice = 3.5;
        int dripCoffee = 4;
        double latte = 5.5;
        int cappuccino = 3;

        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = true;
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
        if(!isReadyOrder1){
        System.out.println(customer1 + pendingMessage);
        }
        System.out.println(generalGreeting + customer4);
        if(isReadyOrder4){
            System.out.println(customer4 + readyMessage);
        }
        System.out.println(generalGreeting + customer2);
        if(isReadyOrder2){
            System.out.println(displayTotalMessage + latte*2);
        }
        System.out.println(generalGreeting + customer3);
        if(isReadyOrder3){
            System.out.println(displayTotalMessage + (latte - dripCoffee));
        }
    }
}
