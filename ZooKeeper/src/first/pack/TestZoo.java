package first.pack;

public class TestZoo {
	public static void main(String[] args) {
		Gorilla myGorilla=new Gorilla();
		System.out.println("Energy:"+myGorilla.displayEnergy());
		myGorilla.throwSomething();
		System.out.println("Energy:"+myGorilla.displayEnergy());
         Bat b=new Bat();
         b.attackTown();
         System.out.println("Energy:"+b.displayEnergy());
		}


}
