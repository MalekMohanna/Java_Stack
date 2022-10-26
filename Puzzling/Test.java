import java.util.*;
public class Test {
    public static void main(String[] args) {
        Puzzling x = new Puzzling();
        int[] y = x.getTenRolls();
        System.out.println("Your random array is : \n"+Arrays.toString(y));
        System.out.println("Your random charachter is : \n"+x.getRandomLetter());
        System.out.println("Your generated password is : \n"+x.generatePassword());
        System.out.println("Please inter your number :");
        Scanner sc= new Scanner(System.in);
        int a= sc.nextInt();
        System.out.println(x.getNewPasswordSet(a));
    }
}
