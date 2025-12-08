import java.io.*;
import java.util.*;

public class Decoder4 {

    private Parser4 parser;
    private FileWriter writer;
    private ArrayList<String> rows;
    private ArrayList<String> columns;
    private int moveablePiles;

    public Decoder4()
    {
        parser=new Parser4();
        File log=new File("Day4\\log.txt");
        try {
            writer=new FileWriter(log);
        } catch (IOException e) {
            e.printStackTrace();
        }
        rows=parser.getRows();
        columns=parser.getColumns();
        decode();
    }

    public void decode()
    {
        try{
            writer.write("\n\n\n\n////////Begin decoding////////");
            for(int currentRow=0;currentRow<rows.size();++currentRow){
                writer.write("\n////Begin checking row: "+rows.get(currentRow)+"////");
                for(int currentColumn=0;currentColumn<columns.size();++currentColumn){
                    int surroundingPiles=0;
                    if(columns.get(currentColumn).charAt(currentRow)!='.'){
                        //magic code to check piles on row above
                        if(currentRow!=0){
                            writer.write("\n    checking upper row");
                            String upperRow=rows.get(currentRow-1);
                            for(int i=0;i<3;++i){
                                int columnToCheck=currentColumn-1+i;
                                writer.write("\n      checking column: "+columnToCheck+", on row: "+upperRow);
                                char pileToCheck='0';
                                if(columnToCheck!=11&&columnToCheck!=-1){
                                    pileToCheck=upperRow.charAt(columnToCheck);
                                    //writer.write("\n      checking pile: "+pileToCheck);
                                }
                                if(pileToCheck=='@'){
                                    ++surroundingPiles;
                                    writer.write("\n      checked pile is paper, total piles surrounding: "+surroundingPiles);
                                }
                            }
                        }
                        //magic code to check adjacent piles
                        if(currentColumn!=0&&rows.get(currentRow).charAt(currentColumn-1)=='@'){
                            ++surroundingPiles;
                            writer.write("\n      checked pile is paper, total piles surrounding: "+surroundingPiles);
                        }
                        if(currentColumn!=10&&rows.get(currentRow).charAt(currentColumn+1)=='@'){
                            ++surroundingPiles;
                            writer.write("\n      checked pile is paper, total piles surrounding: "+surroundingPiles);
                        }
                        //magic code to check piles on row below
                        if(currentRow!=9){
                            writer.write("\n    checking lower row");
                            String lowerRow=rows.get(currentRow+1);
                            for(int i=0;i<3;++i){
                                int columnToCheck=currentColumn-1+i;
                                writer.write("\n      checking column: "+columnToCheck+", on row: "+lowerRow);
                                char pileToCheck='0';
                                if(columnToCheck!=11&&columnToCheck!=-1){
                                    pileToCheck=lowerRow.charAt(columnToCheck);
                                    writer.write("\n      checking pile: "+pileToCheck);
                                }
                                if(pileToCheck=='@'){
                                    ++surroundingPiles;
                                    writer.write("\n      checked pile is paper, total piles surrounding: "+surroundingPiles);
                                }
                            }
                        }
                        if(surroundingPiles<4){
                            ++moveablePiles;
                            writer.write("\n        pile found to be moveable");
                        }
                        writer.write("\n        current total: "+moveablePiles);
                    }
                }
            }
            writer.write("\n////////End Decoding////////");
            writer.write("\nmoveable piles: "+moveablePiles);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}