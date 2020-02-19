import java.util.ArrayList;
import edu.duke.*;
public class WordFrequencies
{
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    public WordFrequencies()
    {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    public void findUnique()
    {
        myWords.clear();
        myFreqs.clear();
        FileResource fr = new FileResource();
        for(String s: fr.words()){
            int index = myWords.indexOf(s.toLowerCase());
            if(index == -1){
                myWords.add(s);
                myFreqs.add(1);
            }
            else{
                int value = myFreqs.get(index);
                myFreqs.set(index,value + 1);
            }
        }
    }
    public void tester(){
        findUnique();
        System.out.println("Number of unique words: " + myWords.size());
        for(int k=0;k<myWords.size();k++)
            System.out.println(myFreqs.get(k) + "\t" + myWords.get(k));
        int maxInd = findIndexOfMax();
        System.out.println("The word that occurs most often and its count are: " + myWords.get(maxInd) + " " + myFreqs.get(maxInd));
    }
    public int findIndexOfMax(){
        int maxInd = 0;
        for(int k=1;k<myFreqs.size();k++){
            if(myFreqs.get(k)>myFreqs.get(maxInd))
                maxInd = k;
        }
        return maxInd; 
    }
}
