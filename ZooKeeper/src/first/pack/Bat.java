package first.pack;

public class Bat extends Mammal {
	public Bat() {
		super(300);
	}
	public void fly() {
		int curr=super.getEnergyLevel();
		if(curr>=50)
		{
			curr-=50;
		
		}
		super.setEnergyLevel(curr);
	}
	public void eatHumans(){
		int curr=super.getEnergyLevel();
		curr+=25;
		super.setEnergyLevel(curr);
	}
	public void attackTown(){
		int curr=super.getEnergyLevel();
		if(curr>=100)
		curr-=100;
		super.setEnergyLevel(curr);
	}

}