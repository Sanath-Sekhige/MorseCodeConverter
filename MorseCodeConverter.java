import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MorseCodeConverter {
    private static final Map<String, String> morseCodeMap = new HashMap<>();

    static {
        morseCodeMap.put(".-", "A");
        morseCodeMap.put("-...", "B");
        morseCodeMap.put("-.-.", "C");
        morseCodeMap.put("-..", "D");
        morseCodeMap.put(".", "E");
        morseCodeMap.put("..-.", "F");
        morseCodeMap.put("--.", "G");
        morseCodeMap.put("....", "H");
        morseCodeMap.put("..", "I");
        morseCodeMap.put(".---", "J");
        morseCodeMap.put("-.-", "K");
        morseCodeMap.put(".-..", "L");
        morseCodeMap.put("--", "M");
        morseCodeMap.put("-.", "N");
        morseCodeMap.put("---", "O");
        morseCodeMap.put(".--.", "P");
        morseCodeMap.put("--.-", "Q");
        morseCodeMap.put(".-.", "R");
        morseCodeMap.put("...", "S");
        morseCodeMap.put("-", "T");
        morseCodeMap.put("..-", "U");
        morseCodeMap.put("...-", "V");
        morseCodeMap.put(".--", "W");
        morseCodeMap.put("-..-", "X");
        morseCodeMap.put("-.--", "Y");
        morseCodeMap.put("--..", "Z");

        morseCodeMap.put("-----", "0");
        morseCodeMap.put(".----", "1");
        morseCodeMap.put("..---", "2");
        morseCodeMap.put("...--", "3");
        morseCodeMap.put("....-", "4");
        morseCodeMap.put(".....", "5");
        morseCodeMap.put("-....", "6");
        morseCodeMap.put("--...", "7");
        morseCodeMap.put("---..", "8");
        morseCodeMap.put("----.", "9");
    }

    public static String convertMorseToText(String morseCode) {
        StringBuilder result = new StringBuilder();
        String[] words = morseCode.split("   ");

        for (String word : words) {
            String[] letters = word.split(" ");
            for (String letter : letters) {
                String decodedLetter = morseCodeMap.get(letter);
                if (decodedLetter != null) {
                    result.append(decodedLetter);
                } else {
                    result.append("?");
                }
            }
            result.append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Morse code (separate letters with a space and words with three spaces):");
        String userInput = scanner.nextLine();

        String convertedText = convertMorseToText(userInput);
        System.out.println("Converted Text: " + convertedText);

        scanner.close();
    }
}


/*
Test Cases
    HELLO WORLD -> .... . .-.. .-.. ---   .-- --- .-. .-.. -..
    12345 67890 -> .---- ..--- ...-- ....- .....   -.... --... ---.. ----. -----
    THERE IS NO PLACE LIKE HOME -> - .... . .-. .   .. ...   -. ---   .--. .-.. .- -.-. .   .-.. .. -.- .   .... --- -- .
    HELLO WORLD 1 2 3 4 ? ? -> .... . .-.. .-.. ---   .-- --- .-. .-.. -..   .----   ..---   ...--   ....-   -.-.--   -..-. 
*/