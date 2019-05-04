import java.util.Comparator;

public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry> {
public int compare(QuakeEntry qe1, QuakeEntry qe2){
String qe1Last = qe1.getInfo().substring(qe1.getInfo().lastIndexOf(" ")+1);
String qe2Last = qe2.getInfo().substring(qe2.getInfo().lastIndexOf(" ")+1);

if (qe1Last.compareTo(qe2Last)>0){
    return 1;
}
else if (qe1Last.compareTo(qe2Last)<0){
    return -1;
}
else{
    return Double.compare(qe1.getMagnitude(),qe2.getMagnitude());
}
}

}
