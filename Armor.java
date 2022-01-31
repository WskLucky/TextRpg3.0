
public class Armor extends Items{
	
	private int armor;
	private int strength;
	private ArmorType armorType;
	
	public Armor(String name, int cost, double weight, int armor, int strength, ArmorType armorType) {
		super(name, cost, weight, false);
		this.strength = strength;
		this.armor = armor;
		this.armorType = armorType;
	}

	public int getArmor() {
		return armor;
	}

	public int getStrength() {
		return strength;
	}

	public ArmorType getArmorType() {
		return armorType;
	}
	
	@Override
	public String toString() {
		String separator = "\n--------------------";
		return separator + "\n" + armorType 
				+ "\n" + getName() + separator
				+ "\nCost: " + getCost() 
				+ "\nWeight: " + getWeight() + "lb." 
				+ "\nArmor: " + armor + separator;
	}

}
