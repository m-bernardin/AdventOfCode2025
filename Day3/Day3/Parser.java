package Day3;

import java.io.*;
import java.util.*;

public class Parser{
    private File input;
    private Scanner reader;
    private ArrayList<String> rows;

    public Parser(){
        setup();
        readInput();
    }

    public void readInput(){
        while(reader.hasNext()){
            String row = reader.next();
            rows.add(row);
        }
        System.out.println("//////array read-out//////");
        for(int i=0;i<rows.size();++i){
            System.out.println(rows.get(i));
        }
        System.out.println("//////array read out complete//////");
    }

    public void setup(){
        input=new File("Day3\\input.txt");
        if(input.exists()) System.out.println("File found");
        else
            try {
                System.out.println(input.getCanonicalPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        try {
            reader=new Scanner(input);
        } catch (FileNotFoundException e) {
            System.out.println("An exception occured");
            e.printStackTrace();
        }
        reader.useDelimiter("\n");
        rows=new ArrayList<String>();
    }

    public ArrayList<String> getrows(){
        return rows;
    }
}