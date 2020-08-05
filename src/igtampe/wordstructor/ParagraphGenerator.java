package igtampe.wordstructor;

/**
 * Generates a giberish paragraph of configured word length.
 * @author igtampe
 *
 */
public class ParagraphGenerator {

	public static void main(String[] args) {
		
		//------------[config]------------
		
		int MaxLength = 5;
		int MinLength = 4;
		int ParagraphLength = 2000;
					
		//--------------------------------
		
		WordGenerator Gen = new WordGenerator(MaxLength, MinLength);
		
		for (int i = 0; i < ParagraphLength; i++) {System.out.print(Gen.Generate() + " ");}
		
		
	}
	
}
