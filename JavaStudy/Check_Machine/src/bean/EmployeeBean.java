package bean;
/**
 * ・社員情報データ（モデル）
 */
public class EmployeeBean {
    private String Id;
    private String PassWord;
    private String Name;
    private String Comment;
    private String Login_Time;

	/**
	 * @return id
	 */
	public String getId() {
		return Id;
	}
	/**
	 * @param id セットする id
	 */
	public void setId(String id) {
		Id = id;
	}
	/**
	 * @return passWord
	 */
	public String getPassWord() {
		return PassWord;
	}
	/**
	 * @param passWord セットする passWord
	 */
	public void setPassWord(String passWord) {
		PassWord = passWord;
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
	 * @return comment
	 */
	public String getComment() {
		return Comment;
	}
	/**
	 * @param comment セットする comment
	 */
	public void setComment(String comment) {
		Comment = comment;
	}
	/**
	 * @return login_Time
	 */
	public String getLogin_Time() {
		return Login_Time;
	}
	/**
	 * @param login_Time セットする login_Time
	 */
	public void setLogin_Time(String login_Time) {
		Login_Time = login_Time;
	}

}