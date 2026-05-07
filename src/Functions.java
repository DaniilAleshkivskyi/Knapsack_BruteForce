import Models.ItemModel;
import java.lang.Math.*;
import java.util.ArrayList;

public class Functions {

    public static void bruteForce(ArrayList<ItemModel> items, int capacity) {
        int a = 0b111;
        System.out.println(a);
    }

    public static void generateBinary(int numberOfDigits) {
        int number = (int) Math.pow(2, numberOfDigits);
        for(int i = 0; i < number; i++)
        {
            String binary = Integer.toBinaryString(i);
            String numberBinary = String.format("%" + numberOfDigits + "s", binary).replace(" ", "0");
            System.out.println(numberBinary);
        }
    }

    public static String encodeBin(int n) {
        if (n == 0) return "0";

        StringBuilder binary = new StringBuilder();
        while (n > 0) {
            int bit = n % 2;
            binary.insert(0, bit);
            n = n / 2;
        }
        return binary.toString();
    }
}
