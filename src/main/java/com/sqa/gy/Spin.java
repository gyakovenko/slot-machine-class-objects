/**
 *   File Name: Spin.java<br>
 *
 *   Yakovenko, Galina<br>
 *   Created: Jan 23, 2017
 *
 */

package com.sqa.gy;

import java.text.*;
import java.util.*;

/**
 * Spin
 *
 * @author Yakovenko, Galina
 */
public class Spin {
	public static DecimalFormat dfDollarsCents = new DecimalFormat("$#.##");
	public int[] multPerLine = new int[7];
	public String[][] spinRowsArray = new String[3][3];
	public int totalMultipliers;
	public double winnings;
	final String[] itemsToMatch = { "Bell", "Cherry", "Grape", "Lemon" };
	final String[] winningLinesPatterns = {
			"itemsToMatch[0]x3 - mult 10\n" + "itemsToMatch[1]x3 - mult 7\n" + "itemsToMatch[2]x3 - mult 5\n"
					+ "itemsToMatch[0]x2 any order - mult 3\n" + "itemsToMatch[1]x2 any order - mult 1\n" };

	// initializes spin with defaults

	Spin() {
		// set default values for multPerLine and spinRowsArray
		for (int i = 0; i < this.multPerLine.length; i++) {
			this.multPerLine[i] = 0;
		}
		for (int i = 0; i < this.spinRowsArray.length; i++) {
			for (int j = 0; j < this.spinRowsArray[i].length; j++) {
				this.spinRowsArray[i][j] = "";
			}
		}
	}

	public void displayTotalMult(int[] multPerLine, int totalMults) {
		if (totalMults == 0) {
			System.out.println("No winning lines this round.");
		} else {
			for (int i = 0; i < multPerLine.length; i++) {
				if (multPerLine[i] > 0) {
					System.out.println("Winner! Line " + (i + 1) + " Multiplier: x" + multPerLine[i]);
				}
			}
		}
	}

	public void displayWinnings(double winningsInRound) {
		System.out.println("Winnings this round: " + dfDollarsCents.format(winningsInRound));
	}

	public int[] getMultPerLine() {
		return this.multPerLine;
	}

	public String[][] getSpinRowsArray() {
		return this.spinRowsArray;
	}

	public int getTotalMultipliers() {
		return this.totalMultipliers;
	}

	public double getWinnings() {
		return this.winnings;
	}

