
public class Items {
	
	private String name;
	private int cost;
	private double weight;
	private boolean isHealthItem;
	
	public Items(String name, int cost, double weight, boolean isHealthItem) {
		this.name = name;
		this.cost = cost;
		this.weight = weight;
		this.isHealthItem = isHealthItem;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		if(cost >= 0) {
			this.cost = cost;
		}
	}

	public double getWeight() {
		return weight;
	}
	
	public boolean isHealthItem() {
		return isHealthItem;
	}
	
	@Override
	public String toString() {
		String separator = "\n--------------------\n";
		return separator + "Item\n" + name
				+ separator + "Cost: " + cost 
				+ "\nWeight" + weight + separator;
	}
	
}
