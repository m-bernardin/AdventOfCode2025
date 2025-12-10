import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser5 {
    private File input;
    private Scanner reader;
    private ArrayList<String> lines;

    public Parser5(){
        setup();
        readInput();
    }

    public void readInput(){
        while(reader.hasNext()){
            String line = reader.next();
            lines.add(line);
        }
        System.out.println("//////array read-out//////");
        for(int i=0;i<lines.size();++i){
            System.out.println(lines.get(i));
        }
        System.out.println("/////array read out complete/////");
    }

    public void setup(){
        input=new File("Day5\\test5(2).txt");
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
        } catch (FileNotFoundException e) {
            System.out.println("An exception occured");
            e.printStackTrace();
        }
        reader.useDelimiter("\n");
        lines=new ArrayList<String>();
        }

    public ArrayList<String> getLines(){
        return lines;
    }
}