	public int[] returnArrayOfMultPerLine(int linesUserIsPlaying) {
		for (int i = 0; i < linesUserIsPlaying; i++) {
			switch (i) {
			case 0:
				if (this.spinRowsArray[1][0].equalsIgnoreCase(this.itemsToMatch[0])
						&& this.spinRowsArray[1][1].equalsIgnoreCase(this.itemsToMatch[0])
						&& this.spinRowsArray[1][2].equalsIgnoreCase(this.itemsToMatch[0])) {
					this.multPerLine[0] = 10;
				} else if (this.spinRowsArray[1][0].equalsIgnoreCase(this.itemsToMatch[1])
						&& this.spinRowsArray[1][1].equalsIgnoreCase(this.itemsToMatch[1])
						&& this.spinRowsArray[1][2].equalsIgnoreCase(this.itemsToMatch[1])) {
					this.multPerLine[0] = 6;
				} else if (this.spinRowsArray[1][0].equalsIgnoreCase(this.itemsToMatch[2])
						&& this.spinRowsArray[1][1].equalsIgnoreCase(this.itemsToMatch[2])
						&& this.spinRowsArray[1][2].equalsIgnoreCase(this.itemsToMatch[2])) {
					this.multPerLine[0] = 4;
				} else if ((this.spinRowsArray[1][0].equalsIgnoreCase(this.itemsToMatch[0])
						&& this.spinRowsArray[1][1].equalsIgnoreCase(this.itemsToMatch[0]))
						|| (this.spinRowsArray[1][0].equalsIgnoreCase(this.itemsToMatch[0])
								&& this.spinRowsArray[1][2].equalsIgnoreCase(this.itemsToMatch[0]))
						|| (this.spinRowsArray[1][1].equalsIgnoreCase(this.itemsToMatch[0])
								&& this.spinRowsArray[1][2].equalsIgnoreCase(this.itemsToMatch[0]))) {
					this.multPerLine[0] = 2;
				} else if ((this.spinRowsArray[1][0].equalsIgnoreCase(this.itemsToMatch[1])
						&& this.spinRowsArray[1][1].equalsIgnoreCase(this.itemsToMatch[1]))
						|| (this.spinRowsArray[1][0].equalsIgnoreCase(this.itemsToMatch[1])
								&& this.spinRowsArray[1][2].equalsIgnoreCase(this.itemsToMatch[1]))
						|| (this.spinRowsArray[1][1].equalsIgnoreCase(this.itemsToMatch[1])
								&& this.spinRowsArray[1][2].equalsIgnoreCase(this.itemsToMatch[1]))) {
					this.multPerLine[0] = 3;
				} else {
					this.multPerLine[0] = 0;
				}
				break;
			case 1:
				if (this.spinRowsArray[0][0].equalsIgnoreCase(this.itemsToMatch[0])
						&& this.spinRowsArray[0][1].equalsIgnoreCase(this.itemsToMatch[0])
						&& this.spinRowsArray[0][2].equalsIgnoreCase(this.itemsToMatch[0])) {
					this.multPerLine[1] = 10;
				} else if (this.spinRowsArray[0][0].equalsIgnoreCase(this.itemsToMatch[1])
						&& this.spinRowsArray[0][1].equalsIgnoreCase(this.itemsToMatch[1])
						&& this.spinRowsArray[0][2].equalsIgnoreCase(this.itemsToMatch[1])) {
					this.multPerLine[1] = 7;
				} else if (this.spinRowsArray[0][0].equalsIgnoreCase(this.itemsToMatch[2])
						&& this.spinRowsArray[0][1].equalsIgnoreCase(this.itemsToMatch[2])
						&& this.spinRowsArray[0][2].equalsIgnoreCase(this.itemsToMatch[2])) {
					this.multPerLine[1] = 5;
				} else if ((this.spinRowsArray[0][0].equalsIgnoreCase(this.itemsToMatch[0])
						&& this.spinRowsArray[0][1].equalsIgnoreCase(this.itemsToMatch[0]))
						|| (this.spinRowsArray[0][0].equalsIgnoreCase(this.itemsToMatch[0])
								&& this.spinRowsArray[0][2].equalsIgnoreCase(this.itemsToMatch[0]))
						|| (this.spinRowsArray[0][1].equalsIgnoreCase(this.itemsToMatch[0])
								&& this.spinRowsArray[0][2].equalsIgnoreCase(this.itemsToMatch[0]))) {
					this.multPerLine[1] = 3;
				} else if ((this.spinRowsArray[0][0].equalsIgnoreCase(this.itemsToMatch[1])
						&& this.spinRowsArray[0][1].equalsIgnoreCase(this.itemsToMatch[1]))
						|| (this.spinRowsArray[0][0].equalsIgnoreCase(this.itemsToMatch[1])
								&& this.spinRowsArray[0][2].equalsIgnoreCase(this.itemsToMatch[1]))
						|| (this.spinRowsArray[0][1].equalsIgnoreCase(this.itemsToMatch[1])
								&& this.spinRowsArray[0][2].equalsIgnoreCase(this.itemsToMatch[1]))) {
					this.multPerLine[1] = 1;
				} else {
					this.multPerLine[1] = 0;
				}
				break;
			case 2:
				if (this.spinRowsArray[2][0].equalsIgnoreCase(this.itemsToMatch[0])
						&& this.spinRowsArray[2][1].equalsIgnoreCase(this.itemsToMatch[0])
						&& this.spinRowsArray[2][2].equalsIgnoreCase(this.itemsToMatch[0])) {
					this.multPerLine[2] = 10;
				} else if (this.spinRowsArray[2][0].equalsIgnoreCase(this.itemsToMatch[1])
						&& this.spinRowsArray[2][1].equalsIgnoreCase(this.itemsToMatch[1])
						&& this.spinRowsArray[2][2].equalsIgnoreCase(this.itemsToMatch[1])) {
					this.multPerLine[2] = 7;
				} else if (this.spinRowsArray[2][0].equalsIgnoreCase(this.itemsToMatch[2])
						&& this.spinRowsArray[2][1].equalsIgnoreCase(this.itemsToMatch[2])
						&& this.spinRowsArray[2][2].equalsIgnoreCase(this.itemsToMatch[2])) {
					this.multPerLine[2] = 5;
				} else if ((this.spinRowsArray[2][0].equalsIgnoreCase(this.itemsToMatch[0])
						&& this.spinRowsArray[2][1].equalsIgnoreCase(this.itemsToMatch[0]))
						|| (this.spinRowsArray[2][0].equalsIgnoreCase(this.itemsToMatch[0])
								&& this.spinRowsArray[2][2].equalsIgnoreCase(this.itemsToMatch[0]))
						|| (this.spinRowsArray[2][1].equalsIgnoreCase(this.itemsToMatch[0])
								&& this.spinRowsArray[2][2].equalsIgnoreCase(this.itemsToMatch[0]))) {
					this.multPerLine[2] = 3;
				} else if ((this.spinRowsArray[2][0].equalsIgnoreCase(this.itemsToMatch[1])
						&& this.spinRowsArray[2][1].equalsIgnoreCase(this.itemsToMatch[1]))
						|| (this.spinRowsArray[2][0].equalsIgnoreCase(this.itemsToMatch[1])
								&& this.spinRowsArray[2][2].equalsIgnoreCase(this.itemsToMatch[1]))
						|| (this.spinRowsArray[2][1].equalsIgnoreCase(this.itemsToMatch[1])
								&& this.spinRowsArray[2][2].equalsIgnoreCase(this.itemsToMatch[1]))) {
					this.multPerLine[2] = 1;
				} else {
					this.multPerLine[2] = 0;
				}
				break;
			case 3:
				if (this.spinRowsArray[0][0].equalsIgnoreCase(this.itemsToMatch[0])
						&& this.spinRowsArray[1][1].equalsIgnoreCase(this.itemsToMatch[0])
						&& this.spinRowsArray[2][2].equalsIgnoreCase(this.itemsToMatch[0])) {
					this.multPerLine[3] = 10;
				} else if (this.spinRowsArray[0][0].equalsIgnoreCase(this.itemsToMatch[1])
						&& this.spinRowsArray[1][1].equalsIgnoreCase(this.itemsToMatch[1])
						&& this.spinRowsArray[2][2].equalsIgnoreCase(this.itemsToMatch[1])) {
					this.multPerLine[3] = 7;
				} else if (this.spinRowsArray[0][0].equalsIgnoreCase(this.itemsToMatch[2])
						&& this.spinRowsArray[1][1].equalsIgnoreCase(this.itemsToMatch[2])
						&& this.spinRowsArray[2][2].equalsIgnoreCase(this.itemsToMatch[2])) {
					this.multPerLine[3] = 5;
				} else if ((this.spinRowsArray[0][0].equalsIgnoreCase(this.itemsToMatch[0])
						&& this.spinRowsArray[1][1].equalsIgnoreCase(this.itemsToMatch[0]))
						|| (this.spinRowsArray[0][0].equalsIgnoreCase(this.itemsToMatch[0])
								&& this.spinRowsArray[2][2].equalsIgnoreCase(this.itemsToMatch[0]))
						|| (this.spinRowsArray[1][1].equalsIgnoreCase(this.itemsToMatch[0])
								&& this.spinRowsArray[2][2].equalsIgnoreCase(this.itemsToMatch[0]))) {
					this.multPerLine[3] = 3;
				} else if ((this.spinRowsArray[0][0].equalsIgnoreCase(this.itemsToMatch[1])
						&& this.spinRowsArray[1][1].equalsIgnoreCase(this.itemsToMatch[1]))
						|| (this.spinRowsArray[0][0].equalsIgnoreCase(this.itemsToMatch[1])
								&& this.spinRowsArray[2][2].equalsIgnoreCase(this.itemsToMatch[1]))
						|| (this.spinRowsArray[1][1].equalsIgnoreCase(this.itemsToMatch[1])
								&& this.spinRowsArray[2][2].equalsIgnoreCase(this.itemsToMatch[1]))) {
					this.multPerLine[3] = 1;
				} else {
					this.multPerLine[3] = 0;
				}
				break;
			case 4:
				if (this.spinRowsArray[2][0].equalsIgnoreCase(this.itemsToMatch[0])
						&& this.spinRowsArray[1][1].equalsIgnoreCase(this.itemsToMatch[0])
						&& this.spinRowsArray[0][2].equalsIgnoreCase(this.itemsToMatch[0])) {
					this.multPerLine[4] = 10;
				} else if (this.spinRowsArray[2][0].equalsIgnoreCase(this.itemsToMatch[1])
						&& this.spinRowsArray[1][1].equalsIgnoreCase(this.itemsToMatch[1])
						&& this.spinRowsArray[0][2].equalsIgnoreCase(this.itemsToMatch[1])) {
					this.multPerLine[4] = 7;
				} else if (this.spinRowsArray[2][0].equalsIgnoreCase(this.itemsToMatch[2])
						&& this.spinRowsArray[1][1].equalsIgnoreCase(this.itemsToMatch[2])
						&& this.spinRowsArray[0][2].equalsIgnoreCase(this.itemsToMatch[2])) {
					this.multPerLine[4] = 5;
				} else if ((this.spinRowsArray[2][0].equalsIgnoreCase(this.itemsToMatch[0])
						&& this.spinRowsArray[1][1].equalsIgnoreCase(this.itemsToMatch[0]))
						|| (this.spinRowsArray[2][0].equalsIgnoreCase(this.itemsToMatch[0])
								&& this.spinRowsArray[0][2].equalsIgnoreCase(this.itemsToMatch[0]))
						|| (this.spinRowsArray[1][1].equalsIgnoreCase(this.itemsToMatch[0])
								&& this.spinRowsArray[0][2].equalsIgnoreCase(this.itemsToMatch[0]))) {
					this.multPerLine[4] = 3;
				} else if ((this.spinRowsArray[2][0].equalsIgnoreCase(this.itemsToMatch[1])
						&& this.spinRowsArray[1][1].equalsIgnoreCase(this.itemsToMatch[1]))
						|| (this.spinRowsArray[2][0].equalsIgnoreCase(this.itemsToMatch[1])
								&& this.spinRowsArray[0][2].equalsIgnoreCase(this.itemsToMatch[1]))
						|| (this.spinRowsArray[1][1].equalsIgnoreCase(this.itemsToMatch[1])
								&& this.spinRowsArray[0][2].equalsIgnoreCase(this.itemsToMatch[1]))) {
					this.multPerLine[4] = 1;
				} else {
					this.multPerLine[4] = 0;
				}
				break;
			case 5:
				if (this.spinRowsArray[1][0].equalsIgnoreCase(this.itemsToMatch[0])
						&& this.spinRowsArray[0][1].equalsIgnoreCase(this.itemsToMatch[0])
						&& this.spinRowsArray[1][2].equalsIgnoreCase(this.itemsToMatch[0])) {
					this.multPerLine[5] = 10;
				} else if (this.spinRowsArray[1][0].equalsIgnoreCase(this.itemsToMatch[1])
						&& this.spinRowsArray[0][1].equalsIgnoreCase(this.itemsToMatch[1])
						&& this.spinRowsArray[1][2].equalsIgnoreCase(this.itemsToMatch[1])) {
					this.multPerLine[5] = 7;
				} else if (this.spinRowsArray[1][0].equalsIgnoreCase(this.itemsToMatch[2])
						&& this.spinRowsArray[0][1].equalsIgnoreCase(this.itemsToMatch[2])
						&& this.spinRowsArray[1][2].equalsIgnoreCase(this.itemsToMatch[2])) {
					this.multPerLine[5] = 5;
				} else if ((this.spinRowsArray[1][0].equalsIgnoreCase(this.itemsToMatch[0])
						&& this.spinRowsArray[0][1].equalsIgnoreCase(this.itemsToMatch[0]))
						|| (this.spinRowsArray[1][0].equalsIgnoreCase(this.itemsToMatch[0])
								&& this.spinRowsArray[1][2].equalsIgnoreCase(this.itemsToMatch[0]))
						|| (this.spinRowsArray[0][1].equalsIgnoreCase(this.itemsToMatch[0])
								&& this.spinRowsArray[1][2].equalsIgnoreCase(this.itemsToMatch[0]))) {
					this.multPerLine[5] = 3;
				} else if ((this.spinRowsArray[1][0].equalsIgnoreCase(this.itemsToMatch[1])
						&& this.spinRowsArray[0][1].equalsIgnoreCase(this.itemsToMatch[1]))
						|| (this.spinRowsArray[1][0].equalsIgnoreCase(this.itemsToMatch[1])
								&& this.spinRowsArray[1][2].equalsIgnoreCase(this.itemsToMatch[1]))
						|| (this.spinRowsArray[0][1].equalsIgnoreCase(this.itemsToMatch[1])
								&& this.spinRowsArray[1][2].equalsIgnoreCase(this.itemsToMatch[1]))) {
					this.multPerLine[5] = 1;
				} else {
					this.multPerLine[5] = 0;
				}
				break;
			case 6:
				if (this.spinRowsArray[1][0].equalsIgnoreCase(this.itemsToMatch[0])
						&& this.spinRowsArray[2][1].equalsIgnoreCase(this.itemsToMatch[0])
						&& this.spinRowsArray[1][2].equalsIgnoreCase(this.itemsToMatch[0])) {
					this.multPerLine[6] = 10;
				} else if (this.spinRowsArray[1][0].equalsIgnoreCase(this.itemsToMatch[1])
						&& this.spinRowsArray[2][1].equalsIgnoreCase(this.itemsToMatch[1])
						&& this.spinRowsArray[1][2].equalsIgnoreCase(this.itemsToMatch[1])) {
					this.multPerLine[6] = 7;
				} else if (this.spinRowsArray[1][0].equalsIgnoreCase(this.itemsToMatch[2])
						&& this.spinRowsArray[2][1].equalsIgnoreCase(this.itemsToMatch[2])
						&& this.spinRowsArray[1][2].equalsIgnoreCase(this.itemsToMatch[2])) {
					this.multPerLine[6] = 5;
				} else if ((this.spinRowsArray[1][0].equalsIgnoreCase(this.itemsToMatch[0])
						&& this.spinRowsArray[2][1].equalsIgnoreCase(this.itemsToMatch[0]))
						|| (this.spinRowsArray[1][0].equalsIgnoreCase(this.itemsToMatch[0])
								&& this.spinRowsArray[1][2].equalsIgnoreCase(this.itemsToMatch[0]))
						|| (this.spinRowsArray[2][1].equalsIgnoreCase(this.itemsToMatch[0])
								&& this.spinRowsArray[1][2].equalsIgnoreCase(this.itemsToMatch[0]))) {
					this.multPerLine[6] = 3;
				} else if ((this.spinRowsArray[1][0].equalsIgnoreCase(this.itemsToMatch[1])
						&& this.spinRowsArray[2][1].equalsIgnoreCase(this.itemsToMatch[1]))
						|| (this.spinRowsArray[1][0].equalsIgnoreCase(this.itemsToMatch[1])
								&& this.spinRowsArray[1][2].equalsIgnoreCase(this.itemsToMatch[1]))
						|| (this.spinRowsArray[2][1].equalsIgnoreCase(this.itemsToMatch[1])
								&& this.spinRowsArray[1][2].equalsIgnoreCase(this.itemsToMatch[1]))) {
					this.multPerLine[6] = 1;
				} else {
					this.multPerLine[6] = 0;
				}
				break;
			default:
				break;
			}
		}
		return this.multPerLine;
	}

