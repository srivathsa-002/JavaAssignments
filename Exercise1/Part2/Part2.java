public class Part2
{
    public String findSimpleGene(String dna,String startCodon,String stopCodon)
    {
        // put your code here
        String dupDna=dna.toUpperCase();
        int startIndex = dupDna.indexOf(startCodon);
        if (startIndex == -1)
            return "";
        int stopIndex = dupDna.indexOf(stopCodon,startIndex + 3);
        if (stopIndex == -1)
            return "";
        if ((stopIndex - startIndex) % 3 == 0)
            return dna.substring(startIndex,stopIndex+3);
        return "";
    }
    
    public void testSimpleGene()
    {
        String dna1 = "ATTGTTTAA";
        System.out.println("DNA is : " + dna1);
        System.out.println("Gene is : " + findSimpleGene(dna1,"ATG","TAA"));
        
        String dna2 = "TBATGTTTATTGTTT";
        System.out.println("\nDNA is : " + dna2);
        System.out.println("Gene is : " + findSimpleGene(dna2,"ATG","TAA"));
        
        String dna3 = "ATTGTTTATTGTTTA";
        System.out.println("\nDNA is : " + dna3);
        System.out.println("Gene is : " + findSimpleGene(dna3,"ATG","TAA"));
        
        
        String dna4 = "atctcaatgttcttgaagtaactg";
        System.out.println("\nDNA is : " + dna4);
        System.out.println("Gene is : " + findSimpleGene(dna4,"ATG","TAA"));
        
        String dna5 = "ATCTCAATGTTCTTGATAACT";
        System.out.println("\nDNA is : " + dna5);
        System.out.println("Gene is : " + findSimpleGene(dna5,"ATG","TAA"));
    }
    
    public static void main(String args[])
    {
       Part1 p = new Part1();
       p.testSimpleGene();
    }    
}
