/**
 * This class declares symbol enum constants with their names and symbols
 * 
 * Please do not distribute this code outside the class of SWE510 Fall, 2017
 * 
 * @author Yonghee Shin 
 * 
 */
public enum Symbol {
    STAR("star", "*"),
    DOLLAR("dollar", "$");
   
    private String name;
    private String symbol;
    
    Symbol(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }
    
    public String getName() {
        return name;
    }
    
    public String getSymbol() {
        return symbol;
    }
    
    public static Symbol fromName(String symbol) {
        for(Symbol s : Symbol.values()) {
            if(s.getName().equals(symbol)) {
                return s;
            }
        }
        return null;
    }
}
