package Day1;
import java.io.*;
import java.util.*;

public class OperationReader{
    private File input;
    private Scanner reader;
    private ArrayList<String> operations;

    public OperationReader(){
        setup();
        readInput();
    }

    public void readInput(){
        while(reader.hasNext()){
            String op = reader.next();
            operations.add(op);
            //System.out.println(op);
        }
        System.out.println("//////array read-out//////");
        for(int i=0;i<operations.size();++i){
            System.out.println(operations.get(i));
        }
        System.out.println("/////array read out complete/////");
    }

    public void setup(){
        input=new File("Day1\\Day1\\input.txt");
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
        operations=new ArrayList<String>();
    }

    public ArrayList<String> getOperations(){
        return operations;
    }
}



