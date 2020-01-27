import edu.duke.*;
public class Part4
{
    public void find() {
        URLResource url = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for (String word : url.lines()) {
                String testWord = word.toLowerCase();
                int index = testWord.indexOf("youtube.com");
                if(index > 0){
                    int startIndex = word.lastIndexOf("\"",index);
                    int endIndex = word.indexOf("\"",index);
                    System.out.println(word.substring((startIndex + 1),endIndex));
                }
        }
    }
}