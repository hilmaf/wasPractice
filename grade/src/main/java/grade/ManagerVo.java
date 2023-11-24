package grade;

public class ManagerVo {
	
	private String managerNumber;
	private String managerName;
	private String managerHireDate;
	
	
	public ManagerVo() {
		
	}
	
	public ManagerVo(String managerNumber, String managerName, String managerHireDate) {
		super();
		this.managerNumber = managerNumber;
		this.managerName = managerName;
		this.managerHireDate = managerHireDate;
	}
	
	
	public String getManagerNumber() {
		return managerNumber;
	}
	public void setManagerNumber(String managerNumber) {
		this.managerNumber = managerNumber;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerHireDate() {
		return managerHireDate;
	}
	public void setManagerHireDate(String managerHireDate) {
		this.managerHireDate = managerHireDate;
	}
	
	
	@Override
	public String toString() {
		return "ManagerVo [managerNumber=" + managerNumber + ", managerName=" + managerName + ", managerHireDate="
				+ managerHireDate + "]";
	}
	
	
}
