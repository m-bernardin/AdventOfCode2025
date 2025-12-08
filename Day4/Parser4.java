import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser4 {
    private File input;
    private Scanner reader;
    private ArrayList<String> rows;
    private ArrayList<String> columns;

    public Parser4(){
        setup();
        readRows();
        readColumns();
    }

    public void readRows(){
        while(reader.hasNext()){
            String row = reader.next();
            rows.add(row);
        }
        System.out.println("//////rows read-out//////");
        for(int i=0;i<rows.size();++i){
            System.out.println(rows.get(i));
        }
        System.out.println("/////rows read out complete/////");
    }

    public void setup(){
        input=new File("Day4\\test4.txt");
        if(input.exists()) System.out.println("File found");
        else{
            try {
                System.out.println(input.getCanonicalPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            reader=new Scanner(input);
            System.out.println("scanner created");
        } catch (FileNotFoundException e) {
            System.out.println("An exception occured");
            e.printStackTrace();
        }
        reader.useDelimiter("\n");
        rows=new ArrayList<String>();
        columns=new ArrayList<String>();
        }

    public void readColumns()
    {
        for(int i=0;i<rows.size();++i){
            String column="";
            for(int j=0;j<10;++j){
                column+=(rows.get(j).charAt(i)+"");
            }
            columns.add(column);
        }
        System.out.println("//////columns read-out//////");
        for(int i=0;i<columns.size();++i){
            System.out.println(columns.get(i));
        }
        System.out.println("/////columns read out complete/////");
    }

    public ArrayList<String> getRows(){
        return rows;
    }

    public ArrayList<String> getColumns()
    {
        return columns;
    }
}