/**
 *   File Name: RunSlotMachineGame.java<br>
 *
 *   Yakovenko, Galina<br>
 *   Created: Jan 23, 2017
 *
 */

package com.sqa.gy;

import com.sqa.gy.helpers.*;

/**
 * RunSlotMachineGame
 *
 * @author Yakovenko, Galina
 *
 */
public class RunSlotMachineGame {

	public static void main(String[] args) {
		// Game Start Up
		AppBasics.greetNoUserName("Slot Machine");
		MiscMethodsForSlotMachine.displayBasicInfo();
		// initiate game instance to use for balance and for inside loop
		SlotMachineGame game = new SlotMachineGame();
		// initiate spin instance to use inside the loop
		Spin spin = new Spin();
		System.out.println("\n");
		game.setUserBalance(MiscMethodsForSlotMachine.acceptsUserDeposit(0));
		System.out.println("\n");

		// Betting Phase
		while (game.isUserPlaying) {
			game.setMaxLines(game.findMaxLinestoRun(game.getUserBalance()));
			game.setUserLines(game.retrievesUserLines(game.getUserBalance(), game.getMaxLines()));
			if (game.getUserLines() == -1) {
				game.setUserPlaying(false);
			} else {
				game.setMaxBet(game.findMaxBettoRun(game.getUserBalance(), game.getUserLines()));
				game.setUserBet(
						game.retrievesUserBetPerLine(game.getUserBalance(), game.getUserLines(), game.getMaxBet()));
				if (game.getUserBet() == -1) {
					game.setUserPlaying(false);
				} else {
					MiscMethodsForSlotMachine.spinMessage();
					spin.userSpins();
					double balanceWithdrawl = (game.getUserLines() * game.getUserBet() * .25);
					game.setUserBalance((game.getUserBalance() - balanceWithdrawl));
					spin.setMultPerLine(spin.returnArrayOfMultPerLine(game.getUserLines()));
					spin.setTotalMultipliers(spin.returnTotalMult(spin.getMultPerLine()));
					spin.displayTotalMult(spin.getMultPerLine(), spin.getTotalMultipliers());
					spin.setWinnings(spin.returnWinnings(spin.getTotalMultipliers(), game.getUserBet()));
					spin.displayWinnings(spin.getWinnings());
					System.out.println("\n");
					game.setUserBalance(game.getUserBalance() + spin.getWinnings());
					if (game.getUserBalance() < .25) {
						if (!MiscMethodsForSlotMachine.askDepositMoreOrDone(game.getUserBalance())) {
							game.setUserPlaying(false);
						} else {
							MiscMethodsForSlotMachine.acceptsUserDeposit(game.getUserBalance());
							System.out.println("\n");
						}
					}
				}
			}
		}
		// Exiting Game
		System.out.println("\n");
		MiscMethodsForSlotMachine.printCashingOutMessage(game.getUserBalance());
	}
}
