import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String targetString = "Hello, World!";
        String dictionary =
                "1234567890!@#$%^&*()qwertyuiop[]asdfghjkl;'zxcvbnm,./QWERTYUIOP{}ASDFGHJKL:\"ZXCVBNM<>? ";

        int attempt = 0;
        int targetStringLength = targetString.length();
        int count = 0;

        char[] bruteCharArray = new char[targetStringLength];

        boolean isFound = false;

        ArrayList<String> dicts = new ArrayList<>();

        for (int i = 0; i < targetStringLength; i++) {
            dicts.add(dictionary);
        }

        while (!isFound) {

            for (int i = 0; i < targetStringLength; i++) {

                String currentDict = dicts.get(i);
                if (currentDict.length() > 0) {
                    Random rn = new Random();
                    int num = rn.nextInt(currentDict.length());

                    char symbol = currentDict.charAt(num);
                    bruteCharArray[i] = symbol;

                    if (targetString.charAt(i) == symbol) {
                        dicts.set(i, "");
                        count++;
                    } else {
                        currentDict = currentDict.replace(String.valueOf(symbol), "");
                        dicts.set(i, currentDict);
                    }
                }
            }
            if (count == targetStringLength)
                isFound = true;

            attempt++;
            String outputStroke = new String(bruteCharArray);
            System.out.println(outputStroke+" Attempt: "+attempt);
        }

        System.out.println("\nType 'e' to exit program");
        Scanner scan = new Scanner(System.in);
        while(!scan.next().equals("e")){}
    }
}
