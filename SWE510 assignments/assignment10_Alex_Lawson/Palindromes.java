
/**
 * 
 * @author Alex Lawson
 * 
 * Here is the website I used to get the Palindrome code:
 * https://stackoverflow.com/questions/4367260/creating-a-recursive-method-for-palindrome
 * 
 *The changes and improvements I made to the code I have commented in the code.
 *
 */


public class Palindromes {

	public static void main(String[]args)
    {
		System.out.printf("**WELCOME TO THE PALINDROME PROGRAM**%n%n");
		
		//list of strings that I test to see whether they are a palindrome or not.
        palindromeHelper("radar");
        palindromeHelper("able was i ere i saw elba.");
        palindromeHelper("A man, a plan, a canal-Panama.");
        palindromeHelper("A nut for a jar of tuna.");
        palindromeHelper("Air an aria.");
        palindromeHelper("Art, name no tub time. Emit but one mantra.");
        palindromeHelper("This is a sentence.");
        palindromeHelper("Hello!!");
        palindromeHelper("12345678987654321");
        palindromeHelper("Hi, how are you.");
        
    }	
	
	
	//this recursive method was found online
	public static boolean isPalindrome(String s)
    {
		//I added this line of code to remove all the characters that weren't letters or numbers
		s = s.replaceAll("[^a-zA-Z0-9]", "");
				
        if(s.length() == 0 || s.length() == 1)
            // if length =0 OR 1 then it is
            return true; 
        
        //I changed this conditional statement so the case of the character doesn't matter
        if(Character.toLowerCase(s.charAt(0)) == Character.toLowerCase(s.charAt(s.length()-1)))
            // check for first and last char of String:
            // if they are same then do the same thing for a substring
            // with first and last char removed. and carry on this
            // until you string completes or condition fails
            return isPalindrome(s.substring(1, s.length()-1));

        // if its not the case than string is not.
        return false;
    }
	
	//prints to the screen whether a string is a palindrome or not.
	public static void palindromeHelper(String s) {
		
		if(isPalindrome(s))
            System.out.println("<< "+s+" >>" + " IS a palindrome");
        else
            System.out.println("<< "+s+" >>" + " is NOT a palindrome");
	}
}
