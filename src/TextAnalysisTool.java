import java.util.*;

public class TextAnalysisTool {

    // Method to count total number of characters in the input text
    public static int characterCount(String text) {
        return text.length();
    }

    // Method to count total number of words in the input text
    public static int wordCount(String text) {
        String[] words = text.split("\\s+");
        return words.length;
    }

    // Method to find the most common character in the text (ignoring spaces and case-insensitive)
    public static char mostCommonCharacter(String text) {
        text = text.replaceAll("\\s+", "").toLowerCase();
        Map<Character, Integer> charFrequency = new HashMap<>();

        // Calculate character frequency
        for (char c : text.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        // Find the most common character
        char mostCommon = ' ';
        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostCommon = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return mostCommon;
    }

    // Method to check and display the frequency of a specific character (case-insensitive)
    public static int characterFrequency(String text, char character) {
        text = text.toLowerCase();
        character = Character.toLowerCase(character);
        int frequency = 0;
        for (char c : text.toCharArray()) {
            if (c == character) {
                frequency++;
            }
        }
        return frequency;
    }

    // Method to check and display the frequency of a specific word (case-insensitive)
    public static int wordFrequency(String text, String word) {
        String[] words = text.toLowerCase().split("\\s+");
        word = word.toLowerCase();
        int count = 0;
        for (String w : words) {
            if (w.equals(word)) {
                count++;
            }
        }
        return count;
    }

    // Method to count the number of unique words in the text (case-insensitive)
    public static int uniqueWordsCount(String text) {
        String[] words = text.toLowerCase().split("\\s+");
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        return uniqueWords.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the input text from the user
        System.out.println("Please enter a paragraph or lengthy text:");
        String text = scanner.nextLine();

        // Perform text analysis
        System.out.println("Total number of characters: " + characterCount(text));
        System.out.println("Total number of words: " + wordCount(text));

        // Display the most common character
        char commonChar = mostCommonCharacter(text);
        System.out.println("Most common character: " + commonChar);

        // Ask the user for a character to check its frequency
        System.out.println("Enter a character to check its frequency:");
        char character = scanner.next().charAt(0);
        System.out.println("Frequency of '" + character + "': " + characterFrequency(text, character));

        // Ask the user for a word to check its frequency
        System.out.println("Enter a word to check its frequency:");
        scanner.nextLine();  // Consume newline left by next().charAt()
        String word = scanner.nextLine();
        System.out.println("Frequency of '" + word + "': " + wordFrequency(text, word));

        // Display the number of unique words
        System.out.println("Number of unique words: " + uniqueWordsCount(text));

        scanner.close();
    }
}
