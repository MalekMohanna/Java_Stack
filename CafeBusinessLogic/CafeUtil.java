import java.util.*;
public class CafeUtil {
    public int getStreakGoal(int number) {
        int sum=0;
        for(int i=0;i<=number;i++){
            sum+=i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices) {
        double sum=0;
        for(int i=0;i<=prices.length-1;i++){
            sum+=prices[i];
        }
        return sum;
    }

    void displayMenu(ArrayList<String> menuItems) {
        for(int i=0;i<=menuItems.size()-1;i++){
            System.out.println(i+"  "+menuItems.get(i));
        }
        return ;
    }
    void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println( "Hello,"+userName);
        System.out.println("There are  " +customers.size()+"  people in front of you" );
        customers.add(userName);
        
    }
}


