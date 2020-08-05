package igtampe.wordstructor;

import java.util.ArrayList;
import java.util.Random;

/**
 * Holds a letter and the valid next letters. 
 * @author igtampe
 */
public class Letter {
	
	public static enum LetterType {CONSONANT,VOWEL}
	
	private LetterType Type;
	private char MyChar;
	private ArrayList<Letter> ValidNextLetters;
	
	/**
	 * Creates a nice and new letter.
	 * @param Char
	 */
	public Letter(char Char, LetterType Type) {
		//Time to ***exist***
		MyChar=Char;
		this.Type=Type;
		ValidNextLetters = new ArrayList<Letter>();		
	}
	
	/**
	 * Add a letter to the list of valid next letters
	 * @param letter A letter that can go after this letter in a word.
	 */
	public void AddValidNextLetter(Letter letter) {ValidNextLetters.add(letter);}
	
	/**
	 * Adds the letters to the list of valid next letters
	 * @param consonants a collection of letters that are valid next letters in a word.
	 */
	public void AddValidNextLetters(Letter[] letters) {for (Letter letter : letters) {AddValidNextLetter(letter);}}
	
	/**
	 * Gets a possible next letter
	 * @return A letter that can go after this letter in a word.
	 */
	public Letter GetRandomNextLetter() {return ValidNextLetters.get(new Random().nextInt(ValidNextLetters.size()));}
	
	/**
	 * Gets a possible next letter that's of the specified letter type
	 * @param Type
	 * @return
	 */
	public Letter GetRandomNextLetter(LetterType Type) {
		Letter NextLetter;
		do {NextLetter = GetRandomNextLetter();} while(NextLetter.Type!=Type);
		return NextLetter;
	}
	
	public char GetChar() {return MyChar;}
	public LetterType GetType() {return Type;}
	
}
