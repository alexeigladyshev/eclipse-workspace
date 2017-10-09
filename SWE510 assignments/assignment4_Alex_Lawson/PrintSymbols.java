public class PrintSymbols {

	public static void main(String[] args) {
		
		try {   //try case to make sure all 3 arguments have been entered
			String type = args[0];  //first argument is the type of symbol to print
			String symbol="";
			
			switch(type) {			//can easily add more switch cases for different symbol types :)
				case "dollar":
					symbol = "$"; 
					break;
				case "star":
					symbol = "*";
					break;
				default:			//if symbol isn't dollar or star, quit print statement and quit application
					System.out.println("\nUsage: java PrintSymbols [star|dollar] number_of_symbols"+
					"number_of_symbols_per_line\n");
	                return;	
			}
			
			int total = Integer.parseInt(args[1]);  //get first integer of total amount of symbols to print
			int perLine = Integer.parseInt(args[2]); //get second integer of symbols per line to print
			int count=0;				//counter to track how many symbols have been printed per line
			
			System.out.println(); //formatting line break for organization
			
			for(int i=0; i<total;i++) {  //for statement to print our symbol
				System.out.print(symbol);
				count++;
				if (count%perLine==0 && i<total-1) {  //second condition is so we don't println() twice
					
					System.out.println("\n");
				}
			}
			System.out.println("\n");  //another formatting line break after printing for organization
		}
		catch (ArrayIndexOutOfBoundsException e) {   //catch the exception if user enters less than 2 numbers
			System.out.println("\nUsage: java PrintSymbols [star|dollar] number_of_symbols number_of_symbols_per_line\n");
		}
	}
}
