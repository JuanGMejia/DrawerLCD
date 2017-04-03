
import java.util.ArrayList;
import java.util.List;


public class Digit {
     
    private List<Integer> digit;

    
    public Digit() {
        this.digit = new ArrayList<>();
    }

    public List<Integer> getDigit() {
        return digit;
    }
    
    public void generateDigit(int number) {

        switch (number){
            case 1:
                this.digit.add(3);
                this.digit.add(4);
                break;
            case 2:
                this.digit.add(5);
                this.digit.add(3);
                this.digit.add(6);
                this.digit.add(2);
                this.digit.add(7);
                break;
            case 3:
                this.digit.add(5);
                this.digit.add(3);
                this.digit.add(6);
                this.digit.add(4);
                this.digit.add(7);
                break;
            case 4:
                this.digit.add(1);
                this.digit.add(6);
                this.digit.add(3);
                this.digit.add(4);
                break;
            case 5:
                this.digit.add(5);
                this.digit.add(1);
                this.digit.add(6);
                this.digit.add(4);
                this.digit.add(7);
                break;
            case 6:
                this.digit.add(5);
                this.digit.add(1);
                this.digit.add(6);
                this.digit.add(2);
                this.digit.add(7);
                this.digit.add(4);          
                break;
            case 7:
                this.digit.add(5);
                this.digit.add(3);
                this.digit.add(4);
                break;
            case 8:
                this.digit.add(1);
                this.digit.add(2);
                this.digit.add(3);
                this.digit.add(4);
                this.digit.add(5);
                this.digit.add(6);
                this.digit.add(7);
                break;
            case 9:
                this.digit.add(1);
                this.digit.add(3);
                this.digit.add(4);
                this.digit.add(5);
                this.digit.add(6);
                this.digit.add(7);
                break;
            case 0:
                this.digit.add(1);
                this.digit.add(2);
                this.digit.add(3);
                this.digit.add(4);
                this.digit.add(5);
                this.digit.add(7);
                break;
        }

    }
    
}
