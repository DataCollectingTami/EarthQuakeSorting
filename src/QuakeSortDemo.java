
/**
 * Illustrate sorting
 * @author Duke Software 
 * @version 1.0
 */
import edu.duke.*;
import java.util.*;

public class QuakeSortDemo {
    
    public void testSort(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "EarthquakeSortStarterProgram/data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list);
        
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }
    }

    public static void main(String[] args){
        QuakeSortDemo qsd = new QuakeSortDemo();
        qsd.testSort();
    }
}