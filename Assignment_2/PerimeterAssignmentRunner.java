import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int count=0;
        for (Point p : s.getPoints())
            count++;
        return count;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double avgLen = getPerimeter(s) / getNumPoints(s);
        return avgLen;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        Point prevPt = s.getLastPoint();
        double maxDist = 0.0;
        for (Point curPt : s.getPoints()) {
            double curDist = prevPt.distance(curPt);
            if (curDist > maxDist)
                maxDist = curDist;
        }
        return maxDist;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double largeX = Double.NEGATIVE_INFINITY;
        for (Point p : s.getPoints()) {
            double curX = p.getX();
            if(curX > largeX)
                largeX = curX;
        }
        return largeX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double maxPerimeter=0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if (length > maxPerimeter)
                maxPerimeter = length;    
        }
        return maxPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null; // replace this code
        double maxPerimeter=0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if (length > maxPerimeter){
                maxPerimeter = length; 
                temp = f;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        /*System.out.println("No. of points = " + getNumPoints(s));
        System.out.println("Average Length = " + getAverageLength(s));
        System.out.println("Largest Side = " + getLargestSide(s));
        System.out.println("Biggest X point = " +getLargestX(s));*/
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double maxPeri = getLargestPerimeterMultipleFiles();
        System.out.println("Largest Perimeter = " + maxPeri);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String fileWithLargePerimeter = getFileWithLargestPerimeter();
        System.out.println("File With Largest Perimeter = " + fileWithLargePerimeter);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
