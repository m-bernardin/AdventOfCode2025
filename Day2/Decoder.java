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
        decode();
    }

    public void decode()
    {
        System.out.println("\n////Decoding started////");
        for(int i=0;i<ranges.size();++i){
            System.out.println("\n////new range////");
            String[] bounds=getBounds(ranges.get(i));
            String lowerBound=bounds[0];
            String upperBound=bounds[1];
            System.out.println("lower bound: "+lowerBound+"\nupper bound: "+upperBound);
            int upperBoundLength=upperBound.length();
            for(int j=Integer.parseInt(lowerBound);j<=Integer.parseInt(upperBound);++j){
                String currentId=j+"";
                System.out.println("\n  begin analyzing: "+j);
                for(int k=1;k<=upperBoundLength/2;++k){
                    String idPortion=currentId.substring(0, k);
                    System.out.println("    portion being analyzed: "+idPortion);
                }
            }
        }
    }

    public String[] getBounds(String range) {
        
        return range.split("-");
    }
}
