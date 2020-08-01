package check;

public class Pet {
	private String name;
	private String masterName;

	public Pet(String name, String masterName) { //Petメソッド。引数はname, masterName
		this.name = name; //thisはインスタンス自身でいいかな
		this.masterName = masterName;
	}

	//protected:同じパッケージ内のクラスや違うクラスでも、そのクラスを継承したサブクラス内部からアクセス可能
	protected String getName() {
		return name;
	}

	protected String getMasterName() {
		return masterName;
	}

	public void introduce() {
		System.out.println("■僕の名前は" + name + "です");
		System.out.println("■ご主人様は" + masterName + "です");
	}
}

class RobotPet extends Pet {
	public RobotPet(String name, String masterName) {
		super(name, masterName);
	}

	public void introduce() {
		System.out.println("◇私はロボット。名前は" + getName() + "。");
		System.out.println("◇ご主人様は" + getMasterName() + "。");
	}
}