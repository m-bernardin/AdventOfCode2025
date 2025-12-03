package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
    private File input;
    private Scanner reader;
    private ArrayList<String> ranges;

    public Parser(){
        setup();
        readInput();
    }

    public void readInput(){
        while(reader.hasNext()){
            String range = reader.next();
            ranges.add(range);
        }
        System.out.println("//////array read-out//////");
        for(int i=0;i<ranges.size();++i){
            System.out.println(ranges.get(i));
        }
        System.out.println("/////array read out complete/////");
    }

    public void setup(){
        input=new File("Day2\\test.txt");
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
        reader.useDelimiter(",");
        ranges=new ArrayList<String>();
    }

    public ArrayList<String> getRanges(){
        return ranges;
    }

}
