public class Part1
{
    public String findSimpleGene(String dna)
    {
        // put your code here
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1)
            return "";
        int stopIndex = dna.indexOf("TAA",startIndex+3);
        if (stopIndex == -1)
            return "";
        if ((stopIndex - startIndex)%3==0)
            return dna.substring(startIndex,stopIndex+3);
        return "";
    }
    
    public void testSimpleGene()
    {
        String dna1 = "ATTGTTTAA";
        System.out.println("DNA is : " + dna1);
        System.out.println("Gene is : " + findSimpleGene(dna1));
        
        String dna2 = "TBATGTTTATTGTTT";
        System.out.println("\nDNA is : " + dna2);
        System.out.println("Gene is : " + findSimpleGene(dna2));
        
        String dna3 = "ATTGTTTATTGTTTA";
        System.out.println("\nDNA is : " + dna3);
        System.out.println("Gene is : " + findSimpleGene(dna3));
        
        
        String dna4 = "ATCTCAATGTTCTTGAAGTAACTG";
        System.out.println("\nDNA is : " + dna4);
        System.out.println("Gene is : " + findSimpleGene(dna4));
        
        String dna5 = "ATCTCAATGTTCTTGATAACT";
        System.out.println("\nDNA is : " + dna5);
        System.out.println("Gene is : " + findSimpleGene(dna5));
    }
    
    public static void main(String args[])
    {
       Part1 p = new Part1();
       p.testSimpleGene();
    }    
}
