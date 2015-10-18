package bowlingtest;

public class BowlingConverter {

	public int getChangedLetterToNumber(Character letter) {
		int number = 0;

		switch (letter) {
		
		case 'X':
			number = 10;
			break;
		
		case '/':
			number = 10;
			break;
		
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
			number = Character.getNumericValue(letter);
			break;

		default:
			break;
		}
		
		return number;

	}
}
