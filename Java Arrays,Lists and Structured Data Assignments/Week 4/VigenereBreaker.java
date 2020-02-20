import java.util.*;
import edu.duke.*;
import java.io.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        String slicedMessage = "";
        StringBuilder sb = new StringBuilder(message);
        for(int i=whichSlice;i<message.length();i+=totalSlices){
            slicedMessage += sb.charAt(i);
        }
        return slicedMessage;
    }
    
    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker cc = new CaesarCracker();
        for(int i=0;i<klength;i++){
            String slicedMessage = sliceString(encrypted,i,klength);
            key[i] = cc.getKey(slicedMessage);
        }
        return key;
    }

    public void breakVigenere () {
        FileResource fr1 = new FileResource();
        String message = fr1.asString();
        DirectoryResource dr = new DirectoryResource();
        HashMap<String,HashSet<String>> languages = new HashMap<String,HashSet<String>>();
        for(File f:dr.selectedFiles()){
            String lang = f.getName();
            FileResource fr = new FileResource(f);
            HashSet<String> dictionary = readDictionary(fr);
            languages.put(lang,dictionary);
        }
        //System.out.println("Decrypted message is:\n" + breakForLanguage(message,dictionary));
        //System.out.println("Most Common Char is: " + mostCommonCharIn(dictionary));
        breakForAllLangs(message,languages);
    }
    
    public HashSet<String> readDictionary(FileResource fr){
        HashSet<String> set = new HashSet<String>();
        for(String s:fr.lines()){
            set.add(s.toLowerCase());
        }
        return set;
    }
    
    public int countWords(String message,HashSet<String> dictionary){
        int count = 0;
        for(String word:message.split("\\W+")){
            if(dictionary.contains(word.toLowerCase()))
                count++;
        }
        return count;
    }
    
    public String breakForLanguage(String encrypted,HashSet<String> dictionary){       
        int maxCount = 0;
        String finalDecryptedMessage = "";
        for(int i=1;i<=100;i++){
            int[] temp = tryKeyLength(encrypted,i,mostCommonCharIn(dictionary));
            VigenereCipher vc = new VigenereCipher(temp);
            String decrypted = vc.decrypt(encrypted);
            int currentCount = countWords(decrypted,dictionary);
            if(currentCount > maxCount){
                maxCount = currentCount;
                finalDecryptedMessage = decrypted;
            }
        }
        return finalDecryptedMessage;
    }
    
    public char mostCommonCharIn(HashSet<String> dictionary){
        HashMap<Character,Integer> charMap = new HashMap<Character,Integer>();
        char mostCommonChar = ' ';
        int maxCount = 0;
        for(String s:dictionary){
            for(int i=0;i<s.length();i++){
                if(!charMap.containsKey(s.charAt(i)))
                    charMap.put(s.charAt(i),1);
                else
                    charMap.put(s.charAt(i),charMap.get(s.charAt(i))+1);
            }
        }
        for(char ch:charMap.keySet()){
            if(charMap.get(ch) > maxCount){
                maxCount = charMap.get(ch);
                mostCommonChar = ch;
            }
        }
        return mostCommonChar;
    }
    
    public void breakForAllLangs(String encrypted,HashMap<String,HashSet<String>> languages){
        HashSet<String> dictionary = new HashSet<String>();
        int maxCount = 0;
        String finalDecryptedMessage = "";
        String lang = "";
        for(String s:languages.keySet()){
            dictionary = languages.get(s);
            String decrypted = breakForLanguage(encrypted,dictionary);
            int currentCount = countWords(decrypted,dictionary);
            if(currentCount > maxCount){
                maxCount = currentCount;
                finalDecryptedMessage = decrypted;
                lang = s;
            }
        }
        System.out.println("Decrypted Message is in " + lang + " language and is as follows: " + finalDecryptedMessage);
    }
}