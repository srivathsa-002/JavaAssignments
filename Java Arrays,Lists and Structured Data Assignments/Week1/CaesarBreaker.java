public class CaesarBreaker
{
    public int[] countLetters(String msg)
    {
        // put your code here
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int[] counts= new int[26];
        for(int k=0;k<msg.length();k++){
            char ch=Character.toLowerCase(msg.charAt(k));
            int index=alpha.indexOf(ch);
            if(index!=-1)
                counts[index]+=1;
        }
        return counts;
    }
    
    public int maxIndex(int[] vals){
        int maxInd = 0;
        for(int i=0;i<vals.length;i++)
            if(vals[i]>vals[maxInd])
                maxInd = i;
        return maxInd;
    }
    
    public String decrypt(String encrypted){
        CaesarCipher cc = new CaesarCipher();
        //String message = cc.encrypt(encrypted, 26 - key);
        int[] freq = countLetters(encrypted);
        int maxInd = maxIndex(freq);
        int key = maxInd-4;
        if(maxInd<4)
            key=26-(4-maxInd);
        return cc.encrypt(encrypted,26-key);
        
        //
    }
    
    public void eyeball(String encrypted){
        CaesarCipher cipher=new CaesarCipher();
        for(int k=0;k<26;k++){
            String s=cipher.encrypt(encrypted,k);
            System.out.println(k+"\t"+s);
        }
    }
    
    public void testDecrypt(){
        //String result = decrypt("Mjqqt");
        //System.out.println("Decrypted: " + result);
        //eyeball("Mjqqt");
        //System.out.println(halfOfString("Lgpns M eo Uek Uvkzcxjwc",1));
        System.out.println(halfOfString("Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu",0));
        System.out.println(halfOfString("Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu",1));
        System.out.println(decryptTwoKeys("Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu"));
    }
    
    public String halfOfString(String message,int start){
        StringBuilder sb = new StringBuilder(message);
        String result="";
        StringBuilder sb1=new StringBuilder(result);
        //result.append(sb.charAt(start));
        if(start%2==0){
            for(int i=start;i<message.length();i++)
                if(i%2==0)
                    sb1.append(sb.charAt(i));
        }
        else{
            for(int j=start;j<message.length();j++)
                if(j%2==1)
                    sb1.append(sb.charAt(j));
        }
        return sb1.toString();
    }
    
    public int getKey(String s){
        int[] freq=countLetters(s);
        int dex=maxIndex(freq);
        int key = dex-4;
        if(dex<4)
            key=26-(4-dex);
        return key;
    }
    
    public String decryptTwoKeys(String encrypted){
        String half1=halfOfString(encrypted,0);
        String half2=halfOfString(encrypted,1);
        int key1=getKey(half1);
        int key2=getKey(half2);
        System.out.println("key1: "+key1);
        System.out.println("key2: "+key2);
        CaesarCipher cc=new CaesarCipher();
        String res=cc.encryptTwoKeys(encrypted,26-key1,26-key2);
        return res;
    }
}