import edu.duke.*;
public class CaesarCipher
{
    public String encrypt(String input,int key)
    {
        // put your code here
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        String shiftedAlphabetLower = alphabetLower.substring(key) + alphabetLower.substring(0,key);
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
    
    public void testCaesar(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        int key1 = 17, key2 = 23;
        String encrypted = encryptTwoKeys(message,key2,key1);
        System.out.println("keys are " + key2 + "," + key1 + "\n" + encrypted);
        
    }
    
    public String encryptTwoKeys(String input,int key1,int key2){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
        String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0,key1);
        String shiftedAlphabetLower1 = alphabetLower.substring(key1) + alphabetLower.substring(0,key1);
        String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0,key2);
        String shiftedAlphabetLower2 = alphabetLower.substring(key2) + alphabetLower.substring(0,key2);
        StringBuilder encrypted = new StringBuilder(input);
        for(int i = 0;i < encrypted.length();i += 1){
            if(i % 2 == 0){
                char curChar = encrypted.charAt(i);
                if(Character.isUpperCase(curChar)){
                    int index = alphabet.indexOf(curChar);
                    if(index != -1){
                        char newChar = shiftedAlphabet1.charAt(index);
                        encrypted.setCharAt(i,newChar);
                    }
                }
                else{
                    int index = alphabetLower.indexOf(curChar);
                    if(index != -1){
                        char newChar = shiftedAlphabetLower1.charAt(index);
                        encrypted.setCharAt(i,newChar);
                    }
                }
            }
            else{
                char curChar = encrypted.charAt(i);
                if(Character.isUpperCase(curChar)){
                    int index = alphabet.indexOf(curChar);
                    if(index != -1){
                        char newChar = shiftedAlphabet2.charAt(index);
                        encrypted.setCharAt(i,newChar);
                    }
                }
                else{
                    int index = alphabetLower.indexOf(curChar);
                    if(index != -1){
                        char newChar = shiftedAlphabetLower2.charAt(index);
                        encrypted.setCharAt(i,newChar);
                    }
                }
            }
        }
        return encrypted.toString();
    }
}
