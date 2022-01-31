
public enum ArmorType {
	
	LIGHT_ARMOR("Light Armor"), MEDIUM_ARMOR("Medium Armor"), HEAVY_ARMOR("Heavy Armor"), SHIELD("Shield");
	
	private String description;
	
	private ArmorType(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return description;
	}
}
