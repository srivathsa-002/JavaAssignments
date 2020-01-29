public class Part2
{
    public int howMany(String a,String b)
    {
        // put your code here
        int index = 0;
        int count = 0;
        while (true){
            index = b.indexOf(a,index);
            if (index != -1){
                count++;
                index = index + a.length();
            }
            else
                break;
        }
        return count; 
    }
    
    public void testHowMany(){
        int count = howMany("AA","ATAAAA");
        System.out.println("No. of 'AA' in 'ATAAAA'.... " + count);
        
        count = howMany("GAA","ATGAACGAATTGAATC");
        System.out.println("No. of 'GAA' in 'ATGAACGAATTGAATC'.... " + count);
        
        count = howMany("a a","I ama abcdefa a");
        System.out.println("No. of 'a a' in 'I ama abcdefa a'.... " + count);
        
        count = howMany("BB","BBBCBBCBCBBCBBBBB");
        System.out.println("No. of 'BB' in 'BBBCBBCBCBBCBBBBB'.... " + count);
    }
}
