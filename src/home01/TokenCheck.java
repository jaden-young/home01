package home01;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author jaden
 */
public class TokenCheck {
    
    private String dataString;
    private String delimiter;
    private String tokenType;
    Scanner scan = new Scanner(dataString);
    
    public TokenCheck() {
        dataString = "";
        delimiter = "";
        tokenType = "unknown";
    }
    
    public TokenCheck(String newDataString, String newDelimiter) {
        dataString = newDataString;
        //token type is determined in setDelimiter method
        setDelimiter(newDelimiter);
        
    }
    
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
                    char[] chars = temp.toCharArray();
                    if(chars.length != 1 || !Character.isLetter(chars[0]))
                        return false;
                }
                return true;
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
    
    public final void setDelimiter(String newDelimiter) {
        delimiter = newDelimiter;
        scan.useDelimiter(delimiter);
        determineTokenType();
    }
    
    
    
        private boolean hasBoolean() {
            scan.useDelimiter(delimiter);
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
            scan.useDelimiter(delimiter);
            boolean isCharString = false;
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
