package bowlingtest;

import java.util.List;

import com.google.common.primitives.Chars;

//Class calculates the result of a bowling game based on following rules: http://www.rulesofbowling.com/How-to-Score-the-game-Bowling-using-a-Score-Card.php
//Input has to be typed in without spaces for example: 9/345/X6123XXX45 (X Strike, / Spare, - Miss)
public class BowlingCalculator {

	private BowlingConverter con = new BowlingConverter();
	private List<Character> input;
	private int result = 0;
	private int tries = 0;

	public int calculateResult(String entry) {
		input = Chars.asList(entry.toCharArray());

		for (int n = 0; n < input.size(); n++) {
			if ((tries == 20)) {
				break;
			} else {
				addToResult(n);
				checkForSpecialCharacter(n);
				tries = tries + 1;
			}
		}
		return result;
	}

	public boolean checkValidInput(int position) {
		char[] valid = { '/', '-', 'X', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		if (valid.equals(input.get(position))) {
			return true;
		} else {
			return false;
		}
	}

	private int checkForSpecialCharacter(int position) {
		if (input.get(position) == 'X') {
			addToResult(position + 1);
			addToResult(position + 2);
			tries = tries + 1;
		} else if (input.get(position) == '/') {
			addToResult(position + 1);
			removeFromResult(position - 1);
		}
		return tries;
	}

	private int removeFromResult(int position) {
		result = result - con.getChangedLetterToNumber(input.get(position));
		return result;
	}

	private int addToResult(int position) {
		result = result + con.getChangedLetterToNumber(input.get(position));
		return result;
	}
}
