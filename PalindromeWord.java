package jd2_Homework_03;

import java.util.Scanner;

public class PalindromeWord {

	public static void main(String[] args) {
		String word, reverseWord;
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the word: ");
		word = scanner.next();
		scanner.close();

		reverseWord = reverseWord(word);
		System.out.println("\nReverse of the \"" + word + "\" is " + reverseWord + "\n");

		if (ispalindrome(word, reverseWord))
			System.out.println("\"" + word + "\" is a palindrome word.");

		else
			System.out.println("\"" + word + "\" is not a palindrome word.");

	}

	public static boolean ispalindrome(String word, String reverseWord) {
		return (word.equals(reverseWord));

	}

	public static String reverseWord(String word) {
		String reverseWord = "";

		for (int i = word.length() - 1; i >= 0; i--) {
			reverseWord += word.charAt(i);
		}

		return reverseWord;
	}

}
