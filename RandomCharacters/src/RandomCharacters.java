import java.util.*;
import java.security.SecureRandom;

/**
 * @author Alex Lawson
 * 
 * I have added comments in the code to explain what I am doing
 */

public class RandomCharacters
{
   public static void main(String[] args) 
   {
      List<Character> list = new ArrayList<>();
      String alphabet = "abcdefghijklmnopqrstuvwxyz";
      SecureRandom random = new SecureRandom();

      for (int i = 0; i < 30; ++i)
      {
         list.add(alphabet.charAt(random.nextInt(26)));
      }

      // a)	Sort the List in ascending order and display the results in a single line.
      // put your code here
      System.out.println();
      
	  list.stream().sorted().forEach(System.out::print); // you have to finish this statement
	  System.out.println();

      // b)	Sort the List in descending order and display the results in a single line.
      // You can use the following method reference to obtain a comparator and 
      // use method reversed of interface Comparator
      // Comparator<Character> compare = Character::compareTo;
      Comparator<Character> compare = Character::compareTo;
      
      // put your code here
      list.stream().sorted(compare.reversed()).forEach(System.out::print);
     
      System.out.println();
      
      // c)	Display the List in ascending order with duplicates removed in a single line.
      // put your code here
      list.stream().distinct().sorted().forEach(System.out::print);
      
      System.out.println();

      // d)	Display characters in the List whose lexicographical order is greater than ‘k’ in a single line.
      // put your code here
      list.stream().filter(x -> {
    	  	return x > 'k';
      }).forEach(System.out::print);
      
      System.out.println();
      
      // e)	Map the characters to upper characters and display the results in a single line.
      // put your code here
      list.stream().map(Character::toUpperCase).forEach(System.out::print);
      
      System.out.printf("\n\n");
   }
} 