	public int returnTotalMult(int[] multPerLine) {
		int totalMults = 0;
		for (int i = 0; i < multPerLine.length; i++) {
			totalMults = totalMults + multPerLine[i];
		}
		return totalMults;
	}

	public double returnWinnings(int totalMults, int betPerLine) {
		return (totalMults * betPerLine * .25);
	}

	public void setMultPerLine(int[] multPerLine) {
		this.multPerLine = multPerLine;
	}

	public void setSpinRowsArray(String[][] spinRowsArray) {
		this.spinRowsArray = spinRowsArray;
	}

	public void setTotalMultipliers(int totalMultipliers) {
		this.totalMultipliers = totalMultipliers;
	}

	public void setWinnings(double winnings) {
		this.winnings = winnings;
	}

	@Override
	public String toString() {
		return "Spin:" + "\n\tRow 1: " + this.spinRowsArray[0][0] + " \t" + this.spinRowsArray[0][1] + " \t"
				+ this.spinRowsArray[0][2] + "\n\tRow 2: " + this.spinRowsArray[1][0] + " \t" + this.spinRowsArray[1][1]
				+ " \t" + this.spinRowsArray[1][2] + "\n\tRow 3: " + this.spinRowsArray[2][0] + " \t"
				+ this.spinRowsArray[2][1] + " \t" + this.spinRowsArray[2][2] + "\n";
	}

	public void userSpins() {
		Random randomInt = new Random();
		for (int i = 0; i < this.spinRowsArray.length; i++) {
			for (int j = 0; j < this.spinRowsArray[i].length; j++) {
				this.spinRowsArray[i][j] = this.itemsToMatch[randomInt.nextInt(4)];
			}
		}
		System.out.println(this.toString());
	}

}
