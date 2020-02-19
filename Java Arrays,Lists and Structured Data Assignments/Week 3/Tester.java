import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testUniqueIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        System.out.println("There are " + la.countUniqueIPs() + " unique IP's!!");
    }
    
    public void testLogAnalyzer(){
        LogAnalyzer la2 = new LogAnalyzer();
        System.out.println("Test Log Entries:");
        testLogEntry();
        la2.readFile("short-test_log");
        System.out.println("Printing all logs.....\n");
        la2.printAll();
        System.out.println("Printing log enteries with status code greater than 300.....\n");
        la2.printAllHigherThanNum(300);
        
        System.out.println("---------------------------------------------------------------------------------------");
        
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog-short_log");
        ArrayList<String> uniqueIPs = la.uniqueIPVisitsOnDay("Sep 14");
        System.out.println("Unique IP visits on Sep 14 are :" + uniqueIPs.size());
        System.out.println("And the IP's are:");
        for(String s:uniqueIPs)
            System.out.println(s);
        uniqueIPs.clear();
        uniqueIPs = la.uniqueIPVisitsOnDay("Sep 30");
        System.out.println("Unique IP visits on Sep 30 are :" + uniqueIPs.size());
        System.out.println("And the IP's are:");
        for(String s:uniqueIPs)
            System.out.println(s);
        
        System.out.println("---------------------------------------------------------------------------------------");
            
        LogAnalyzer la1 = new LogAnalyzer();
        la1.readFile("short-test_log");
        System.out.println("No.of unique IP's in range [200,299] are: " + la1.countUniqueIPsInRange(200,299));
        System.out.println("No.of unique IP's in range [300,399] are: " + la1.countUniqueIPsInRange(300,399));
        
    }
}
