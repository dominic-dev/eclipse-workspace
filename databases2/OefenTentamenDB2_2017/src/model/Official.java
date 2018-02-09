package model;

public class Official {
	
	private int officialId; 
	private String firstName;
	private String lastName;
	private String countryCode;
	private String role;
	
	public Official(String firstName,String lastName, String countryCode, String role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.countryCode = countryCode;
		this.role = role;
    }

	public Official(int officialId, String firstName,String lastName, String countryCode, String role) {
        this(firstName, lastName, countryCode, role);
		this.officialId = officialId;
	}
	
	public int getOfficialId() {
		return officialId;
	}
	public void setOfficialId(int officialId) {
		this.officialId = officialId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String toString() {
		return "[" + officialId + ", " + firstName + ", " + lastName + ", " + countryCode + ", " + role + "]" ;
		
	}
}
