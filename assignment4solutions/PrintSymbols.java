/**
 * This program displays the symbols given as a command line argument 
 * according to the format specified as the command line arguments
 * 
 * java PrintSymbols [star|dollar] number_of_symbols number_of_symbols_per_line
 * 
 * The input validation in this program is intentionally incomplete
 * Please do not distribute this code outside the class of SWE510 Fall, 2017
 * 
 * @author Yonghee Shin
 *
 */
public class PrintSymbols {

    public static void main(String[] args) {
        
        // validate command line arguments
         if(args.length != 3) {
            System.out.println("Usage: java PrintSymbols [star|dollar] number_of_symbols number_of_symbols_per_line");
            return;
        }
         
        String symbolName = args[0];
        boolean invalidInput = (Symbol.fromName(symbolName) == null) ? true : false;
        
        int numSymbols = 0;
        int numSymbolsPerLine = 0;
        try {
            numSymbols = Integer.parseInt(args[1]);
            numSymbolsPerLine = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            invalidInput |= false;
        }
        
        if(invalidInput) {
            System.out.println("Usage: java PrintSymbols [star|dollar] number_of_symbols number_of_symbols_per_line");
            return;
        }
        
        // print symbols
        for(int i=0; i < numSymbols; i++) {
            if(i !=0 && i % numSymbolsPerLine == 0) {
                System.out.println();
            }            
            System.out.print(Symbol.fromName(symbolName).getSymbol());
        }
    }

}
