import java.util.ArrayList;
import java.text.DecimalFormat;

public abstract class Characters {
	public static final DecimalFormat df = new DecimalFormat("0.00");
	private String name;
	private double health;
	private int armor;
	private int damage;
	private int strength, dexterity, constitution, intelligence, wisdom, charisma;
	private int gold;
	private ArrayList<Items> inventory;

	public Characters(String name, int strength, int dexterity, int constitution, int intelligence,int wisdom, int charisma, int health, int armor, int gold, int damage) {
		this.name = name;
		this.strength = strength;
		this.dexterity = dexterity;
		this.constitution = constitution;
		this.intelligence = intelligence;
		this.wisdom = wisdom;
		this.charisma = charisma;
		this.health = health;
		this.armor = armor;
		this.damage = damage;
		this.gold = gold;
		this.inventory = new ArrayList<Items>();
	}

	public String getName() {
		return name;
	}

	public double getHealth() {
		return health;
	}

	public int getArmor() {
		return armor;
	}

	public int getDamage() {
		return damage;
	}

	public int getStrength() {
		return strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public int getConstitution() {
		return constitution;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public int getWisdom() {
		return wisdom;
	}

	public int getCharisma() {
		return charisma;
	}

	public int getGold() {
		return gold;
	}
	
	public ArrayList<Items> getInventory() {
		return inventory;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHealth(double health) {
		if(health >= 0) {
			this.health = health;
		}
	}

	public void setArmor(int armor) {
		if(armor >= 0) {
			this.armor = armor;
		}
	}

	public void setDamage(int damage) {
		if(damage >= 0) {
			this.damage = damage;
		}
	}

	public void setStrength(int strength) {
		if(strength >= 0) {
			this.strength = strength;
		}
	}

	public void setDexterity(int dexterity) {
		if(dexterity >= 0) {
			this.dexterity = dexterity;
		}
	}

	public void setConstitution(int constitution) {
		if(constitution >= 0) {
			this.constitution = constitution;
		}
	}

	public void setIntelligence(int intelligence) {
		if(intelligence >= 0) {
			this.intelligence = intelligence;
		}
	}

	public void setWisdom(int wisdom) {
		if(wisdom >= 0) {
			this.wisdom = wisdom;
		}
	}

	public void setCharisma(int charisma) {
		if(charisma >= 0) {
			this.charisma = charisma;
		}
	}

	public void setGold(int gold) {
		if(gold >= 0) {
			this.gold = gold;
		}
	}

	public void setInventoryEmpty() {
		inventory.clear();
	}

	public int attModifier(int attribute) { //Attribute modifier
		int modifier = (attribute - 10) / 2;
		return modifier;
	}
	
	//All characters can perform this action
	public abstract int attack();
	public abstract int defend();
}
