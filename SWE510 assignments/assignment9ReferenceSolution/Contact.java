public class Contact implements Comparable<Contact> {
	private String socialSecurityNumber;
	private String firstName;
	private String lastName;
	private String phoneNumber;

	public Contact(String socialSecurityNumber, String firstName, String lastName, String phoneNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}
	
	// get LastName
	public String getLastName() {
		return lastName;
	}

	@Override
	public int compareTo(Contact o) {
		return this.socialSecurityNumber.compareTo(o.socialSecurityNumber);
	}
	
	@Override
	public String toString() {
		return String.format("%s %s %s %s%n", socialSecurityNumber,firstName, lastName, phoneNumber);
	}
	@Override
	public boolean equals(Object o) {
	if(o == null) return false;
	if(!(o instanceof Contact)) return false;
	Contact contact = (Contact)o;
	return this.socialSecurityNumber.equals(contact.socialSecurityNumber);
	}
	@Override
	public int hashCode() {
	return socialSecurityNumber.hashCode();
	}
	
	

}
