/**
 *   File Name: MiscMethodsForSlotMachine.java<br>
 *
 *   Yakovenko, Galina<br>
 *   Created: Jan 23, 2017
 *
 */

package com.sqa.gy;

import java.text.*;
import java.util.*;

import com.sqa.gy.helpers.*;

/**
 * MiscMethodsForSlotMachine
 *
 * @author Yakovenko, Galina
 */
public class MiscMethodsForSlotMachine {

	public static DecimalFormat dfDollarsCents = new DecimalFormat("$#.##");

	public static Scanner scanner = new Scanner(System.in);

	public static double acceptsUserDeposit(double userBalance) {
		userBalance = userBalance + AppBasics
				.requestDoubleFromUser("Please enter the dollar ammount you would like to insert: $", 0, 100);
		return userBalance;
	}

	public static boolean askDepositMoreOrDone(double userBalance) {
		String response = AppBasics.requestUserInfo(
				"Your balance is: $" + dfDollarsCents.format(userBalance) + "\nYou do not have enough to play again."
						+ "\nPlease enter \'deposit\' to make a deposit or \'enter\' to exit the app.");
		if (response.equalsIgnoreCase("deposit")) {
			return true;
		} else {
			return false;
		}
	}

	public static void displayBasicInfo() {
		try {
			String moreDeetsOrCont = AppBasics.requestUserInfo("\nOn each spin, you can bet on up to 7 lines."
					+ "\nEach credit is 25¢ and you can bet up to 4 credits per line."
					+ "\nWhen you are ready to end the game, simply enter \'cash out\' or \'exit\' to cash out." + "\n"
					+ "\nEnter \'more\' for more info or press \'return\' to continue.");
			if (moreDeetsOrCont.equalsIgnoreCase("more")) {
				displayMoreDetails();
			}
		} catch (Exception e) {
		}

	}

	public static void displayMoreDetails() {
		System.out.println("\nThe format of the Items after spin is displayed here:"
				+ "\n\nRow 1	  [Item 1]--[Item 2]--[Item 3] " + "\n" + "                \\   /     \\   /" + "\n"
				+ "                  X         X" + "\n" + "               _/   \\_   _/   \\_" + "\n"
				+ "Row 2	  [Item 1]--[Item 2]--[Item 3]" + "\n" + "               \\_   _/     \\_   _/" + "\n"
				+ "                  X           X" + "\n" + "               _/   \\_     _/   \\_" + "\n"
				+ "Row 3	  [Item 1]--[Item 2]--[Item 3]" + "\n\n" + "Win lines are:" + "\n	-Across Row 2"
				+ "\n	-Across Row 1" + "\n	-Across Row 3" + "\n	-Diagonal Down from Row 1, Item 1"
				+ "\n	-Diagonal Up from Row 3, Item 1" + "\n	-Row 2, Item 1 -- Row 1, Item 2 -- Row 2, Item 3"
				+ "\n	-Row 2, Item 1 -- Row 3, Item 2 -- Row 2, Item 3"
				+ "\n\nWinning Combinations with Winnings Multipliers:" + "\n	-BELL, BELL, BELL 		x10"
				+ "\n	-CHERRY, CHERRY, CHERRY 	x7" + "\n	-GRAPE, GRAPE, GRAPE 		x5"
				+ "\n	-BELL, BELL, -ANY-	 	x3" + "\n	-BELL, -ANY-, BELL 		x3"
				+ "\n	--ANY-, BELL, BELL 		x3" + "\n	-CHERRY, CHERRY, -ANY-	 	x1"
				+ "\n	-CHERRY, -ANY-, CHERRY 		x1" + "\n	--ANY-, CHERRY, CHERRY 		x1\n");
		AppBasics.requestUserInfo("Press \'return\' to begin!");
	}

	public static void printCashingOutMessage(double userBalance) {
		System.out.println(
				"Cashing out: " + dfDollarsCents.format(userBalance) + "\n" + "Thanks for playing and goodbye now!");
		System.exit(0);
	}

	public static int retrievesUserBetPerLine(double userBalance, int userNumOfLines, int maxBet) {
		int userBetPerLine = 0;
		while (userBetPerLine == 0) {
			String stringUserBetPerLine = AppBasics.requestUserInfo("Your balance is $"
					+ dfDollarsCents.format(userBalance) + " and the max bet per line you can play is " + maxBet
					+ " credits." + "\nWhat is your bet per line?");
			if (stringUserBetPerLine.equalsIgnoreCase("exit") || stringUserBetPerLine.equalsIgnoreCase("cash out")) {
				userBetPerLine = -1;
			} else {
				try {
					userBetPerLine = AppBasics.convertStringtoInt(stringUserBetPerLine, 1, maxBet);
				} catch (Exception e) {
				}
			}
		}
		return userBetPerLine;
	}

	public static void spinMessage() {
		System.out.println("Press \'return\' to spin!");
		scanner.nextLine();
	}

}
