package first.pack;

public class Mammal {
	
	private int energyLevel;
	
public int getEnergyLevel() {
		return energyLevel;
	}
public Mammal() {
	this.energyLevel=100;
}
	public Mammal(int energe) {
	this.energyLevel = energe;
}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}

public int displayEnergy() {
	System.out.println("the energy is:"+this.getEnergyLevel());
	return this.getEnergyLevel();
}



}