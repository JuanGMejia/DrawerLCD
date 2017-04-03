
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juan Gui
 */
public class Reader {
    
    private List<Comand> comandList = new ArrayList<>();
    String comandEntry;
    
    DrawerLCD drawer;

    public Reader(DrawerLCD drawer) {
        this.drawer = drawer;
    }

    public List<Comand> getComandList() {
        return comandList;
    }
    
    
    
    public void read(){
        try (Scanner reader = new Scanner(System.in)){
                System.out.print("Space between digits(0 to 5): ");
                comandEntry = reader.next();
                
                if(Validator.isValidNumber(comandEntry)){
                    drawer.setDigitSpace(Integer.parseInt(comandEntry));
                    if(Validator.isNotValidSize(drawer.getDigitSpace())){
                    throw new IllegalArgumentException("The space between "
                                + "digits must be between 0 to 5");
                    
                    }
                }
                else{
                    throw new IllegalArgumentException(comandEntry
                            + " is not a integer");
                }
                
                
                System.out.print("Input: ");
                comandEntry = reader.next();
                boolean continueReading = Validator.isFinalString(comandEntry);
                while(continueReading){
                    if(Validator.notContainComma(comandEntry)){
                        throw new IllegalArgumentException("String " + comandEntry
                        + " no contain ,");
                    }
                    comandList.add(createComand(comandEntry));
                    System.out.print("Input: ");
                    comandEntry = reader.next();
                    continueReading = Validator.isFinalString(comandEntry);
                }
            }
    }
 

    public Comand createComand(String comandEntry){
        String [] separator = comandEntry.split(",");
        if(Validator.containManyCommas(separator)){
            throw new IllegalArgumentException("String " + comandEntry
                    + " contain two or more ,");
        }
        if(Validator.validStructure(separator)){
           throw new IllegalArgumentException("String " + comandEntry
                    + " no contain required parameters");  
        }
        Comand comand=new Comand();
        comand.setSizeSegment(Integer.parseInt(separator[0]));
        comand.setNumber(separator[1]);
        return comand;
    }
}
