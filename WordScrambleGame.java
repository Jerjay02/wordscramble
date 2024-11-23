import java.util.Scanner;
import java.util.Random;

public class WordScrambleGame {
  public static void main(String[] args) {
    String[] words = { "wesgel", "jerjay", "yanga", "yapo", "esteban" };
    Random random = new Random();

    String originalWord = words[random.nextInt(words.length)];
    String scrambledWord = scrambleWord(originalWord);

    System.out.println("Welcome to Word Scramble!");
    System.out.println("Unscramble this word: " + scrambledWord);

    Scanner scanner = new Scanner(System.in);
    boolean correct = false;

    for (int attempts = 3; attempts > 0; attempts--) {
      System.out.print("Your guess (" + attempts + " attempts left): ");
      String guess = scanner.nextLine();

      if (guess.equalsIgnoreCase(originalWord)) {
        System.out.println("Correct! The word was " + originalWord);
        correct = true;
        break;
      } else {
        System.out.println("Incorrect. Try again.");
      }
    }

    if (!correct) {
      System.out.println("Sorry! You've used all attempts. The correct word was " + originalWord);
    }

    scanner.close();
  }

  private static String scrambleWord(String word) {
    char[] letters = word.toCharArray();
    Random random = new Random();

    for (int i = 0; i < letters.length; i++) {
      int j = random.nextInt(letters.length);

      char temp = letters[i];
      letters[i] = letters[j];
      letters[j] = temp;
    }

    if (new String(letters).equals(word)) {
      return scrambleWord(word);
    }

    return new String(letters);
  }
}