
public class Weapons extends Items{

	private int damage;
	private String damageType;
	private String damageModifier;
	
	public Weapons(String name, int cost, double weight, int damage, String damageType, String damageModifier) {
		super(name, cost, weight, false);
		this.setDamage(damage);
		this.damageType = damageType;
		this.damageModifier = damageModifier;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		if(damage >= 0) {
			this.damage = damage;
		}
	}

	public String getDamageType() {
		return damageType;
	}
	
	public String getDamageModifier() {
		return damageModifier;
	}
	
	@Override
	public String toString() {
		String separator = "\n--------------------";
		return separator + "\nWeapon\n"
				+ getName() + separator 
				+ "\nCost: " + getCost()
				+ "\nWeight: " + getWeight()
				+ "\nDamage: " + "1-" + damage
				+ "\nDamage Modifier: " + damageModifier + separator;
	}

	
}
