package home01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jaden Young
 */
public class Client {
    public static void main(String[] args) {
        
        Scanner scanUser = new Scanner(System.in);
        Scanner scanFile = null;
        File inputFile = null;
        ArrayList<TokenCheck> unsortedList = new ArrayList();
        
        // prompt for a file to read from
        System.out.print("Enter a file to read from > ");
        boolean needValidFile = true;
        while(needValidFile) {
            String userFile = scanUser.nextLine();
            inputFile = new File(userFile);
            try {
                scanFile = new Scanner(inputFile);
                needValidFile = false;
            } catch (FileNotFoundException e) {
                System.out.print("That was not a valid file name. "
                        + "Try again > ");
            }
        }
        
        // create TokenCheck objects out of each string/delimiter pair and add 
        // them to an array list
        while(scanFile.hasNext()) {
            String dataString = scanFile.nextLine();
            String delimiter = scanFile.nextLine();
            TokenCheck temp = new TokenCheck(dataString, delimiter);
            unsortedList.add(temp);
        }
        
        // demonstrate constructors/methods with hardcoded values
        TokenCheck defaultDemo = new TokenCheck();
        defaultDemo.setDataString("Using$the$default$constructor");
        defaultDemo.setDelimiter("$");
        unsortedList.add(defaultDemo);
        
        // demonstrate overloaded constructor with hardcoded values
        TokenCheck overloadedDemo = new TokenCheck("*Overloaded*constructor"
                + "*demonstration", "*");
        
        unsortedList.trimToSize();
        
        int lastIndexChecked = 0;
        ArrayList<TokenCheck> sortedList = new ArrayList(unsortedList.size());
        for(int i = 1; i < unsortedList.size(); i++) {
            
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
