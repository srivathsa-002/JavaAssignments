public class WordPlay
{
    public boolean isVowel(char ch)
    {
        // put your code here
        String vowels = "aeiouAEIOU";
        if(vowels.indexOf(ch) != -1)
            return true;
        return false;
    }
    
    public void tester(){
        System.out.println("Are these vowels??");
        System.out.println("C " + isVowel('C'));
        System.out.println("E " + isVowel('E'));
        System.out.println("U " + isVowel('U'));
        System.out.println("V " + isVowel('V'));
        System.out.println("A " + isVowel('A'));
        
        System.out.println("\nReplacing");
        System.out.println("Hello World with * is " + replaceVowels("Hello World",'*'));
        System.out.println("I am a Bad Boy with $ is " + replaceVowels("I am a Bad Boy",'$'));
        
        System.out.println("\nEmphasizing");
        System.out.println("'dna ctgaaactga' at 'a' ....... " + emphasize("dna ctgaaactga", 'a'));
        System.out.println("'Mary Bella Abracadabra' at 'a' ....... " + emphasize("Mary Bella Abracadabra", 'a'));
    }
    
    public String replaceVowels(String phase,char ch){
        StringBuilder sb = new StringBuilder(phase);
        for(int i = 0;i < sb.length();i += 1){
            if(isVowel(sb.charAt(i)))
                sb.setCharAt(i,ch);
        }
        return sb.toString();
    }
    
    public String emphasize(String phase,char ch){
        String s = "";
        s += ch;
        StringBuilder sb = new StringBuilder(phase);
        String dup = "";
        StringBuilder sb1 = new StringBuilder(dup);
        for(int i = 0;i < sb.length();i += 1){
            if(sb.charAt(i) == s.charAt(0) || sb.charAt(i) == s.toUpperCase().charAt(0) || sb.charAt(i) == s.toUpperCase().charAt(0)) {
                if(i % 2 == 0){
                    sb1.append('*');
                    continue;
                }
                else{
                    sb1.append('+');
                    continue;
                }
            }
            sb1.append(sb.charAt(i));
        }
        return sb1.toString();
    }
}
