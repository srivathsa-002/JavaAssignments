import edu.duke.*;
import java.util.ArrayList;
public class CharactersInPlay
{
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    public CharactersInPlay()
    {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    
    }
    public void update(String person)
    {
        int index = myWords.indexOf(person);
        if(index == -1){
           myWords.add(person);
           myFreqs.add(1);
        }
        else{
            int value = myFreqs.get(index);
            myFreqs.set(index,value + 1);
        }
    }
    public void findAllCharacters(){
        myWords.clear();
        myFreqs.clear();
        FileResource fr = new FileResource();
        for(String s:fr.lines()){
            int index = s.indexOf('.');
            if(index != -1){
                String person = s.substring(0,index);
                update(person);
            }
        }
    }
    public void charactersWithNumParts(int num1,int num2){
        System.out.println("Those with count greater than " + num1 + " and less than or equal to " + num2 + ":");
        for(int k=0;k<myFreqs.size();k++){
            if((myFreqs.get(k)<=num2) && (myFreqs.get(k)>num1)){
                System.out.println(myWords.get(k) + " " + myFreqs.get(k));
            }
        }
    }
    public void tester(){
        findAllCharacters();
        for(int k=0;k<myWords.size();k++)
            System.out.println(myWords.get(k) + " " + myFreqs.get(k));    
        charactersWithNumParts(1,3);
    }
}
