import edu.duke.*;
public class CaesarCipher
{
  private String alphabet;
  private String shiftedAlphabet;
  private String shiftedAlphabetLower;  
  private String alphabetLower;
  private int mainKey;
  public CaesarCipher(int key)
    {
        // initialise instance variables
        alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        alphabetLower = "abcdefghijklmnopqrstuvwxyz";
        shiftedAlphabet=""+alphabet.substring(key)+alphabet.substring(0,key);
        shiftedAlphabetLower = alphabetLower.substring(key) + alphabetLower.substring(0,key);
        mainKey=key;
    }
  
  public String encrypt(String input)
  {
        // put your code here
        StringBuilder encrypted = new StringBuilder(input);
        for(int i = 0;i < encrypted.length();i += 1){
            char curChar = encrypted.charAt(i);
            if(Character.isUpperCase(curChar)){
                int index = alphabet.indexOf(curChar);
                if(index != -1){
                    char newChar = shiftedAlphabet.charAt(index);
                    encrypted.setCharAt(i,newChar);
                }
            }
            else{
                int index = alphabetLower.indexOf(curChar);
                if(index != -1){
                    char newChar = shiftedAlphabetLower.charAt(index);
                    encrypted.setCharAt(i,newChar);
                }
            }
        }
        return encrypted.toString();
  }
    
  public String decrypt(String input){
        //TestCaesarCipher tcc = new TestCaesarCipher();
        CaesarCipher cc = new CaesarCipher(26-mainKey);
        return cc.encrypt(input);
  }
}