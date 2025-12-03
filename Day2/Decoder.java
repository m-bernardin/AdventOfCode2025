package Day2;
import java.util.*;

public class Decoder {

    private Parser parser;
    private ArrayList<String> ranges;
    private int sum;

    public Decoder()
    {
        parser=new Parser();
        ranges=parser.getRanges();
    }

    public void decode()
    {
        for(int i=0;i<ranges.size();++i){
            String[] bounds=getBounds(ranges.get(i));
            String lowerBound=bounds[0];
            String upperBound=bounds[1];
        }
    }

    public String[] getBounds(String range) {
        
        return range.split(2d);
    }
}
