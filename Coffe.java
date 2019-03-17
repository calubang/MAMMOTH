//shotAmount : 샷추가 개수 기본은 1
//syrupAmount : 시럽추가 개수 기본은 1
class Coffe extends Drink {
	static int SYRUP_PRICE = 500;
	static int SHOT_PRICE = 500;
	int shotAmount;
	int syrupAmount;

	public int getShotAmount(){
		return shotAmount;
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
	public boolean setSyrupAmount(int syrupAmount){
		if (syrupAmount > 0){
			this.syrupAmount = syrupAmount;
			return true;
		}
		return false;
	}

	public String toString(){
		String coffeeInfo = name + "(" + price + ")";
		if(shotAmount > 1)
			coffeeInfo += "\n샷추가 : " + shotAmount;
		if (syrupAmount > 1)
			coffeeInfo += "\n시럽추가 : " + syrupAmount;
		return coffeeInfo;
	}

}
