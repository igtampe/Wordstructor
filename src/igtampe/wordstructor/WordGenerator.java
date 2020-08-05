package igtampe.wordstructor;
import java.util.Random;

import igtampe.wordstructor.Letter.LetterType;

/**
 * Generator that uses letters to create readable giberish
 * @author igtampe
 */
public class WordGenerator {
	
	private int LetterTypeCount;
	private int MaxLength;
	private int MinLength;
	

	/***
	 * Demo of the generator
	 * @param args
	 */
	public static void main(String[] args) {
		
		//------------[Configuration]------------
		int MaxLength=7;
		int MinLength=3;
		int WordCount = 10;
		int Superword = 3000;
		Letter FirstLetter = Letters.P;
		//---------------------------------------
		
		WordGenerator MG = new WordGenerator(MaxLength,MinLength);
		
		
		System.out.println("Here are " + WordCount + " word(s): \n");
		for (int i = 0; i < WordCount; i++) {System.out.println((i+1) + ") " + MG.Generate());}
		
		
		System.out.println("\n\nHere are " + WordCount + " word(s) that starts with " + FirstLetter.GetChar() + " : \n");
		for (int i = 0; i < WordCount; i++) {System.out.println((i+1) + ") " + FirstLetter.GetChar() + MG.Generate(new Random().nextInt(MaxLength+1)+MinLength,FirstLetter));}
		
		System.out.println("\nHere is a super word, "+ Superword +" characters long: \n");
		System.out.println(MG.Generate(Superword));

	}
	
	public WordGenerator(int MaxLength, int MinLength) {
		this.MaxLength=MaxLength;
		this.MinLength=MinLength;
		if(!Letters.isInitialized()) {Letters.Initialize();}
	}
	
	
	/**
	 * Generates word of random length between the created bounds.
	 * @return
	 */
	public String Generate() {return Generate(new Random().nextInt(MaxLength+1)+MinLength);}
	
	/**
	 * Generates a word of specified length.
	 * @param length
	 * @return
	 */
	public String Generate(int length) {
		LetterTypeCount=0;
		
		//Start this cosa with a random first letter.
		return Generate(length,Letters.ALL_LETTERS[new Random().nextInt(Letters.ALL_LETTERS.length)]);
	}
	
	/**
	 * Recursive function that starts making words.
	 * Create a word of the speciifed length, with the letter that came before the next one.
	 * @param length
	 * @param PreviousLetter
	 * @return
	 */
	public String Generate(int length, Letter PreviousLetter) {

		//Limit condition
		if(length==0) {return "";}
		
		//Setup for the next letter.
		Letter NextLetter;
		
		//If the letertypecount is larger than three we need a letter of another type.
		if(LetterTypeCount>3){
			if(PreviousLetter.GetType()==LetterType.CONSONANT) {NextLetter=PreviousLetter.GetRandomNextLetter(LetterType.VOWEL);} //If we had too many consonants, get a vowel
			else {NextLetter = PreviousLetter.GetRandomNextLetter(LetterType.CONSONANT);} //Else if we've got too many vowels, get a consonant.
		} else {NextLetter=PreviousLetter.GetRandomNextLetter();} //Else we don't have enough of something to make a choice. Get us anything.
		
		//if they're the same, increment our counter
		if(PreviousLetter.GetType()==NextLetter.GetType()) {LetterTypeCount++;}
		
		//If they're not then we've flipped. Reset the counter.
		else {LetterTypeCount=0;}
		
		//Now add it, and work on the next letter... r e c u r s i v e l y
		return NextLetter.GetChar()+Generate(length-1, NextLetter);
		
		
	}
	
}
