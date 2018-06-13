import java.util.Comparator;

public class LastNameComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		
		return ((Contact) o1).getLast().compareTo(((Contact) o2).getLast() );
	}

}
