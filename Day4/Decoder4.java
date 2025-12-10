import java.io.*;
import java.util.*;

public class Decoder4 {

    private Parser4 parser;
    private FileWriter writer;
    private ArrayList<String> rows;
    private ArrayList<String> columns;
    private int moveablePiles;
    private boolean noMoreMoveableFlag=false;

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
            while(!noMoreMoveableFlag){
                int pilesMoved=0;
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
                                    if(columnToCheck!=rows.size()&&columnToCheck!=-1){//was hardcoded to 11
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
                            if(currentColumn!=rows.size()-1&&rows.get(currentRow).charAt(currentColumn+1)=='@'){//was hardcoded to 10
                                ++surroundingPiles;
                                writer.write("\n      checked pile is paper, total piles surrounding: "+surroundingPiles);
                            }
                            //magic code to check piles on row below
                            if(currentRow!=columns.size()-1){//was hard coded to 9
                                writer.write("\n    checking lower row");
                                String lowerRow=rows.get(currentRow+1);
                                for(int i=0;i<3;++i){
                                    int columnToCheck=currentColumn-1+i;
                                    writer.write("\n      checking column: "+columnToCheck+", on row: "+lowerRow);
                                    char pileToCheck='0';
                                    if(columnToCheck!=columns.size()&&columnToCheck!=-1){//was hardcoded to 11
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
                                ++pilesMoved;
                                rows.set(currentRow, removePile(rows.get(currentRow), currentColumn));
                                columns.set(currentColumn, removePile(columns.get(currentColumn), currentRow));
                                writer.write("\n        pile found to be moveable");
                            }
                            //System.out.println("\n        current total: "+moveablePiles);
                        }
                    }
                }
                if(pilesMoved==0)noMoreMoveableFlag=true;
                System.out.println("loop complete, piles moved: "+pilesMoved+"\nnoMoreMoveableFlag state: "+noMoreMoveableFlag+"\n");
            }
            System.out.println("\n////////End Decoding////////");
            System.out.println("\nmoveable piles: "+moveablePiles);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public String removePile(String section, int position)
    {
        ArrayList<String> characterArray=new ArrayList<>();
        for(int i=0;i<section.length();++i){
            characterArray.add(section.charAt(i)+"");
        }
        characterArray.set(position, ".");
        String newSection="";
        for(int i=0;i<characterArray.size();++i){
            newSection+=characterArray.get(i);
        }
        return newSection;
    }
}