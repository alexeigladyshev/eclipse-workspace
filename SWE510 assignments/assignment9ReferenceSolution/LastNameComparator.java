// custom comparator used to sort contacts by lastName
import java.util.Comparator;

public class LastNameComparator implements Comparator<Contact>{
	@Override
	   public int compare(Contact o1, Contact o2) {
		// compares the lastNames
		return o1.getLastName().compareTo(o2.getLastName());
	   } 

}
