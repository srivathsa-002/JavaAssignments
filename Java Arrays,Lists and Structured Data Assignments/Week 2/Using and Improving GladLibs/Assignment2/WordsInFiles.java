import java.util.*;
import edu.duke.*;
import java.io.*;
import java.nio.file.Path; 
import java.nio.file.Paths; 
public class WordsInFiles
{
    private HashMap<String,ArrayList<String>> map;
    private ArrayList<String> fileList;
    private ArrayList<File> fileNameList;
    public WordsInFiles()
    {
        map = new HashMap<String,ArrayList<String>>();
        fileList = new ArrayList<String>();
        fileNameList = new ArrayList<File>();
    }
    private void addWordsFromFile(File f){
        FileResource fr = new FileResource(f);
        for(String s:fr.words()){
            if(map.containsKey(s)){
                fileList = map.get(s);
                if(!fileList.contains(f.getName())){
                    map.get(s).add(f.getName());
                }
            }
            else{
                ArrayList<String> fileList = new ArrayList<String>();
                fileList.add(f.getName());
                map.put(s,fileList);
            }
        }
    }
    
    public void buildWordFileMap(){
        map.clear();
        DirectoryResource dr = new DirectoryResource();
        for(File f:dr.selectedFiles()){
            fileNameList.add(f);
            addWordsFromFile(f);
        }
    }
    
    public int maxNumber(){
        int max = 0;
        for(String s:map.keySet()){
            if(map.get(s).size() > max){
                max = map.get(s).size();
            }
        } 
        return max;
    }
    
    private ArrayList<String> wordsInNumFiles(int number){
        ArrayList<String> wordsList = new ArrayList<String>();
        for(String word:map.keySet())
            if(map.get(word).size() == number)
                wordsList.add(word);
        return wordsList;
    }
    
    public void printFilesIn(String word){
        for(File f:fileNameList){
            FileResource fr = new FileResource(f);
            for(String s:fr.words())
                if(s.equals(word)){
                    Path path = Paths.get(f.getName());
                    System.out.println(path.getFileName());
                }
        }
    }
    
    public void tester(){
        buildWordFileMap();
        int number = maxNumber();
        System.out.println("The greatest number of files a word appears in is " + number);
        ArrayList<String> wordsList = wordsInNumFiles(number);
        System.out.println("There are " + wordsList.size() + " such words: ");
        for(int i=0;i<wordsList.size();i++){
            System.out.println(wordsList.get(i));
            printFilesIn(wordsList.get(i));
        }
        System.out.println(map);
    }
}
