
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
//Integer.parseInt(input.get(n).toString());
				switch (input.get(n)) {
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
					addRoll(n);
					tries = tries + 1;
					break;

				case 'X':

					result = result + con.getChangedLetterToNumber(input.get(n))
							+ con.getChangedLetterToNumber(input.get(n + 1))
							+ con.getChangedLetterToNumber(input.get(n + 2));
					tries = tries + 2;

					break;

				case '/':
					result = result + con.getChangedLetterToNumber(input.get(n))
							+ con.getChangedLetterToNumber(input.get(n + 1))
							- con.getChangedLetterToNumber(input.get(n - 1));
					
					tries = tries + 1;
					break;

				default:
					tries = tries + 1;
					break;
				}
			}
		}
		return result;
	}

	private void addRoll(int n) {
		result = result + con.getChangedLetterToNumber(input.get(n));
	}
}
