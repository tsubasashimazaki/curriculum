package bean;
/**
 * ・社員情報データ（モデル）
 */
public class MachineBean {
    private String ProId;
    private String Name;
    private String Price;
    private String Stock;
    private String image;
	/**
	 * @return proId
	 */
	public String getProId() {
		return ProId;
	}
	/**
	 * @param proId セットする proId
	 */
	public void setProId(String proId) {
		ProId = proId;
	}
	/**
	 * @return name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		Name = name;
	}
	/**
	 * @return price
	 */
	public String getPrice() {
		return Price;
	}
	/**
	 * @param price セットする price
	 */
	public void setPrice(String price) {
		Price = price;
	}
	/**
	 * @return stock
	 */
	public String getStock() {
		return Stock;
	}
	/**
	 * @param stock セットする stock
	 */
	public void setStock(String stock) {
		Stock = stock;
	}
	/**
	 * @return image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image セットする image
	 */
	public void setImage(String image) {
		this.image = image;
	}
}