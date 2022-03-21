# Wordle Kata
Write a Wordle engine. 
Wordle is a guessing game where the player attempts to guess a word in a maximun of six tries. On every attempt you get a response with feedback about the attempt or the guessed word if successful.


## Rules
* Player has six attempts
* Only real English words which are exactly five letters long are valid
* If the guess is correct then wordle retunrs the word in upper case, ie: `HELLO`
* If the word is illegal (not found in dictionary) response is `#####`, and does not count as a valid attempt.
* If there were six valid attempts already (so from seventh onwards) response is "@@@@@"
* If the word does not match then feedback is given per individual character. For example if the hidden word is `HELLO` :
  * If the letter does not match and is not present in other possition then return a `.`. Guessing `audit` returns `.....` 
  * If the character matches both letter and position, for that position the same character is returned uppercase. Guessing `rebut` returns : `.E...`
  * If the character does not match in that possition but it is found in another unguessed position in the word then it is returned in lowercase : Guessing `awake` returns : `....e` but also guessing `spill` returns `...Ll`
  * If the letter matches but appear more times in the guess word than in the hidden word then replace additional characters with a `.`.  Guessing `needy` returns `.E...`

