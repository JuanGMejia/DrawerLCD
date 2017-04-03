
public class Validator {
    static final String FINAL_STRING = "0,0";
    static int MAXIMUM_SIZE=5;
    static int MINIMUM_SIZE=1;
    static int MINIMUN_COMMAS=2;
    static String POSITION_X = "X";
    static String POSITION_Y = "Y";
        
    public static boolean isValidNumber(String comandEntry){
        return isNumeric(comandEntry);
    }
    
    public static boolean isNotValidSize(int digitSpace){
        return digitSpace < MINIMUM_SIZE || digitSpace > MAXIMUM_SIZE;
    }
    
    public static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static boolean isFinalString(String comandEntry){
        return !comandEntry.equalsIgnoreCase(FINAL_STRING);
    }
    public static boolean notContainComma(String comandEntry){
        return !comandEntry.contains(",");
    }
    
    public static boolean containManyCommas(String[] commas){
        return commas.length>MINIMUN_COMMAS;
    }

    public static boolean validStructure(String[] structure){
        return structure.length<2;
    }
    
    public static boolean isAxisX(String value){
        return value.equalsIgnoreCase(POSITION_X);
    }
    
    public static boolean isNotDigit(char digit){
        return !Character.isDigit(digit);
    }
    
}
