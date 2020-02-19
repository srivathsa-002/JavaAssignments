import java.util.HashMap;
import edu.duke.*;
public class CodonCount
{
    private HashMap<String,Integer> map;
    public CodonCount()
    {
        map = new HashMap<String,Integer>();
    }
    public void buildCodonMap(int start,String dna)
    {
        String dnaDup = dna.toUpperCase();
        String codon;
        for(int i=start;i<dna.length();i+=3){
            if(i+2 < dna.length()){
                codon = dnaDup.substring(i,i+3);
                if(map.containsKey(codon))
                    map.put(codon,map.get(codon)+1);
                else{
                    int value = 1;
                    map.put(codon,value);
                }
            }
        }
    }
    
    public String getMostCommonCodon(){
        int max = 0;
        String mostCommonCodon = "";
        for(String s:map.keySet()) {
            if(max < map.get(s)){
                max = map.get(s);
                mostCommonCodon = s;
            }
        }
        return mostCommonCodon;
    }
    
    public void printCodonCounts(int start,int end) {
        for(String s:map.keySet()) {
            if((map.get(s)>=start) && (map.get(s)<=end))
                System.out.println(s + ":" + map.get(s));
        }
    }
    
    public void test(){
        /*buildCodonMap(2,"CGTTCAAGTTCAAGTTCATGAT");
        for(String s:map.keySet())
            System.out.println(s + " = " + map.get(s));
        System.out.println("Most commmon codon = " + getMostCommonCodon());
        System.out.println("Printing codons with counts in between 2 and 3: ");
        printCodonCounts(2,3);*/
        
        System.out.println("Using Files...........");
        FileResource fr = new FileResource();
        for(int i=0;i<3;i++){
            //HashMap<String,Integer> map = new HashMap<String,Integer>();
            map.clear();
            buildCodonMap(i,fr.asString().trim());
            System.out.println("Most commmon codon = " + getMostCommonCodon());
            System.out.println("Printing codons with counts in between 1 and 5: ");
            printCodonCounts(1,5);
        }
    }
    
}
