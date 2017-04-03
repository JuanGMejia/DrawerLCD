import java.util.List;

public class DrawerLCD {

    private int digitSpace;
    static final String VERTICAL_CHARACTER = "|";
    static final String HORIZONTAL_CHARACTER = "-";
    private Screen screenLCD;
    private final FixedPoint fixedPoint1;
    private final FixedPoint fixedPoint2;
    private final FixedPoint fixedPoint3;
    private final FixedPoint fixedPoint4;
    private final FixedPoint fixedPoint5;
    

    public DrawerLCD() {
        this.fixedPoint1 = new FixedPoint();
        this.fixedPoint2 = new FixedPoint();
        this.fixedPoint3 = new FixedPoint();
        this.fixedPoint4 = new FixedPoint();
        this.fixedPoint5 = new FixedPoint();
    }

    public Screen getScreenLCD() {
        return screenLCD;
    }

    public void setScreenLCD(Screen screenLCD) {
        this.screenLCD = screenLCD;
    }
    
    public int getDigitSpace() {
        return digitSpace;
    }

    public void setDigitSpace(int digitSpace) {
        this.digitSpace = digitSpace;
    }

    private void addLine(Comand comand, FixedPoint fixedPoint, String fixedPosition,String character) {
        
        if(Validator.isAxisX(fixedPosition)) 
        {
            for (int axisX = 1; axisX <= comand.getSizeSegment(); axisX++) 
            {
                int valueInScreen = fixedPoint.getY() + axisX;
                this.screenLCD.assignValueInScreen(fixedPoint.getX(), valueInScreen, character);
            }
        } 
        else 
        {
            for (int axisY = 1; axisY <= comand.getSizeSegment(); axisY++) 
            {
                
                int valueInScreen = fixedPoint.getX() + axisY;
                this.screenLCD.assignValueInScreen(valueInScreen, fixedPoint.getY(), character);
            }
        }
    }


    public void addSegment(Comand comand,int segment) {
        
        switch(segment){
            case 1:
                this.addLine(comand,this.fixedPoint1,Validator.POSITION_Y, VERTICAL_CHARACTER);
                break;
            case 2:
                this.addLine(comand,this.fixedPoint2,Validator.POSITION_Y,VERTICAL_CHARACTER);
                break;
            case 3:
                this.addLine(comand,this.fixedPoint5,Validator.POSITION_Y,VERTICAL_CHARACTER);
                break;
            case 4:
                this.addLine(comand,this.fixedPoint4,Validator.POSITION_Y,VERTICAL_CHARACTER);
                break;
            case 5:
                this.addLine(comand,this.fixedPoint1,Validator.POSITION_X,HORIZONTAL_CHARACTER);
                break;
            case 6:
                this.addLine(comand,this.fixedPoint2, Validator.POSITION_X,HORIZONTAL_CHARACTER);
                break;
            case 7:
                this.addLine(comand,this.fixedPoint3,Validator.POSITION_X,HORIZONTAL_CHARACTER);
                break;
            default:
                break;
        }
    }


    private void drawNumber(Comand comand) 
    {
        
        this.screenLCD.setDigitColum(comand.getSizeSegment()+2);
        this.screenLCD.setDigitsRow((2 * comand.getSizeSegment()) + 3);
        this.screenLCD.setTotalRows();
        this.screenLCD.setTotalColumns(this.screenLCD.getDigitColum() * comand.getNumber().length()
                + (this.getDigitSpace() * comand.getNumber().length()));

        this.screenLCD.setScreen(); 
        this.screenLCD.initializeScreen();

        this.calculateFixedPoint(comand);
        
        this.screenLCD.showScreen();
    }


    public void draw(List<Comand> comandList){
        try {
            
            for(int i=0;i<comandList.size();i++){
                 try 
                {
                    screenLCD = new Screen();
                    this.drawNumber(comandList.get(i));
                } catch (Exception ex)
                {
                    System.out.println("Error: "+ex.getMessage());
                }
            }
            
        } catch (Exception ex) 
        {
            System.out.println("Error: "+ex.getMessage());
        }
    }
    
    public void calculateFixedPoint(Comand comand){
        
        int pivotX = 0;
        char[] numberComplete = comand.getNumber().toCharArray();
        
        for(int i=0;i<numberComplete.length;i++){
            char digit = numberComplete[i];
            this.fixedPoint1.setX(0);
            this.fixedPoint1.setY(0 + pivotX);

            this.fixedPoint2.setX(this.screenLCD.getDigitsRow() / 2);
            this.fixedPoint2.setY(0 + pivotX);
            
            this.fixedPoint3.setX(this.screenLCD.getDigitsRow() - 1);
            this.fixedPoint3.setY(0 + pivotX);
            
            this.fixedPoint4.setX(this.screenLCD.getDigitColum() - 1);
            this.fixedPoint4.setY((this.screenLCD.getDigitsRow() / 2) + pivotX);
            
            this.fixedPoint5.setX(0);
            this.fixedPoint5.setY((this.screenLCD.getDigitColum() - 1) + pivotX);

            pivotX += this.screenLCD.getDigitColum() + this.getDigitSpace();
            
            this.screenLCD.getNumber().addDigit(digit,this);
            
            for(int j=0;j<this.screenLCD.getNumber().getDigits().get(i).getDigit().size();j++){
                this.addSegment(comand,this.screenLCD.getNumber().getDigits().get(i).getDigit().get(j));
            }   
        }
    }
}
