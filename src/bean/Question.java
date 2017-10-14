package bean;

public class Question{
	private Boolean isMutil;
	private Integer id;
	private Integer optionCount;
	private Integer[] arr;
	public Boolean getIsMutil() {
		return isMutil;
	}
	public void setIsMutil(Boolean isMuti) {
		this.isMutil = isMuti;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOptionCount() {
		return optionCount;
	}
	public void setOptionCount(Integer optionCount) {
		this.optionCount = optionCount;
	}
	public Integer[] getArr() {
		return arr;
	}
	public void setArr(Integer[] arr) {
		this.arr = arr;
	}
	
}
