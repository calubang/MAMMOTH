//shotAmount : 샷추가 개수 기본은 1
//syrupAmount : 시럽추가 개수 기본은 1
class Coffee extends Drink {
	protected int SYRUP_PRICE;
	protected int SHOT_PRICE;
	protected int shotAmount;
	protected int syrupAmount;
	
	public Coffee(String name, int price){
		this(name, price, 0, 0);
	}
	public Coffee(String name, int price, int shotAmount, int syrupAmount) {
		super(name, price);
		this.shotAmount = shotAmount;
		this.syrupAmount = syrupAmount;
		SYRUP_PRICE = OptionHashMap.getPrice("SYRUP_PRICE");
		SHOT_PRICE = OptionHashMap.getPrice("SYRUP_PRICE");
	}
	

	public int getShotAmount(){
		return shotAmount;
	}
	public int getShotPrice() {
		return getShotAmount() * SHOT_PRICE;
	}
	public boolean setShotAmount(int shotAmount){
		if(shotAmount > 0){
			this.shotAmount = shotAmount;
			return true;
		}
		return false;
	}
	public int getSyrupAmount(){
		return syrupAmount;
	}
	public int getSyrupPrice() {
		return getSyrupAmount() * SYRUP_PRICE;
	}
	
	public boolean setSyrupAmount(int syrupAmount){
		if (syrupAmount > 0){
			this.syrupAmount = syrupAmount;
			return true;
		}
		return false;
	}

	//Override 
	@Override
	public int getTotalPrice(){
		return price + (shotAmount * SYRUP_PRICE) + (syrupAmount * SHOT_PRICE);
	}
	@Override
	public String toString(){
		String coffeeInfo = name + "(" + getHotIce() + ")" + "\t"+getPrice();
		if(shotAmount > 0)
			coffeeInfo += "\n샷추가    : " + getShotAmount() + "\t\t+"+getShotPrice();
		if (syrupAmount > 0)
			coffeeInfo += "\n시럽추가 : " + getSyrupAmount()+ "\t\t+"+getSyrupPrice();
		coffeeInfo += "\n최종가격 : \t\t" + getTotalPrice();
		return coffeeInfo;
	}

}
