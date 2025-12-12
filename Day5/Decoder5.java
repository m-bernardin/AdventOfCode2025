import java.util.*;

public class Decoder5 {

    private Parser5 parser;
    private ArrayList<String> lines;
    private ArrayList<String> ranges=new ArrayList<>();
    private ArrayList<String> ids=new ArrayList<>();
    private int freshFruits;

    public Decoder5()
    {
        parser=new Parser5();
        lines=parser.getLines();
        decodePt2();
    }

    public void decodePt1()
    {
        sort();
        for(int currentIdPos=1;currentIdPos<ids.size();++currentIdPos){
            boolean idConfirmedFlag=false;
            //System.out.println("checking id: "+ids.get(currentIdPos));
            long currentId=Long.parseLong(ids.get(currentIdPos).trim());
            for(int currentRangePos=0;currentRangePos<ranges.size()&&!idConfirmedFlag;++currentRangePos){
                ArrayList<Long> rangeBounds=decodeRange(ranges.get(currentRangePos));
                long rangeBegin=rangeBounds.get(0);
                long rangeEnd=rangeBounds.get(1);
                // System.out.println("start decoding range: "+rangeBegin+"-"+rangeEnd);
                // System.out.println("Checking id " + currentId);
                boolean inRange=((currentId>=rangeBegin)&&(currentId<=rangeEnd));
                //System.out.println("current ID: " + currentId + " vs. Range End: " + rangeEnd);
                // System.out.println("\nUpper bound met:  " + (currentId<=rangeEnd));
                // System.out.println("Lower bound met:  " + (currentId>=rangeBegin));
                if(inRange){
                    ++freshFruits;
                    System.out.println("id found to be valid: "+currentId);
                    idConfirmedFlag=true;
                }
            }

            idConfirmedFlag=true;
            //System.out.println("id checked: "+currentId+"\ncurrent total fresh fruits: "+freshFruits+"\n");
        }
        System.out.println("decoding complete, fresh fruits: "+freshFruits);
    }

    public void decodePt2()
    {
        sort();
        HashSet<Long> validIds=new HashSet<>();
        for(int currentRangePos=0;currentRangePos<ranges.size();++currentRangePos){
            ArrayList<Long> rangeBounds=decodeRange(ranges.get(currentRangePos));
            long rangeBegin=rangeBounds.get(0);
            long rangeEnd=rangeBounds.get(1);
            for(long currentId=rangeBegin;currentId<=rangeEnd;++currentId){
                System.out.println("id valid: "+currentId);
                validIds.add(currentId);
            }
        }
        System.out.println("fresh ids: "+validIds.size());
    }

    public void sort()
    {
        for(int i=0;i<lines.size();++i){
            if(lines.get(i).contains("-")){
                ranges.add(lines.get(i));
            }
            else{
                ids.add(lines.get(i));
            }
        }
    }

    public ArrayList<Long> decodeRange(String range)
    {
        int splitPoint=range.indexOf("-");
        System.out.println("Range: " + range);
        long rangeBegin=Long.parseLong(range.substring(0, splitPoint));
        System.out.println("begginning of range: "+rangeBegin);
        long rangeEnd=Long.parseLong(range.substring(splitPoint+1,range.length()));
        System.out.println("end of range: "+rangeEnd);
        ArrayList<Long> bounds=new ArrayList<>();
        bounds.add(rangeBegin);
        bounds.add(rangeEnd);
        return bounds;
    }
}