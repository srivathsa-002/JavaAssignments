public class CountTester {
    public void testCounts(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        System.out.println(la.countVisitsPerIP());
        LogAnalyzer la1 = new LogAnalyzer();
        la1.readFile("weblog3-short_log");
        System.out.println("Most visits by IP: " + la1.mostNumberVisitsByIP(la1.countVisitsPerIP()));
        System.out.println("Most visiting IP's are: " + la1.iPsMostVisits(la1.countVisitsPerIP()));
        System.out.println("IP's For Days: " + la1.iPsForDays());
        System.out.println("Day with most IP visits is: " + la1.dayWithMostIPVisits(la1.iPsForDays()));
        System.out.println("IP's with most visits on Sep 30 are: " + la1.iPsWithMostVisitsOnDay(la1.iPsForDays(),"Sep 30"));
    }
}