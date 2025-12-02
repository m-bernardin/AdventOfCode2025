import java.util.*;

public class OperationDecoder{

    private OperationReader reader;
    private ArrayList<String> operations;
    private int pointer=50;
    private int count;

    public OperationDecoder(){
        reader = new OperationReader();
        operations=reader.getOperations();
        decodeInstructions();
    }

    public void turnLeft(int amnt){
        int turnAmnt=amnt%100;
        pointer-=turnAmnt;
        if(pointer==0)++count;
    }

    public void turnRight(int amnt){
        int turnAmnt=amnt%100;
        pointer+=turnAmnt;
        if(pointer==0)++count;
    }

    public void decodeInstructions(){ 
        for(int i=0;i<operations.size();++i){
            String operation=operations.get(i);
            //System.out.println(operation);
            System.out.println(operation.substring(1));
            int amnt=Integer.parseInt(operation.substring(1));
            char direction=operation.charAt(0);
            System.out.println(direction);
            System.out.println(amnt);
            if(direction=='L'){
                turnLeft(amnt);
            }
            else if(direction=='R'){
                turnRight(amnt);
            }
            
            System.out.println(pointer);
        }
        System.out.println("The code is: "+count);
    }
}