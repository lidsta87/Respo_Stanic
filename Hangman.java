import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;

// kommentar für pushhttps://github.com/lidsta87/Respo_Stanic.git

public class Hangman {
    public static void main(String[] args) {
        // Wortliste
        String[] wordList = {"java", "programmieren", "entwickler", "hangman", "code"};
        String word = wordList[(int) (Math.random() * wordList.length)]; // Zufälliges Wort auswählen
        char[] guessedWord = new char[word.length()];
        // Platzhalter
        Arrays.fill(guessedWord, '_');

        int attempts = 6; // Maximale Versuche
        HashSet<Character> guessedLetters = new HashSet<>(); // Geratene Buchstaben
        Scanner scanner = new Scanner(System.in);

        System.out.println("Willkommen zu Hangman!");
        System.out.println("Das Wort hat " + word.length() + " Buchstaben.");

        while (attempts > 0) {
            System.out.println("\nWort: " + String.valueOf(guessedWord));
            System.out.println("Versuche übrig: " + attempts);
            System.out.println("Geratene Buchstaben: " + guessedLetters);

            System.out.print("Rate einen Buchstaben: ");
            char guess = scanner.nextLine().toLowerCase().charAt(0);

            if (guessedLetters.contains(guess)) {
                System.out.println("Du hast diesen Buchstaben bereits geraten.");
                continue;
            }

            guessedLetters.add(guess);

            if (word.indexOf(guess) >= 0) {
                System.out.println("Richtig geraten!");
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        guessedWord[i] = guess;
                    }
                }

                if (String.valueOf(guessedWord).equals(word)) {
                    System.out.println("\nHerzlichen Glückwunsch! Du hast das Wort erraten: " + word);
                    break;
                }
            } else {
                System.out.println("Falsch geraten.");
                attempts--;
            }
        }

        if (attempts == 0) {
            System.out.println("\nDu hast verloren. Das Wort war: " + word);
        }

        scanner.close();
    }
}
