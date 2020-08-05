package igtampe.wordstructor;

import igtampe.wordstructor.Letter.LetterType;

/**
 * Holds all letters for word generating. Needs to be initialized!
 * @author igtampe
 */
public class Letters {
	
	private static boolean Initialized = false;
	
	public static final Letter A = new Letter('a',LetterType.VOWEL);
	public static final Letter B = new Letter('b',LetterType.CONSONANT);
	public static final Letter C = new Letter('c',LetterType.CONSONANT);
	public static final Letter D = new Letter('d',LetterType.CONSONANT);
	public static final Letter E = new Letter('e',LetterType.VOWEL);
	public static final Letter F = new Letter('f',LetterType.CONSONANT);
	public static final Letter G = new Letter('g',LetterType.CONSONANT);
	public static final Letter H = new Letter('h',LetterType.CONSONANT);
	public static final Letter I = new Letter('i',LetterType.VOWEL);
	public static final Letter J = new Letter('j',LetterType.CONSONANT);
	public static final Letter K = new Letter('k',LetterType.CONSONANT);
	public static final Letter L = new Letter('l',LetterType.CONSONANT);
	public static final Letter M = new Letter('m',LetterType.CONSONANT);
	public static final Letter N = new Letter('n',LetterType.CONSONANT);
	public static final Letter O = new Letter('o',LetterType.VOWEL);
	public static final Letter P = new Letter('p',LetterType.CONSONANT);
	public static final Letter Q = new Letter('q',LetterType.CONSONANT);
	public static final Letter R = new Letter('r',LetterType.CONSONANT);
	public static final Letter S = new Letter('s',LetterType.CONSONANT);
	public static final Letter T = new Letter('t',LetterType.CONSONANT);
	public static final Letter U = new Letter('u',LetterType.VOWEL);
	public static final Letter V = new Letter('v',LetterType.CONSONANT);
	public static final Letter W = new Letter('w',LetterType.CONSONANT);
	public static final Letter X = new Letter('x',LetterType.CONSONANT);
	public static final Letter Y = new Letter('y',LetterType.VOWEL); //Technically this isn't a vowel but we'll treat it as one. Let's see what happens.
	public static final Letter Z = new Letter('z',LetterType.CONSONANT);
	
	public static final Letter ALL_LETTERS[]= {A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z};
	public static final Letter CONSONANTS[] = {B,C,D,F,G,H,J,K,L,M,N,P,Q,R,S,T,V,W,X,Z};
	public static final Letter VOWELS[] = {A,E,I,O,U,Y};
	
	/**
	 * Initializes all letters, linking them properly. This shouldn't take more than a millisecond.
	 */
	public static void Initialize() {
		
		//Vowels are basically free range
		for (Letter CurLet : VOWELS) {CurLet.AddValidNextLetters(ALL_LETTERS);}
		
		//All Consonants should have Vowels available
		for (Letter CurLet : CONSONANTS) {CurLet.AddValidNextLetters(VOWELS);}
		
		//Plurality:
		for (Letter CurLet : CONSONANTS) {CurLet.AddValidNextLetter(S);}
		
		
		//And now for the special rules:
		
		//B
		B.AddValidNextLetter(L);
		B.AddValidNextLetter(R);
		
		//C
		C.AddValidNextLetter(H);
		C.AddValidNextLetter(K);
		C.AddValidNextLetter(L);
		C.AddValidNextLetter(R);
		C.AddValidNextLetter(T);
		
		//D
		D.AddValidNextLetter(L);
		D.AddValidNextLetter(R);
		D.AddValidNextLetter(V);
		
		//F
		F.AddValidNextLetter(L);
		F.AddValidNextLetter(R);
		
		//G
		G.AddValidNextLetter(G);
		G.AddValidNextLetter(L);
		G.AddValidNextLetter(R);
		
		//H
		//J
		//K
		K.AddValidNextLetter(L);
		K.AddValidNextLetter(R);
		K.AddValidNextLetter(W);
		
		//L (Basically L is also very free reigns
		L.AddValidNextLetter(B);
		L.AddValidNextLetter(C);
		L.AddValidNextLetter(D);
		L.AddValidNextLetter(F);
		L.AddValidNextLetter(G);
		L.AddValidNextLetter(H);
		L.AddValidNextLetter(K);
		L.AddValidNextLetter(L);
		L.AddValidNextLetter(M);
		L.AddValidNextLetter(N);
		L.AddValidNextLetter(P);
		L.AddValidNextLetter(R);
		L.AddValidNextLetter(T);
		L.AddValidNextLetter(V);
		L.AddValidNextLetter(W);
		L.AddValidNextLetter(X);
		L.AddValidNextLetter(Z);
		
		//M
		M.AddValidNextLetter(B);
		M.AddValidNextLetter(C);
		M.AddValidNextLetter(D);
		M.AddValidNextLetter(G);
		M.AddValidNextLetter(L);
		M.AddValidNextLetter(N);
		M.AddValidNextLetter(P);
		M.AddValidNextLetter(T);
		M.AddValidNextLetter(X);
		M.AddValidNextLetter(Z);
		
		//N
		N.AddValidNextLetter(D);
		N.AddValidNextLetter(G);
		N.AddValidNextLetter(T);
		N.AddValidNextLetter(Z);
		
		//P
		P.AddValidNextLetter(L);
		P.AddValidNextLetter(R);
		P.AddValidNextLetter(T);
		
		//Q
		//R
		R.AddValidNextLetter(F);
		R.AddValidNextLetter(K);
		R.AddValidNextLetter(T);
		R.AddValidNextLetter(X);
		
		//S
		S.AddValidNextLetter(H);
		S.AddValidNextLetter(K);
		S.AddValidNextLetter(L);
		S.AddValidNextLetter(M);
		S.AddValidNextLetter(P);
		S.AddValidNextLetter(R);
		S.AddValidNextLetter(T);
		
		//T
		T.AddValidNextLetter(H);
		T.AddValidNextLetter(L);
		T.AddValidNextLetter(R);
		
		//V
		V.AddValidNextLetter(R);
		V.AddValidNextLetter(L);
		
		//X
		X.AddValidNextLetter(T);
		
		//Z
		Z.AddValidNextLetter(V);
		
		//That should be it.

		Initialized=true;
		
	}
	
	/**
	 * Verifies that the Letters class has been initialized.
	 * @return
	 */
	public static boolean isInitialized() {return Initialized;}
	
}
