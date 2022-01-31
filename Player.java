

public class Player extends Characters{

	private int playerLevel;
	private int xp;
	private int xpCap; //Max xp, changes by each level up
	private int attLevelUpCounter; //Levels in which you gain 2 attribute points
	private int maxHealth;
	private double carryCapacity;
	private double inventoryWeight; //How much player is carrying

	public static final int STARTING_MAX_HEALTH	 = 12; //Max health before upgrades
	public static final int MAX_ARMOR	 = 10; //Max armor before upgrades
	public static final int MIN_GOLD= 0; //Initial amount of gold
	public static final int MIN_XP= 0; //Initial amount of Experience
	public static final int MIN_LEVEL = 1; //Player initial value
	public static final int HEALTH_PER_LEVEL = 7;
	public static final double STARTING_CARRY_CAPACITY = 50;
	public static final double STARTING_INVENTORY_WEIGHT = 0;
	
	//List with the experience cap per level
	public static final int[] experienceList = {300, 900, 2700, 6500, 14000, 23000, 34000, 48000, 
			64000, 85000, 100000, 120000, 140000, 165000, 195000, 225000, 265000, 305000, 355000};

	public static final int ATTRIBUTE_POINT = 1;

	public Player(String name, int strength, int dexterity, int constitution, int intelligence,int wisdom, int charisma) {
		super(name, strength, dexterity, constitution, intelligence, wisdom, charisma, 
				STARTING_MAX_HEALTH, MAX_ARMOR, MIN_GOLD, strength);
		this.maxHealth = STARTING_MAX_HEALTH;
		this.playerLevel = MIN_LEVEL;
		this.xp = MIN_XP;
		this.xpCap = experienceList[0];
		this.attLevelUpCounter = MIN_LEVEL;
		this.carryCapacity = STARTING_CARRY_CAPACITY;
		this.inventoryWeight = STARTING_INVENTORY_WEIGHT;
	}

	public int getPlayerLevel() {
		return playerLevel;
	}

	public int getXp() {
		return xp;
	}

	public int getXpCap() {
		return xpCap;
	}

	public void setPlayerLevel(int playerLevel) {
		if(playerLevel > 0) {
			this.playerLevel = playerLevel;
		}
	}

	public void setXp(int xp) {
		if(playerLevel > 0) {
			this.xp = xp;
		}
	}
	
	public double getCarryCapacity() {
		return this.carryCapacity;
	}

	public void setCarryCapacity(double carryCapacity) {
		if(carryCapacity > 0) {
			this.carryCapacity = carryCapacity;
		}
	}
	
	public double getInventoryWeight() {
		return this.inventoryWeight;
	}

	public void setInventoryWeight(double inventoryWeight) {
		if(carryCapacity > 0) {
			this.inventoryWeight = inventoryWeight;
		}
	}

	@Override
	public String toString() {
		String separator = "\n--------------------";
		return "Player: " + getName() 
		+ "\nLevel: " + playerLevel
		+ "\nXP: " + xp + "/" + xpCap
		+ "\nGold: " + getGold()
		+ separator
		+ "\nHealth: " + df.format(getHealth()) 
		+ "\nArmor: " + getArmor()
		+ "\nStrength: " + getStrength()
		+ "\nDexterity: " + getDexterity()
		+ "\nConstitution: " + getConstitution()
		+ "\nIntelligence: " + getIntelligence()
		+ "\nWisdom: " + getWisdom()
		+ "\nCharisma: " + getCharisma()
		+ separator;
	}

	public void levelUp() {

		maxHealth = HEALTH_PER_LEVEL + attModifier(getConstitution());
		setHealth(maxHealth);

		playerLevel += 1;
		xpCap = experienceList[attLevelUpCounter];
		attLevelUpCounter += 1;
	}

	public void attLevelUp(String firstAttribute, String secondAttribute) {

			attLevelUpHelper(firstAttribute);
			attLevelUpHelper(secondAttribute);
	}

	private void attLevelUpHelper(String attribute) {

		if(attribute.equalsIgnoreCase("Strength")) {
			setStrength(getStrength() + ATTRIBUTE_POINT);
		} else if(attribute.equalsIgnoreCase("Dexterity")) {
			setDexterity(getDexterity() + ATTRIBUTE_POINT);
		} else if(attribute.equalsIgnoreCase("Constitution")) {
			setConstitution(getConstitution() + ATTRIBUTE_POINT);
		} else if(attribute.equalsIgnoreCase("Intelligence")) {
			setIntelligence(getIntelligence() + ATTRIBUTE_POINT);
		} else if(attribute.equalsIgnoreCase("Wisdom")) {
			setWisdom(getIntelligence()+ ATTRIBUTE_POINT);
		} else if(attribute.equalsIgnoreCase("Charisma")) {
			setCharisma(getCharisma() + ATTRIBUTE_POINT);
		} 
	}
	
	//Method to add item to inventory
	public void pickUpItem(Items item) {
		
		if((inventoryWeight += item.getWeight()) <= carryCapacity) {
			getInventory().add(item);
			inventoryWeight += item.getWeight();
		} 
		
	}
	
	//Removes item from inventory and returns it
	public Items dropItem(Items item) {
		
		getInventory().remove(item);
		return item;
		
	}

	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int defend() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
