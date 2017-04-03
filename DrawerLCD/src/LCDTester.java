

public class LCDTester {

    public static void main(String[] args) {
        
        DrawerLCD drawer = new DrawerLCD();
        Reader reader = new Reader(drawer);
        reader.read();
        drawer.draw(reader.getComandList());

    }

}
