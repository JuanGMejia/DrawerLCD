
import java.util.ArrayList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juan Gui
 */
public class Number {
    
    private ArrayList<Digit> digits;
    private Digit digit;
    
    public Number() {
        this.digits = new ArrayList();
    }

    public ArrayList<Digit> getDigits() {
        return digits;
    }

    public Digit getDigit() {
        return digit;
    }

    public void addDigit(char digitNumber,DrawerLCD drawer) {
            
            if(Validator.isNotDigit(digitNumber))
            {
                throw new IllegalArgumentException("Character " + digitNumber
                    + " is not a digit");
            }
            int number = Integer.parseInt(String.valueOf(digitNumber));
            digit = new Digit();
            this.digit.generateDigit(number);
            this.digits.add(this.digit);
    }
        
}
