package bowlingtest;

public class BowlingConverter {

	public int getChangedLetterToNumber(Character letter) {
		int number = 0;
		if (Character.isDigit(letter)) {
			number = Character.getNumericValue(letter);
		} else if (letter == '/' || letter == 'X') {
			number = 10;
		}
		return number;
	}
}
