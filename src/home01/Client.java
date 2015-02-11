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
        ArrayList<TokenCheck> tokenCheckList = new ArrayList();
        
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
            tokenCheckList.add(temp);
        }
        
        // demonstrate constructors/methods with hardcoded values
        TokenCheck defaultDemo = new TokenCheck();
        defaultDemo.setDataString("Using$the$default$constructor");
        defaultDemo.setDelimiter("$");
        tokenCheckList.add(defaultDemo);
        
        // demonstrate overloaded constructor with hardcoded values
        TokenCheck overloadedDemo = new TokenCheck("*Overloaded*constructor"
                + "*demonstration", "*");
        
        tokenCheckList.trimToSize();
        for(TokenCheck current : tokenCheckList) {
            System.out.println(current.toString());
        }
        
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("home01objects.txt"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.toString());
        }
        for(TokenCheck current : tokenCheckList) {
            try {
                oos.writeObject(current);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                System.out.println(ex.toString());
            }
        }
        
        PrintWriter writer;
        File home01 = new File("home01.txt");
        try {
            writer = new PrintWriter(home01);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.toString());
        }
        
        for(TokenCheck current : tokenCheckList) {
            writer.write(current.getDataString() + "\n");
            writer.write(current.getDelimiter() + "\n");
            writer.write(current.getTokenType() + "\n");
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
