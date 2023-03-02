package jd2_Homework_03;

import java.util.Arrays;
import java.util.Scanner;

public class NumberPredictionGame {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("How many users will play: ");
		int userCount = scanner.nextInt();
		
		System.out.println();
		printLeaderBoard(getPrediction(userCount));
	}

	public static int generateRandomNumber() {
		return (int) (Math.random() * 100) + 1;
	}

	public static int[] getPrediction(int size) {
		int usersOnGame = size, predictedNumber, random;

		// All users play at least once.
		int[] users = new int[size];
		Arrays.fill(users, 1);

		// If any user find the correct answer, the flag of the user will turn to "true"
		boolean[] flags = new boolean[size];
		Arrays.fill(flags, false);

		Scanner scanner = new Scanner(System.in);
		random = generateRandomNumber();

		// It continues until the last user find the correct number
		while (usersOnGame > 0) {
			for (int i = 0; i < size; i++) {

				if (!flags[i]) {
					System.out.print((i + 1) + ". user, please enter your prediction: ");
					predictedNumber = scanner.nextInt();

					if (predictedNumber == random) {
						flags[i] = true;
						usersOnGame--;
						continue;
					} else if (predictedNumber > random) {
						System.out.println("Too high, try again");
					} else {
						System.out.println("Too low, try again");
					}
					users[i]++;
				}
			}
		}

		System.out.println("\n********** GAME OVER **********");
		System.out.println("The right number is " + random);

		scanner.close();
		return users;
	}

	public static void printLeaderBoard(int[] users) {

		System.out.println("\n\n********** LEADER BOARD **********\n");

		for (int i = 0; i < users.length; i++) {
			System.out.println((i + 1) + ". user found it on --> " + users[i] + ". try");
		}
	}
}
