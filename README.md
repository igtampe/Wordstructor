# Wordstructor
Constructs words based on letters and their valid next letters. The result? Speakable gibberish.

An example of a few interesting words generated:<br>
apevayckub, iimtoibype, ryayho, ivimy, tajicat, ectaefo, uvugon, ucorojona, utsyoanapi, pipegrotivs, etc.

It doesn't really work well with small words. Once you get to 3 letter words, it's common to get 3 consonants. <br>
I made it as a potential naming tool, but I don't know if it'd really be that useful. Still, it seems to create interesting sounding gibberish.

----

The rules so far as configured in the Letters class.
- All Vowels can be followed by consonants.
- All Consonants can be followed by vowels.
- All letters can be followed by 'S'
- Special Rules:
    - B can be followed by L and R.
    - C can be followed by H, K, L, R, and T
    - D can be followed by L, R, and V
    - F can be followed by L and R
    - G can be followed by G, L, and R
    - K can be followed by L, R, and W
    - L can be followed by B, C, D, F, G, H, K, L, M, N, P, R, T, V, W, X, and Z
    - M can be followed by B, C, D, G, L, N, P, T, X, and Z
    - N can be followed by D, G, T, and Z
    - P can be followed by L, R, and T.
    - R can be followed by F, K, T, and X.
    - S can be followed by H. K, L, M, N, P, R, T.
    - T can be followed by H, L, R.
    - V can be followed by R, and L
    - W can be followed by H, N, and R
    - X can be followed by T
    - Z can be followed by V

The Rules as configured in the word generator
- There cannot be more than 3 of the same type of letter (Consonant or Vowel) in a row (unless it's the last letter)
