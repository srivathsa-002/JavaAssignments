import java.util.Date;
public class LogEntry
{
    private String ip;
    private Date time;
    private String request;
    private int status;
    private int bytes;
    public LogEntry(String ip,Date time,String request,int status,int bytes)
    {
        this.ip=ip;
        this.time=time;
        this.request=request;
        this.status=status;
        this.bytes=bytes;
    }
    public String getIp(){
        return ip;
    }
    public Date getTime(){
        return time;
    }
    public String getRequest(){
        return request;
    }
    public int getStatus(){
        return status;
    }
    public int getBytes(){
        return bytes;
    }
    @Override
    public String toString(){
        return ip+" "+time+" "+request+" "+status+" "+bytes;
    }
}
