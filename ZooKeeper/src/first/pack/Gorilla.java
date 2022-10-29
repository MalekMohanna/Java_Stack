package first.pack;

public class Gorilla extends Mammal {
	public Gorilla() {
		super(100);
	}
	
public void throwSomething() {
	int curr=super.getEnergyLevel();
	curr-=5;
	super.setEnergyLevel(curr);
}
public void eatBananas() {
	int curr=super.getEnergyLevel();
	curr+=10;
	super.setEnergyLevel(curr);
}
public void climb() {
	int curr=super.getEnergyLevel();
	curr-=10;
	super.setEnergyLevel(curr);
}

}