package Day3;
import java.util.ArrayList;

public class Decoder {
    
    private ArrayList<String> rows;
    private int joltage;

    public Decoder()
    {
        Parser parser=new Parser();
        rows=parser.getrows();
        decode();
    }

    public void decode() {
        System.out.println("////decoding started////");
        for(int i=0;i<rows.size();++i){
            System.out.println("\n////started decoding row:"+rows.get(i)+"////");
            ArrayList<String> row=parseRow(rows.get(i));
            String highest="";
            String rightHighest="";
            String leftHighest="";
            int highestInt;
            int rightHighestInt;
            int leftHighestInt;
            int currentHighestCandidate = 0;
            for(int j=0;j<row.size();++j){
                String candidateString=rows.get(i).charAt(j)+"";
                int candidate=Integer.parseInt(candidateString);
                if(candidate>currentHighestCandidate){
                    currentHighestCandidate=candidate;
                }
            }
            System.out.println("highest found: "+highest);
        }
    }

    public ArrayList<String> parseRow(String inputRow) {
        ArrayList<String> row=new ArrayList<>();
        for(int charPointer=0;charPointer<inputRow.length();++charPointer){
            row.add(inputRow.charAt(charPointer)+"");
        }
        return row;
    }
}