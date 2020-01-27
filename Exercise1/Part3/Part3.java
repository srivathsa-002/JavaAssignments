public class Part3
{
    public boolean twoOccurrences(String a,String b){
        int length = a.length();
        int index = b.indexOf(a);
        if(index > 0) {
            index = b.indexOf(a,index+length);
            if(index > 0) {
                return true;
            }
        }    
        return false;
    }
    
    public void testing() {
        System.out.println("Comparing 'by' & 'A story by Abby Long'..... " + twoOccurrences("by","A story by Abby Long"));
        System.out.println("Comparing 'a' & 'banana'..... " + twoOccurrences("a","banana"));
        System.out.println("Comparing 'atg' & 'ctgtatgta'..... " + twoOccurrences("atg","ctgtatgta"));
        System.out.println("Comparing 'Hello' & 'Hello World'..... " + twoOccurrences("Hello","Hello World"));
        System.out.println("Comparing 'sss' & 'asssss abyss'..... " + twoOccurrences("sss","asssss abyss"));
        System.out.println("Comparing 'asdf' & 'qwertyasdfzxcvbnmqwertyuiopasdfghjklzxcvbnm'..... " + twoOccurrences("asdf","qwertyasdfzxcvbnmqwertyuiopasdfghjklzxcvbnm"));            
        System.out.println("\n\nLast part of 'A story by Abby Long' after 'by' is : " + lastPart("by","A story by Abby Long"));
        System.out.println("Last part of 'banana' after 'an' is : " + lastPart("an","banana"));
        System.out.println("Last part of 'Hello World' after 'Hello' is : " + lastPart("Hello","Hello World"));
        System.out.println("Last part of 'sss' after 'asssss abyss' is : " + lastPart("sss","asssss abyss"));
        System.out.println("Last part of 'asdf' after 'qwertyasdfzxcvbnmqwertyuiopasdfghjklzxcvbnm' is : " + lastPart("asdf","qwertyasdfzxcvbnmqwertyuiopasdfghjklzxcvbnm"));
    }
    
    public String lastPart(String a,String b) {
        int index = b.indexOf(a);
        int length = a.length();
        if(index!=-1)
            return b.substring(index + length,b.length());
        return b;
    }
    
    public static void main (String args[]) {
        Part3 p = new Part3();
        p.testing();
    }
}
