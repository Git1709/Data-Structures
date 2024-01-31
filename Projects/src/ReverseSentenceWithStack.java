import java.util.Scanner;
import java.util.Stack;

public class ReverseSentenceWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        String reversedSentence = reverseSentence(sentence);
        System.out.println("Reversed Sentence: " + reversedSentence);

        scanner.close();
    }

    public static String reverseSentence(String sentence) {
        Stack<String> stack = new Stack<>();
        StringBuilder reversed = new StringBuilder();

        // Split the sentence into words
        String[] words = sentence.split("\\s+");

        // Push each word onto the stack
        for (String word : words) {
            stack.push(word);
        }

        // Pop words from the stack to build the reversed sentence
        while (!stack.isEmpty()) {
            reversed.append(stack.pop()).append(" ");
        }

        return reversed.toString().trim(); // Trim to remove trailing space
    }
}
