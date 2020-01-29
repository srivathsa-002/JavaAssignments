public class Part1
{
    public int findStopCodon(String dna,int startIndex,String stopCodon)
    {
        // put your code here
        int curIndex = dna.indexOf(stopCodon,startIndex + 3);
        while(curIndex != -1){
            if ((curIndex - startIndex) % 3 == 0){
                return curIndex;
            }
            else{
                curIndex = dna.indexOf(stopCodon,curIndex+1);
            }
        }
        return dna.length();
    }
    
    public void testFindStopCodon(){
        String dna = "ATTATGTTAATTTAA";
        int index = findStopCodon(dna,3,"TAA");
        if (index != 12) System.out.println("Error at 12 :(");
        
        dna = "ATGTTAATTTTAGAATAGGTA";
        index = findStopCodon(dna,0,"TAG");
        if (index != 15) System.out.println("Error at 15 :(");
        
        dna = "ATTAGTATGAATTTAATTTGAAG";
        index = findStopCodon(dna,6,"TGA");
        if (index != 18) System.out.println("Error at 18 :(");
        
        dna = "ATTATGTTAATTAA";
        index = findStopCodon(dna,3,"TAA");
        if (index != 14) System.out.println("Error :(");
        
        System.out.println("Finished Tests :)");
    }
    
    public String findGene(String dna,int pos){
        int startIndex = dna.indexOf("ATG",pos);
        if (startIndex == -1)
            return "";
        //int stopIndex = dna.indexOf("TAA",startIndex + 3);;
        int taaIndex = findStopCodon(dna,startIndex,"TAA");
        int tagIndex = findStopCodon(dna,startIndex,"TAG");
        int tgaIndex = findStopCodon(dna,startIndex,"TGA");
        int minIndex = 0;
        if (taaIndex == -1 || (tagIndex != -1 && tgaIndex < taaIndex) )
            minIndex = tgaIndex;
        else
            minIndex = taaIndex;
        if (minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex) )
            minIndex = tagIndex;
        if (minIndex == -1)
            return "";
        return dna.substring(startIndex,minIndex + 3);
    }
    
    public void testFindGene(){
        String dna = "ATTTAATGTAG";
        System.out.println("DNA is " + dna);
        String gene = findGene(dna,0);
        System.out.println("Gene is " + gene);
        
        dna = "ATTTAAATGTAG";
        System.out.println("DNA is " + dna);
        gene = findGene(dna,0);
        System.out.println("Gene is " + gene);
        
        dna = "AATATGTTATGATGTTAAGTGTAG";
        System.out.println("DNA is " + dna);
        gene = findGene(dna,0);
        System.out.println("Gene is " + gene);
        
        dna = "ATGAATTGTAATAGT";
        System.out.println("DNA is " + dna);
        gene = findGene(dna,0);
        System.out.println("Gene is " + gene);
        
        //String dna5 = "ATTTAAATGTAG";
    }
    
    public void printAllGenes(String dna){
        int startIndex = 0;
        while (true){
            String curGene = findGene(dna,startIndex);
            if (curGene.isEmpty())
                break;
            System.out.println(curGene);
            startIndex = dna.indexOf(curGene,startIndex) + curGene.length();
        }
    }
    
    public void test(){
        printAllGenes("ATGGGGTTTTAAAGGATGGGTTTTGATTAGATTATGTATTATTATTAG");
    }
}