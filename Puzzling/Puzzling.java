import java.util.*;
class Puzzling {

    public int genNum(int max, int min) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public int[] getTenRolls() {
        int[] myarray = new int[10];
        for(int i=0; i<10;i++){
            myarray[i]= genNum(20,1);
        }
        return myarray;
    }

    public String getRandomLetter() {
        String[] myChar={
        "a", "b", "c", "d", "e", "f", "g", "h",
        "i", "j","k", "l", "m", "n", "o", "p", "q", "r",
        "s", "t", "u", "v", "w", "x", "y", "z"};
        int myRand = genNum(25,0);
        return myChar[myRand];
    }

    public String generatePassword() {
        String pass="";
        for(int i=0;i<8;i++){
            pass+=getRandomLetter();
        }
        return pass;
    }

    public String getNewPasswordSet(int length) {
        String pass="";
        for(int i=0;i<length;i++){
            pass+=getRandomLetter();
        }
        return pass;
    }
}