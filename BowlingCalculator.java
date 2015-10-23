package bowlingtest;

import java.util.List;

import com.google.common.primitives.Chars;

public class BowlingCalculator {
	BowlingConverter con = new BowlingConverter();
	List<Character> input;
	int result = 0;
	int tries = 0;

	public int calculateResult(String entry) {
		input = Chars.asList(entry.toCharArray());

		for (int n = 0; n < input.size(); n++) {
			if ((tries == 20)) {
				break;
			} else {
				addToResult(n);
				if (input.get(n) == 'X') {
					addToResult(n+1);
					addToResult(n+2);
					tries = tries + 1;
				} else if (input.get(n) == '/') {
					addToResult(n+1);
					removeFromResult(n-1);
				}
				tries = tries + 1;
			}
		}
		return result;
	}

	public int removeFromResult(int position) {
		result = result - con.getChangedLetterToNumber(input.get(position));
		return result; 
	}

	public int addToResult(int position) {
		result = result + con.getChangedLetterToNumber(input.get(position));
		return result;
	}
}
