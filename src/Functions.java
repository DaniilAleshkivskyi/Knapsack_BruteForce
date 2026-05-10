import Models.ItemModel;
import java.util.ArrayList;

public class Functions {

    public static void generateBinary(int numberOfDigits) {
        int number = (int) Math.pow(2, numberOfDigits);
        for(int i = 0; i < number; i++)
        {
            String binary = Integer.toBinaryString(i);
            //fills string with spaces %3s for instance -> "1" -> "   1" -> "0001"
            String numberBinary = String.format("%" + numberOfDigits + "s", binary).replace(" ", "0");
        }
    }

    public static String encodeBin(int n, int totalItems) {
        StringBuilder binary = new StringBuilder();

        for (int i = 0; i < totalItems; i++) {
            int bit = (n >> i) & 1;// for instance we have 13 = 1101  -> 13 >>(move bit to the right) 0 = 13 | 1101 -> last bit 1 & 1 = 1 but if  13 >> 1 = 6 | 110 -> last bit 0 & 1 = 0
            binary.insert(0, bit);
        }
        return binary.toString();
    }
}
