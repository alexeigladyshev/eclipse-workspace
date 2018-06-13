
public class Contact implements Comparable<Contact>{

	//the four instance variables of the class
	private String socialSecurityNumber;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	
	//constructor
	public Contact(String SSN, String first, String last, String phoneNumber) {
		this.socialSecurityNumber = SSN;
		this.firstName = first;
		this.lastName = last;
		this.phoneNumber = phoneNumber;
	}
	
	public String getSSN() {
		return socialSecurityNumber;
	}
	public String getFirst() {
		return firstName;
	}
	public String getLast() {
		return lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String toString() {
		return String.format("%s %s %s %s", socialSecurityNumber, firstName, lastName, phoneNumber);
	}
	
	//implement this method from the Comparable interface
	@Override
	public int compareTo(Contact o) {
		//natural order
		return socialSecurityNumber.compareTo(o.getSSN() );
	}
	
	//compares whether the two objects are equal based on whether the social security numbers are equal
	@Override
	public boolean equals(Object o) {
		if(o==null) return false;
		if(!(o instanceof Contact)) return false;
		Contact contact = (Contact)o;
		return this.socialSecurityNumber.equals(contact.socialSecurityNumber);
	}
	//for Collections HashSet and HashMap
	@Override
	public int hashCode() {
		return socialSecurityNumber.hashCode();
	}
}
