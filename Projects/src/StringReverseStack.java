import java.util.Scanner;
import java.util.Stack;

public class StringReverseStack {
    public static String reverseWords(String sentence) {
        Stack<String> stack = new Stack<>();
        StringBuilder reversedSentence = new StringBuilder();
        String[] words = sentence.split(" ");

        for (String word : words) {
            stack.push(word);
        }

        while (!stack.isEmpty()) {
            reversedSentence.append(stack.pop());
            reversedSentence.append(" ");
        }

        return reversedSentence.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        String reversedSentence = reverseWords(sentence);
        System.out.println("Reversed Sentence: " + reversedSentence);
        scanner.close();
    }
}
