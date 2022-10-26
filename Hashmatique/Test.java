import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        Hashmatique hm = new Hashmatique();
        HashMap newHash =  hm.create();
        System.out.println(hm.getByTitle(newHash, "Song 2"));
        hm.printAll(newHash);
    }
}