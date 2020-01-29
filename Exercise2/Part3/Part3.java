public class Part3
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
        return -1;
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
    
    public int countGenes(String dna){
        int startIndex = 0;
        int count = 0;
        while (true){
            String curGene = findGene(dna,startIndex);
            if (curGene.isEmpty())
                break;
            count++;
            //System.out.println(curGene);
            startIndex = dna.indexOf(curGene,startIndex) + curGene.length();
        }
        return count;
    }
    
    public void testCountGenes(){
        System.out.println("No. of Genes in 'ATGTGAATGAGGATGGGTTTTGATTAGATTATGTATTATTATTAG' are " + countGenes("ATGTGAATGAGGATGGGTTTTGATTAGATTATGTATTATTATTAG"));
        System.out.println("No. of Genes in 'ATTATGTAGGTA' are " + countGenes("ATTATGTAGGTA"));
        System.out.println("No. of Genes in 'ATGTGAATGAGGATGGGTTTTGATTAGATTATGTATTATTATTAGATGTGAATGAGGATGGGTTTTGATTAGATTATGTATTATTATTAG' are " + countGenes("ATGTGAATGAGGATGGGTTTTGATTAGATTATGTATTATTATTAGATGTGAATGAGGATGGGTTTTGATTAGATTATGTATTATTATTAG"));
        System.out.println("No. of Genes in 'ATGGTATAAGTATGTGA' are " + countGenes("ATGGTATAAGTATGTGA"));
        System.out.println("No. of Genes in 'ATGGGGGTTAGGTATGTAAATGTG' are " + countGenes("ATGGGGGTTAGGTATGTAAATGTG"));
        System.out.println("No. of Genes in 'ATGGTATTT' are " + countGenes("ATGGTATTT"));
    }
}
