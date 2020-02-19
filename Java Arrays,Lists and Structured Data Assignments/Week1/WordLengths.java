import edu.duke.*;
public class WordLengths
{
    public void countWordLengths(FileResource resource,int[] counts)
    {
        // put your code here
        for(String s : resource.words()){
            char ch = s.charAt(0);
            int lengthOfWord = s.length();
            if(Character.isLetter(s.charAt(0)) && Character.isLetter(s.charAt(lengthOfWord-1)))
                counts[lengthOfWord] += 1;
            else
                counts[lengthOfWord-1] += 1;
        }
        //for(int i=0;i<counts.length;i++)
          //  System.out.println("No. of words of length " + i + ": " + counts[i]);
    }
    
    public void testCountWordLengths(){
        int[] counts = new int[31];
        FileResource resource = new FileResource();
        countWordLengths(resource,counts);
        for(int i=0;i<counts.length;i++)
            System.out.println("No. of words of length " + i + ": " + counts[i]);
    
        int max = indexOfMax(counts);
        System.out.println("Index of Maximum length word: " + max);
    }
    
    public int indexOfMax(int[] values){
        int maxIndex = 0;
        for(int i=1;i<values.length;i++){
            if(values[i]>values[maxIndex])
                maxIndex=i;
        }
        return maxIndex;
    }
}
