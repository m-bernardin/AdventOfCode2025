import java.util.*;

public class Decoder4 {

    private Parser4 parser;
    private ArrayList<String> rows;
    private ArrayList<String> columns;
    private int moveablePiles;

    public Decoder4()
    {
        parser=new Parser4();
        rows=parser.getRows();
        columns=parser.getColumns();
        decode();
    }

    public void decode()
    {
        for(int currentRow=0;currentRow<rows.size();++currentRow){
            for(int currentColumn=0;currentColumn<columns.size();++currentColumn){
                int surroundingPiles=0;
                //magic code to check piles on row above
                if(currentRow!=0){
                    System.out.println("checking upper row");
                    String upperRow=rows.get(currentRow-1);
                    for(int i=0;i<3;++i){
                        int columnToCheck=currentColumn-1+i;
                        System.out.println("checking column: "+columnToCheck+", on row: "+upperRow);
                        char pileToCheck=upperRow.charAt(columnToCheck);
                        if(pileToCheck=='@'){
                            ++surroundingPiles;
                        }
                    }
                }
                //magic code to check adjacent piles
                if(currentColumn!=0&&rows.get(currentRow).charAt(currentColumn-1)=='@'){
                    ++surroundingPiles;
                }
                if(currentColumn!=10&&rows.get(currentRow).charAt(currentColumn+1)=='@'){
                    ++surroundingPiles;
                }
                //magic code to check piles on row below
                if(currentRow!=10){
                    System.out.println("checking lower row");
                    String lowerRow=rows.get(currentRow+1);
                    for(int i=0;i<3;++i){
                        int columnToCheck=currentColumn-1+i;
                        System.out.println("checking column: "+columnToCheck+", on row: "+lowerRow);
                        char pileToCheck='0';
                        if(columnToCheck!=11||columnToCheck!=-1){
                            pileToCheck=lowerRow.charAt(columnToCheck);
                        }
                        if(pileToCheck=='@'){
                            ++surroundingPiles;
                        }
                    }
                }
                if(surroundingPiles<4){
                    ++moveablePiles;
                }
            }
        }
        System.out.println("moveable piles: "+moveablePiles);
    }
}