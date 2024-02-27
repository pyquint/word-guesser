package src;
import java.util.Scanner;

public class WordGuesser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rows = { "ABCDEF", "GHIJKL", "MNOPQR", "STUVWX", "YZ" };
        String[] placeholderStrings = new String[6];

        System.out.println("Think of a word... For every letter in that word, enter which row contains that letter.");
        System.out.println("Example: Letters of the word 'hello' are found in rows '2, 1, 2, 2, 3', respectively.");

        String[] inputs;
        int[] rowIndices;
        int rowIndex;
        char currentChar;
        String letters;

        while (true) {
            System.out.println("\nEnter row numbers, separated by comma:");
            inputs = scanner.nextLine().split("\s?,\s?");
            rowIndices = new int[inputs.length];

            System.out.println();

            for (int i = 0; i < inputs.length; i++) {
                rowIndices[i] = Integer.parseInt(inputs[i]) - 1;
            }

            for (int i = 0; i < rows[0].length(); i++) {
                letters = "";
                System.out.print((i + 1) + "  ");

                for (int j = 0; j < rowIndices.length; j++) {
                    rowIndex = rowIndices[j];
                    if (rowIndex > rows[rowIndex].length())
                        continue;
                    currentChar = rows[rowIndex].charAt(i);
                    letters += currentChar;
                    System.out.print(currentChar + " ");
                }
                placeholderStrings[i] = letters;
                System.out.println();
            }
            rows = placeholderStrings.clone();
        }
    }
}
