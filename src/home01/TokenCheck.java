package home01;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author Jaden Young
 */
public class TokenCheck {
    
    private String dataString;
    private String delimiter;
    private String tokenType;
    Scanner scan = new Scanner(dataString);
    
    /**
     * Default constructor<BR>
     * Initializes dataString and delimiter to empty strings, and tokenType to
     * "unknown".
     */
    public TokenCheck() {
        dataString = "asdf";
        delimiter = "";
        tokenType = "unknown";
    }
    
    /**
     * Overloaded constructor<BR>
     * Sets the data string to specified string, sets delimiter to specified 
     * delimiter, and determines the token type of the string
     * @param newDataString String to tokenize
     * @param newDelimiter Delimiter to use
     */
    public TokenCheck(String newDataString, String newDelimiter) {
        dataString = newDataString;
        setDelimiter(newDelimiter);
        //token type is determined in setDelimiter method
    }
    
    /**
     * Checks to see if all the tokens in the string are of the same specified
     * data type.<BR>
     * Only checks for char, boolean, int, and double.<BR>
     * Returns true if all tokens are equal, false if not
     * @param expectedDataType Data type to search for
     * @return true if all tokens are of the same data type as the search key
     */
    public boolean checkTokens(String expectedDataType) {
        String dataType = expectedDataType.toLowerCase();
        scan.useDelimiter(delimiter);
        switch (dataType) {
            case "boolean":
                try {
                    while(scan.hasNext()) {
                        scan.nextBoolean();
                    }
                    return true;
                } catch (InputMismatchException e) {
                    return false;
                }
            case "char":
                while(scan.hasNext()) {
                    String temp = scan.next();
                    if(temp.length() == 1 && Character.isLetter(temp.charAt(0)))
                    return true;
                }
                return false;
            case "double":
                try {
                    while(scan.hasNext()) {
                        scan.nextDouble();
                    }
                    return true;
                } catch (InputMismatchException e) {
                    return false;
                }
            case "int":
                try {
                    while(scan.hasNext()) {
                        scan.nextInt();
                    }
                    return true;
                } catch (InputMismatchException e) {
                    return false;
                }
            default:
                return false;
        }
    }
    
    /**
     * Checks each token to determine the token type of the entire string.<BR>
     * Sets the tokenType instance variable to one of the following options: 
     * boolean,
     * char,
     * double,
     * int,
     * mixed,
     * unknown,
     */
    public final void determineTokenType() {
        int count = 0;
        String type = "";
        if(hasBoolean()) {
            count++;
            type = "boolean";
        }
        if(hasChar()) {
            count++;
            type = "char";
        }
        if(hasDouble()) {
            count++;
            type = "double";
        }
        if(hasInt()) {
            count++;
            type = "double";
        }
        switch (count) {
            case 0:
                tokenType = "unknown";
                break;
            case 1:
                if(checkTokens(type))
                    tokenType = type;
                break;
            default:
                tokenType = "mixed";
        }
    }
    
    /**
     * Sets the delimiter to be used to a new specified value, and also
     * sets the tokenType variable to the appropriate type after the 
     * delimiter change
     * @param newDelimiter new delimiter to use 
     */
    public final void setDelimiter(String newDelimiter) {
        delimiter = newDelimiter;
        scan.useDelimiter(delimiter);
        determineTokenType();
    }
    
    /**
     * Sets the string that the object will check. In order to set a new string,
     * the delimiter for this instance must be set to a nonempty string, else 
     * method returns false and does not assign the string.
     * @param newDataString new string to check
     * @return True if assignment was successful, false if not.
     */
    public boolean setDataString(String newDataString) {
        if(delimiter.length() == 0)
            return false;
        dataString = newDataString;
        return true;
    }
    
    /** Returns the string containing the data that the object checks */
    public String getDataString() {
        return dataString;
    }
    
    /** Returns the delimiter used by the object */
    public String getDelimiter() {
        return delimiter;
    }
    
    /** Returns the token type of the string stored in the object */
    public String getTokenType() {
        return tokenType;
    }
    
    /** Returns a printable string containing the instance variables */
    @Override
    public String toString() {
        String output = "";
        output += "Data String: " + dataString;
        output += "\nDelimiter: " + delimiter;
        output += "\nToken type: " + tokenType;
        return output;
    }
    
    /** Compares two TokenCheck objects for equality */
    @Override
    public boolean equals(Object xObj) {
        if(!(xObj instanceof TokenCheck))
            return false;
        TokenCheck obj = (TokenCheck)xObj;
        if(!(dataString.equals(obj.getDataString())))
            return false;
        if(!(delimiter.equals(obj.getDelimiter())))
            return false;
        return tokenType.equals(obj.getTokenType());
    }
    
    private boolean hasBoolean() {
        while(scan.hasNext()) {
            try {
                scan.nextBoolean();
                return true;
            } catch (InputMismatchException e) {
                //do nothing
            }
        }
        return false;
    }

    private boolean hasChar() {
        while(scan.hasNext()) {
            String temp = scan.next();
            if(temp.length() == 1 && Character.isLetter(temp.charAt(0)))
                return true;
            }
            return false;
    }

    private boolean hasDouble() {
        while(scan.hasNext()) {
            try {
                scan.nextDouble();
                return true;
            } catch (InputMismatchException e) {
                //do nothing
            }
        }
        return false;
    }

    private boolean hasInt() {
        while(scan.hasNext()) {
            try {
                scan.nextInt();
                return true;
            } catch (InputMismatchException e) {
                //do nothing
            }
        }
        return false;
    }
    
}
