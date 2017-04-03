
public class Screen {
    private int digitsRow;
    private int digitColum;
    private int totalRows;
    private int totalColumns;
    private String[][] screen;
    private Number number;

    public Screen() {

        this.number = new Number();
    }

    public Number getNumber() {
        return number;
    }

    public int getDigitsRow() {
        return digitsRow;
    }

    public void setDigitsRow(int digitsRow) {
        this.digitsRow = digitsRow;
    }

    public int getDigitColum() {
        return digitColum;
    }

    public void setDigitColum(int digitColum) {
        this.digitColum = digitColum;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows() {
        this.totalRows = this.digitsRow;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }

    public String[][] getScreen() {
        return screen;
    }

    public void setScreen() {
        this.screen = new String[this.getTotalRows()][this.getTotalColumns()];
    }
    
    public void initializeScreen(){
        for (int i = 0; i < this.getTotalRows(); i++) {
            for (int j = 0; j < this.getTotalColumns(); j++) {
                this.screen[i][j] = " ";
            }
        }
    }
    
   
    
    public void showScreen(){
        
        for (int i = 0; i < this.getTotalRows(); i++) {
            for (int j = 0; j < this.getTotalColumns(); j++) {
                System.out.print(this.screen[i][j]);
            }
            System.out.println();
        }
    }
    
    public void assignValueInScreen(int x,int y,String value){
        this.screen[x][y] = value;
    }     
    
}
