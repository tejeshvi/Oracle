/**
 * Class defining the elements of a wood type
 */
package model;

/**
 * @author USER
 *
 */
public class WoodItem {

	String type;
	Double baseDeliveryTime;
	Double price;
	
	/**
	 * Default constructor 
	 */
	public WoodItem(){
		this.type = "Empty";
		this.baseDeliveryTime = 0.0;
		this.price = 0.0;
	}
	
	/**
	 * Constructor of a WoodItem element with parameters
	 * @param type Name of the wood type
	 * @param daseDeliveryTime base delivery time
	 * @param price price per Bare Foot
	 */
	public WoodItem(String type, Double baseDeliveryTime, Double price) {
		this.type = type;
		this.baseDeliveryTime = baseDeliveryTime;
		this.price = price;
	}

	/**
	 * Get the type of Wood
	 * 
	 * @return Name of the WoodItem
	 */
	public String getType() {
		return type;
	}

	/**
	 * Get the base delivery time
	 * 
	 * @return the baseDeliverytime
	 */
	public Double getBaseDeliveryTime(String hardWoodType) {
		if(hardWoodType.equals("Cherry"))
			baseDeliveryTime=2.5;
		else if(hardWoodType.equals("Curly Maple"))
			baseDeliveryTime=1.5;
		else if(hardWoodType.equals("Genuine Mahogany"))
			baseDeliveryTime=3.0;
		else if(hardWoodType.equals("Wenge"))
			baseDeliveryTime=5.0;
		else if(hardWoodType.equals("White Oak"))
			baseDeliveryTime=2.3;
		else if(hardWoodType.equals("Sawdust"))
			baseDeliveryTime=1.0;
		return baseDeliveryTime;
	}

	/**
	 * 
	 * Get the price per Bare Foot
	 * 
	 * @return the price for 1 Bare Foot of this WoodItem
	 */
	public Double getPrice(String hardWoodType) {
		if(hardWoodType.equals("Cherry"))
			price=5.95;
		else if(hardWoodType.equals("Curly Maple"))
			price=6.00;
		else if(hardWoodType.equals("Genuine Mahogany"))
			price=9.60;
		else if(hardWoodType.equals("Wenge"))
			price=22.35;
		else if(hardWoodType.equals("White Oak"))
			price=6.70;
		else if(hardWoodType.equals("Sawdust"))
			price=1.5;
		return price;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * You may implement this method to fit your needs
	 */
	@Override
	public String toString() {	
		return "";
	}
	
}
