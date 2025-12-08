import java.util.ArrayList;

public class Decoder3 {
    
    private ArrayList<String> rows;
    private long joltage;

    public Decoder3()
    {
        Parser3 parser=new Parser3();
        rows=parser.getrows();
        decodeTwelveDigits();
    }

    public void decodeTwoDigits() {
        System.out.println("////decoding started////");
        for(int i=0;i<rows.size();++i){
            System.out.println("\n////started decoding row:"+rows.get(i)+"////");
            ArrayList<String> row=parseRow(rows.get(i));
            int highestRight=0;
            int highestLeft=0;
            int highest=0;
            int highestPos=0;
            int highestRightPos=0;
            int highestLeftPos=0;
            boolean invalidRightFlag=false;
            //check highest
            for(int j=0;j<row.size()-1;++j){
                String candidateString=rows.get(i).charAt(j)+"";
                //System.out.println("  checking candidate: "+candidateString);
                int candidate=Integer.parseInt(candidateString);
                if(candidate>highest){
                    highest=candidate;
                    //System.out.println("    new highest: "+candidate+" (at "+j+")");
                    highestPos=j;
                }
            }
            System.out.println("highest found: "+highest+"(at "+highestPos+")");
            //check to right
            System.out.println("checking for highest to right");
            for(int k=highestPos+1;k<row.size()-1;++k){
                String rightHighestCandidateString=rows.get(i).charAt(k)+"";
                //System.out.println("  checking candidate: "+rightHighestCandidateString);
                int candidate=Integer.parseInt(rightHighestCandidateString);
                if(candidate>highestRight){
                    highestRight=candidate;
                    //System.out.println("    new highest: "+candidate+" (at "+k+")");
                    highestRightPos=k;
                }
            }
            if(highestRight==0)invalidRightFlag=true;
            if(invalidRightFlag){
                System.out.println("invalid right most number");
            }
            else{
                System.out.println("highest to right found: "+highestRight+"(at "+highestRightPos+")");
            }
            //check to left
            System.out.println("checking for highest to left");
            for(int l=highestPos-1;l>=0;--l){
                String leftHighestCandidateString=rows.get(i).charAt(l)+"";
                //System.out.println("  checking candidate: "+leftHighestCandidateString);
                int candidate=Integer.parseInt(leftHighestCandidateString);
                if(candidate>highestLeft){
                    highestLeft=candidate;
                    //System.out.println("    new highest: "+candidate+" (at "+l+")");
                    highestLeftPos=l;
                }
            }
            System.out.println("highest to left found: "+highestLeft+"(at "+highestLeftPos+")");
            //compare candidates
            int leftCandidate=Integer.parseInt(""+highestLeft+highest);
            System.out.println("joltage using left highest: "+leftCandidate);
            int rightCandidate=0;
            if(!invalidRightFlag){
                rightCandidate=Integer.parseInt(""+highest+highestRight);
                System.out.println("joltage using right highest: "+rightCandidate);
            }
            int specificJoltage=0;
            if(leftCandidate>rightCandidate){
                specificJoltage=leftCandidate;
            }
            else{
                specificJoltage=rightCandidate;
            }
            System.out.println("specific joltage from this row: "+specificJoltage);
            joltage+=specificJoltage;
            System.out.println("////finished decoding row:"+rows.get(i)+"////");
        }
        System.out.println("\n////decoding finished////");
        System.out.println("final joltage: "+joltage);
    }

    public void decodeTwelveDigits()
    {
        System.out.println("////decoding started////");
        for(int i=0;i<rows.size();++i){
            System.out.println("\n////started decoding row:"+rows.get(i)+"////");
            ArrayList<String> row=parseRow(rows.get(i));
            //search lowest
            do{
                int lowestCandidate=10;
                int lowestCandidatePos=-1;
                for(int j=0;j<row.size()-1;++j){
                    int currentLowestCandidate=Integer.parseInt(row.get(j));
                    if(currentLowestCandidate<lowestCandidate){
                        lowestCandidate=currentLowestCandidate;
                        lowestCandidatePos=j;
                    }
                }
                row.remove(lowestCandidatePos);
            }while(row.size()>12);
            String reducedBatteriesString="";
            for(int k=0;k<row.size();++k){
                reducedBatteriesString+=row.get(k);
            }
            long specificJoltage=0;
            System.out.println("reduced string("+reducedBatteriesString+")");
            specificJoltage=Long.parseLong(reducedBatteriesString);
            System.out.println("specific joltage from this row: "+specificJoltage);
            joltage+=specificJoltage;
            System.out.println("////finished decoding row:"+rows.get(i)+"////");
        }
        System.out.println("\n////decoding finished////");
        System.out.println("final joltage: "+joltage);
    }

    public ArrayList<String> parseRow(String inputRow) {
        ArrayList<String> row=new ArrayList<>();
        for(int charPointer=0;charPointer<inputRow.length();++charPointer){
            row.add(inputRow.charAt(charPointer)+"");
        }
        return row;
    }
}