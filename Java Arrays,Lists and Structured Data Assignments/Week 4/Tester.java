import edu.duke.*;
import java.util.*;
public class Tester {
    public void test(){
        VigenereBreaker vb = new VigenereBreaker();
        System.out.println(vb.sliceString("abcdefghijklm",3,5));
        FileResource fr = new FileResource();
        HashSet<String> dictionary = vb.readDictionary(fr);
        FileResource fr1 = new FileResource();
        String message = fr1.asString();
        System.out.println(vb.breakForLanguage(message,dictionary));
        //int[] key = vb.tryKeyLength(message,5,'e');
        //for(int i:key)
        //    System.out.println(i);
    }
}