package Day2;
import java.util.*;

public class Decoder1 {

    private Parser parser;
    private ArrayList<String> ranges;
    private long sum;

    public Decoder1()
    {
        parser=new Parser();
        ranges=parser.getRanges();
        decodeMultipleRepeat();
    }

    public void decodeMultipleRepeat()
    {
        System.out.println("\n//////////Decoding started//////////");
        String invalidIds="";
        for(int i=0;i<ranges.size();++i){
            System.out.println("\n////////new range////////");
            String[] bounds=getBounds(ranges.get(i));
            String lowerBound=bounds[0];
            String upperBound=bounds[1];
            System.out.println("lower bound: "+lowerBound+"\nupper bound: "+upperBound);
            int upperBoundLength=upperBound.length();
            for(long j=Long.parseLong(lowerBound);j<=Long.parseLong(upperBound);++j){
                String currentId=j+"";
                //System.out.println("\n  begin analyzing: "+j);
                    boolean invalidIdFoundFlag=false;
                    for(int k=1;k<=upperBoundLength/2;++k){
                        if(!invalidIdFoundFlag){
                            String idPortion=currentId.substring(0, k);
                            //System.out.println("    portion being analyzed: "+idPortion);
                            int portionLength=idPortion.length();
                            int currentIdLength=currentId.length();
                            int timesRepeatable=currentIdLength/portionLength;
                            //System.out.println("    times repeatable: "+timesRepeatable);
                            for(int l=1;l<timesRepeatable;++l){
                                int currentRepeats=l;
                                //System.out.println("      current repeat: "+currentRepeats);
                                String invalidIdCandidate="";
                                for(int m=0;m<=currentRepeats;++m){
                                    invalidIdCandidate+=idPortion;
                                    //System.out.println("        checking id: "+invalidIdCandidate);
                                    if(invalidIdCandidate.equals(currentId)){
                                        sum+=Long.parseLong(invalidIdCandidate);
                                        invalidIds+=invalidIdCandidate+",";
                                        invalidIdFoundFlag=true;
                                        System.out.println("        candidate is invalid\n      sum is now: "+sum);
                                    }
                                }
                            }
                        }
                    }
            }
            System.out.println("////////range completed////////\ntotal count: "+sum);
        }
        System.out.println("\n//////////analysis complete//////////\ntotal count: "+ sum+"\ninvalid Ids collected: "+invalidIds);
    }

        public void decodeSingleRepeat()
    {
        System.out.println("\n//////////Decoding started//////////");
        String invalidIds="";
        for(int i=0;i<ranges.size();++i){
            System.out.println("\n////////new range////////");
            String[] bounds=getBounds(ranges.get(i));
            String lowerBound=bounds[0];
            String upperBound=bounds[1];
            System.out.println("lower bound: "+lowerBound+"\nupper bound: "+upperBound);
            int upperBoundLength=upperBound.length();
            for(long j=Long.parseLong(lowerBound);j<=Long.parseLong(upperBound);++j){
                String currentId=j+"";
                //System.out.println("\n  begin analyzing: "+j);
                boolean invalidIdFoundFlag=false;
                for(int k=1;k<=upperBoundLength/2;++k){
                    if(!invalidIdFoundFlag){
                        String idPortion=currentId.substring(0, k);
                        //System.out.println("    portion being analyzed: "+idPortion);
                        String invalidIdCandidate="";
                        invalidIdCandidate=idPortion+idPortion;
                        //System.out.println("        checking id: "+invalidIdCandidate);
                        if(invalidIdCandidate.equals(currentId)){
                        sum+=Long.parseLong(invalidIdCandidate);
                        invalidIds+=invalidIdCandidate+",";
                        invalidIdFoundFlag=true;
                        System.out.println("        candidate is invalid("+invalidIdCandidate+")\n      sum is now: "+sum);
                        }
                    }
                }
            }
            System.out.println("////////range completed////////\ntotal count: "+sum);
        }
        System.out.println("\n//////////analysis complete//////////\ntotal count: "+ sum+"\ninvalid Ids collected: "+invalidIds);
    }

    public String[] getBounds(String range) {
        
        return range.split("-");
    }
}
