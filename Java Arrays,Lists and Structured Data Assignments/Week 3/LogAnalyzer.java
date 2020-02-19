import edu.duke.*;
import java.util.*;
public class LogAnalyzer{
    private ArrayList<LogEntry> records; 
    public LogAnalyzer(){
        records = new ArrayList<LogEntry>();
    }
    public void readFile(String fileName){
        FileResource fr = new FileResource();
        for(String s:fr.lines()){
            LogEntry le = WebLogParser.parseEntry(s);
            records.add(le);
        }
    }
    public void printAll(){
        for(LogEntry le:records)
            System.out.println(le);
    }
    public int countUniqueIPs(){
        ArrayList<String> uniqueIPsList = new ArrayList<String>();
        for(LogEntry le:records){
            String ipAddress = le.getIp();
            if(!uniqueIPsList.contains(ipAddress)){
                uniqueIPsList.add(ipAddress);
            }
        }
        return uniqueIPsList.size();
    }
    
    public void printAllHigherThanNum(int num){
        for(LogEntry le:records){
            int statusCode = le.getStatus();
            if(statusCode>num)
                System.out.println(le);
        }
    }
    
    public ArrayList<String> uniqueIPVisitsOnDay(String someday){
        ArrayList<String> uniqueIPsList = new ArrayList<String>();
        for(LogEntry le:records){
            String day = le.getTime().toString();
            if(day.indexOf(someday) != -1){
                String ipAddress = le.getIp();
                if(!uniqueIPsList.contains(ipAddress))
                    uniqueIPsList.add(ipAddress);
            }
        }
        return uniqueIPsList;
    }
    
    public int countUniqueIPsInRange(int low,int high){
        ArrayList<String> uniqueIPsList = new ArrayList<String>();
        for(LogEntry le:records){
            int statusCode = le.getStatus();
            if((statusCode>=low) && (statusCode<=high)){
                String ipAddress = le.getIp();
                if(!uniqueIPsList.contains(ipAddress)){
                    uniqueIPsList.add(ipAddress);
                }
            }
        }
        return uniqueIPsList.size();
    }
    
    public HashMap<String,Integer> countVisitsPerIP(){
        HashMap<String,Integer> counts = new HashMap<String,Integer>();
        for(LogEntry le:records){
            String ipAddress = le.getIp();
            if(!counts.containsKey(ipAddress)){
                counts.put(ipAddress,1);
            }
            else{
                counts.put(ipAddress,counts.get(ipAddress)+1);
            }
        }
        return counts;
    }
    
    public int mostNumberVisitsByIP(HashMap<String,Integer> myMap){
        int maxVisits = 0;
        for(String s:myMap.keySet()){
            if(myMap.get(s) > maxVisits)
                maxVisits = myMap.get(s);
        }
        return maxVisits;
    }
    
    public ArrayList<String> iPsMostVisits(HashMap<String,Integer> myMap){
        ArrayList<String> mostVisitsList = new ArrayList<String>();
        int mostVisit = mostNumberVisitsByIP(myMap);
        for(String s:myMap.keySet()){
            if(myMap.get(s) == mostVisit)
                mostVisitsList.add(s);
        }
        return mostVisitsList;
    }
    
    public HashMap<String,ArrayList<String>> iPsForDays(){
        HashMap<String,ArrayList<String>> myMap = new HashMap<String,ArrayList<String>>();
        for(LogEntry le:records){
            Date d = le.getTime();
            String strDate = d.toString().substring(4,10);
            /*if(!myMap.get(le.getIp()).equals(le.getIp())){
                ipList.add(le.getIp());
                myMap.put(strDate,ipList);
            }*/
            if(!myMap.containsKey(strDate)){
                ArrayList<String> ipList = new ArrayList<String>();
                ipList.add(le.getIp());
                myMap.put(strDate,ipList);
            }
            else{
                ArrayList<String> ipCheckList = myMap.get(strDate);
                ipCheckList.add(le.getIp());
                myMap.put(strDate,ipCheckList);
            }
        }
        return myMap;
    }
    
    public String dayWithMostIPVisits(HashMap<String,ArrayList<String>> myMap){
        int max = 0;
        String day = "";
        for(String s:myMap.keySet()){
            if(myMap.get(s).size()>0){
                max = myMap.get(s).size();
                day = s;
            }
        }
        return day;
    }
    
    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String,ArrayList<String>> myMap,String day){
        ArrayList<String> ipList = new ArrayList<String>();
        ArrayList<String> resultList = new ArrayList<String>();
        HashMap<String,Integer> ipCountMap = new HashMap<String,Integer>();
        for(String s:myMap.keySet()){
            if(s.equals(day)){
                ipList = myMap.get(s);
                for(String ips:ipList){
                    if(!ipCountMap.containsKey(ips))
                        ipCountMap.put(ips,1);
                    else
                        ipCountMap.put(ips,ipCountMap.get(ips)+1);
                }
                //System.out.println("-----------------------------" + mostNumberVisitsByIP(ipCountMap));
                for(String key:ipCountMap.keySet())
                    if(ipCountMap.get(key) == mostNumberVisitsByIP(ipCountMap))
                        resultList.add(key);
             }
        }
        return resultList;
    }
}