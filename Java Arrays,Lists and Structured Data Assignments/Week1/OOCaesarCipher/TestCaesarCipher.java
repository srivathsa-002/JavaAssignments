import edu.duke.*;
public class TestCaesarCipher{
    private String encrypted;
    private String decrypted;
    CaesarCipher cc = new CaesarCipher(26);
    public int[] countLetters(String msg)
      {   
            // put your code here
            String alpha = "abcdefghijklmnopqrstuvwxyz";
            int[] counts= new int[26];
            for(int k=0;k<msg.length();k++){
                char ch=Character.toLowerCase(msg.charAt(k));
                int index=alpha.indexOf(ch);
                if(index!=-1)
                    counts[index]+=1;
            }
            return counts;
    }
    
    public int maxIndex(int[] vals){
            int maxInd = 0;
            for(int i=0;i<vals.length;i++)
                if(vals[i]>vals[maxInd])
                    maxInd = i;
            return maxInd;
    }
    
    public void simpleTests(){
            FileResource fr = new FileResource();
            String ex = fr.asString();
            CaesarCipher cc= new CaesarCipher(18);
            encrypted = cc.encrypt("Hello");
            System.out.println("Hello is encrypted as: " + encrypted);
            decrypted = cc.decrypt(encrypted);
            System.out.println(encrypted + " is decrypted as: " + decrypted);
            
            decrypted=breakCaesarCipher(encrypted);
            System.out.println(encrypted +" is decrypted as: " + decrypted);
    }  
        
    public String breakCaesarCipher(String input){
            int[] freq = countLetters(input);
            int maxInd = maxIndex(freq);
            int key = maxInd;
            if(maxInd<4)
                key=26-(5+maxInd);
            return encrypt(input,26-key);
    }
      
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

}