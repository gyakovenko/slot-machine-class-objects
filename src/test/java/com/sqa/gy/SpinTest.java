/**
 *   File Name: SpinTest.java<br>
 *
 *   Yakovenko, Galina<br>
 *   Created: Jan 23, 2017
 *
 */

package com.sqa.gy;

import org.junit.*;

/**
 * SpinTest
 *
 * @author Yakovenko, Galina
 */
public class SpinTest {

	@Test
	public void test() {
		Spin spin1 = new Spin();
		spin1.userSpins();
		int[] multipliers = spin1.returnArrayOfMultPerLine(5);
		int totalMult = spin1.returnTotalMult(multipliers);
		spin1.displayTotalMult(multipliers, totalMult);
		double winnings = spin1.returnWinnings(totalMult, 1);
		spin1.displayWinnings(winnings);
	}

}
