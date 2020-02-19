import edu.duke.*;
import java.util.*;

public class GladLibMap {
    private ArrayList<String> usedWords;
    private Random myRandom;
    private HashMap<String,ArrayList<String>> myMap; 
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";
    
    public GladLibMap(){
        myMap = new HashMap<String,ArrayList<String>>();
        myRandom = new Random();
        usedWords = new ArrayList<String>();
        initializeFromSource(dataSourceDirectory);
    }
    
    public GladLibMap(String source){
        initializeFromSource(source);
        myRandom = new Random();
        usedWords = new ArrayList<String>();
        myMap = new HashMap<String,ArrayList<String>>();
    }
    
    private void initializeFromSource(String source) {
        String[] labels = {"country","noun","adjective","timeframe","animal","name","color","verb","fruit"};
        ArrayList<String> nameList = new ArrayList<String>();
        for(int i=0;i<labels.length;i++){
            nameList = readIt(source+"/"+labels[i]+".txt");
            myMap.put(labels[i],nameList);
        }
    }
    
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    private String getSubstitute(String label) {
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        else{
            for(String s:myMap.keySet()){
                if(s.equals(label)){
                    return randomFrom(myMap.get(label));
                }
            }
        }
        return "**UNKNOWN**";
    }
    
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
        if(usedWords.size() != 0) {
            while(true) {
                if (usedWords.contains(sub)) {
                    sub = getSubstitute(w.substring(first+1,last));
                }
                else {
                    usedWords.add(sub);
                    break;
                }
            }
        }
        else if(usedWords.size() == 0){
            usedWords.add(sub);
        }
        return prefix+sub+suffix;
    }
    
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    
    public int totalWordsInMap(){
        int count = 0;
        for(String s:myMap.keySet())
            count += myMap.get(s).size();
        return count;
    }
    
    public int totalWordsConsidered(){
        return 0;
    }
    
    public void makeStory(){
           usedWords.clear();
           System.out.println("\n");
           String story = fromTemplate("data/madtemplate2.txt");
           printOut(story, 60);
           System.out.println("\n\n\n\nNumber of words replaced: " + usedWords.size());
    }
}