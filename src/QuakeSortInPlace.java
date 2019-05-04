
/**
 * Write a description of class QuakeSortInPlace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class QuakeSortInPlace {
    public QuakeSortInPlace() {
        // TODO Auto-generated constructor stub
    }
   
    public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from) {
        int minIdx = from;
        for (int i=from+1; i< quakes.size(); i++) {
            if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
                minIdx = i;
            }
        }
        return minIdx;
    }
    
    public void sortByMagnitude(ArrayList<QuakeEntry> in) {
       
       for (int i=0; i< in.size(); i++) {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
        }
        
    }

    public int getLargestDepth(ArrayList<QuakeEntry> quakeData, int from){
        int maxIdx= from;
        for (int i=from+1;i<quakeData.size();i++){
        //for (int i=from+1;i<=70;i++){
            if (quakeData.get(i).getDepth() > quakeData.get(maxIdx).getDepth()){
                maxIdx = i;
            }
        }
        //returns int representing idx position of quake with largest depth from "from"
        return maxIdx;
    }

    public void sortByLargestDepth(ArrayList<QuakeEntry> in){

        //for (int i=0;i<in.size();i++){
        for (int i=0;i<=70;i++){
            int maxIdx=getLargestDepth(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qMax = in.get(maxIdx);
            in.set(i,qMax);
            in.set(maxIdx,qi);
        }
    }

    public void onePassBubbleSort(ArrayList<QuakeEntry> quakeData, int numSorted){
        for (int i=1;i<quakeData.size()-numSorted;i++){
            if(quakeData.get(i-1).getMagnitude() > quakeData.get(i).getMagnitude()){
                QuakeEntry qBefore = quakeData.get(i-1);
                QuakeEntry qi = quakeData.get(i);
                quakeData.set(i-1,qi);
                quakeData.set(i,qBefore);
            }
        }
    }

    public void sortByMagnitudeWithBubbleSort(ArrayList<QuakeEntry> in){
        for(int i=0;i<in.size()-1;i++){
            onePassBubbleSort(in,i);
            System.out.println("After Pass: "+i);
            for(QuakeEntry quake:in){
                System.out.println(quake);
            }

        }
    }

    public boolean checkInSortedOrder(ArrayList<QuakeEntry> quakes){
        for (int i=1;i<quakes.size();i++){
            if (quakes.get(i-1).getMagnitude() > quakes.get(i).getMagnitude()){
                return false;
            }
        }
        //return true if already sorted
        return true;
    }

    public int sortByMagnitudeWithBubblesWithCheck(ArrayList<QuakeEntry> in){
        int passes=1;
            for(int i=0;i<in.size()-1;i++){
                onePassBubbleSort(in,i);
                System.out.println("After Pass: "+i);
                if (checkInSortedOrder(in)==true){
                    passes=passes+i;
                    break;
                }

                for(QuakeEntry quake:in){
                    System.out.println(quake);
                }
            }
        //return number of passes before sorting is completed
        System.out.println("Passes: "+passes);
        return passes;
    }
    public int sortByMagnitudeWithWithCheck(ArrayList<QuakeEntry> in){
        int passes=1;
        for (int i=0; i< in.size(); i++) {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
            if (checkInSortedOrder(in)==true){
                passes=passes+i;
                break;
            }
        }
        //return number of passes before sorting is completed
        System.out.println("Passes: "+passes);
        return passes;
    }
    public void testSort() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = "EarthquakeSortStarterProgram/data/nov20quakedatasmall.atom";
        String source = "EarthquakeSortStarterProgram/data/earthQuakeDataWeekDec6sample2.atom";
        //String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
       
        System.out.println("read data for "+list.size()+" quakes");    
        //sortByMagnitude(list);
        sortByMagnitudeWithWithCheck(list);
        for (QuakeEntry qe: list) {
            System.out.println(qe);
        }
       // System.out.println(checkInSortedOrder(list));
        
    }

    public void testSortDepth() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = "EarthquakeSortStarterProgram/data/nov20quakedatasmall.atom";
        String source = "EarthquakeSortStarterProgram/data/earthQuakeDataDec6sample2.atom";
        //String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);

        System.out.println("read data for "+list.size()+" quakes");
        sortByLargestDepth(list);
        for (QuakeEntry qe: list) {
            System.out.println(qe);
        }

    /**    System.out.println("read data for sorted by Depth");
        sortByMagnitudeWithBubbleSort(list);
        for (QuakeEntry qe: list) {
            System.out.println(qe);
        }  */

    }

    public void testSortBubble() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = "EarthquakeSortStarterProgram/data/nov20quakedatasmall.atom";
        String source = "EarthquakeSortStarterProgram/data/earthQuakeDataWeekDec6sample1.atom";
        //String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);

        System.out.println("read data for "+list.size()+" quakes");
        //sortByMagnitudeWithBubbleSort(list);
        sortByMagnitudeWithBubblesWithCheck(list);
        for (QuakeEntry qe: list) {
            System.out.println(qe);
        }

    }

    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "EarthquakeSortStarterProgram/data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
    }
    
    public void dumpCSV(ArrayList<QuakeEntry> list) {
		System.out.println("Latitude,Longitude,Magnitude,Info");
		for(QuakeEntry qe : list){
			System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
			                  qe.getLocation().getLatitude(),
			                  qe.getLocation().getLongitude(),
			                  qe.getMagnitude(),
			                  qe.getInfo());
	    }
		
	}

    public static void main(String[] args){
        QuakeSortInPlace qsp = new QuakeSortInPlace();
        qsp.testSortBubble();

    }
}
