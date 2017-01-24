/**
 *   File Name: SlotMachineGame.java<br>
 *
 *   Yakovenko, Galina<br>
 *   Created: Jan 23, 2017
 *
 */

package com.sqa.gy;

import java.text.*;

import com.sqa.gy.helpers.*;

/**
 * SlotMachineGame
 *
 * @author Yakovenko, Galina
 */
public class SlotMachineGame {

	public static DecimalFormat dfDollarsCents = new DecimalFormat("$#.##");

	public static int findMaxBettoRun(double userBalance, int userNumOfLines) {
		int times100userbalance = (int) (userBalance * 100);
		int maxBet = times100userbalance / (userNumOfLines * 25);
		if (maxBet < 4) {
			return maxBet;
		} else {
			return 4;
		}
	}

	public static int retrievesUserBetPerLine(double userBalance, int userNumOfLines, int maxBet) {
		int userBetPerLine = 0;
		while (userBetPerLine == 0) {
			String stringUserBetPerLine = AppBasics.requestUserInfo(
					"The max bet per line you can play is " + maxBet + " credits." + "\nWhat is your bet per line?");
			if (stringUserBetPerLine.equalsIgnoreCase("exit") || stringUserBetPerLine.equalsIgnoreCase("cash out")) {
				userBetPerLine = -1;
			} else {
				try {
					userBetPerLine = AppBasics.convertStringtoInt(stringUserBetPerLine, 1, (maxBet + 1));
				} catch (Exception e) {
				}
			}
		}
		return userBetPerLine;
	}

	public static int retrievesUserLines(double userBalance, int maxLines) {
		int userNumOfLines = 0;
		while (userNumOfLines == 0) {
			String stringUserNumOfLines = AppBasics.requestUserInfo("Your balance is "
					+ dfDollarsCents.format(userBalance) + " and the max number of lines you can play is " + maxLines
					+ "." + "\nHow many lines would you like to play?");
			if (stringUserNumOfLines.equalsIgnoreCase("exit") || stringUserNumOfLines.equalsIgnoreCase("cash out")) {
				userNumOfLines = -1;
			} else {
				try {
					userNumOfLines = AppBasics.convertStringtoInt(stringUserNumOfLines, 1, (maxLines + 1));
				} catch (Exception e) {
				}
			}
		}
		return userNumOfLines;
	}

	public boolean isUserPlaying;
	public int maxBet;
	public int maxLines;
	public String stringUserBet;
	public String stringUserLines;
	public double userBalance;

	public int userBet;

	public int userLines;

	SlotMachineGame() {
		this.isUserPlaying = true;
		this.userBalance = 0;
		this.maxLines = 0;
		this.stringUserLines = "";
		this.userLines = 0;
		this.maxBet = 0;
		this.stringUserBet = "";
		this.userBet = 0;
	}

	public int findMaxLinestoRun(double userBalance) {
		int times100userbalance = (int) (userBalance * 100);
		int maxLines = times100userbalance / 25;
		if (maxLines < 7) {
			return maxLines;
		} else {
			return 7;
		}
	}

	public int getMaxBet() {
		return this.maxBet;
	}

	public int getMaxLines() {
		return this.maxLines;
	}

	public String getStringUserBet() {
		return this.stringUserBet;
	}

	public String getStringUserLines() {
		return this.stringUserLines;
	}

	public double getUserBalance() {
		return this.userBalance;
	}

	public int getUserBet() {
		return this.userBet;
	}

	public int getUserLines() {
		return this.userLines;
	}

	public boolean isUserPlaying() {
		return this.isUserPlaying;
	}

	public void setMaxBet(int maxBet) {
		this.maxBet = maxBet;
	}

	public void setMaxLines(int maxLines) {
		this.maxLines = maxLines;
	}

	public void setStringUserBet(String stringUserBet) {
		this.stringUserBet = stringUserBet;
	}

	public void setStringUserLines(String stringUserLines) {
		this.stringUserLines = stringUserLines;
	}

	public void setUserBalance(double userBalance) {
		this.userBalance = userBalance;
	}

	public void setUserBet(int userBet) {
		this.userBet = userBet;
	}

	public void setUserLines(int userLines) {
		this.userLines = userLines;
	}

	public void setUserPlaying(boolean isUserPlaying) {
		this.isUserPlaying = isUserPlaying;
	}

}
