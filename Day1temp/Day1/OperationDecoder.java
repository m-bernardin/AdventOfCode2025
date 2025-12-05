package Day1;
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
        if(amnt>100)count+=amnt/100;
        boolean zeroStartFlag=false;
        if(pointer==0)zeroStartFlag=true;
        pointer-=turnAmnt;
        boolean overflowFlag=false;
        if(pointer<0){pointer=100+pointer;if(!zeroStartFlag)overflowFlag=true;}
        if(pointer>99){pointer=pointer-100;overflowFlag=true;}
        if(overflowFlag)++count;
        if(pointer==0)++count;
    }

    public void turnRight(int amnt){
        int turnAmnt=amnt%100;
        if(amnt>100)count+=amnt/100;
        boolean zeroStartFlag=false;
        if(pointer==0)zeroStartFlag=true;
        pointer+=turnAmnt;
        boolean exactitudeFlag=false;
        if(pointer==100){
            count++;
            exactitudeFlag=true;
            pointer=0;
        }
        boolean overflowFlag=false;
        if(pointer<0){pointer=100+pointer;if(!zeroStartFlag)overflowFlag=true;}
        if(pointer>99){pointer=pointer-100;overflowFlag=true;}
        if(overflowFlag)++count;
        if(pointer==0&&!exactitudeFlag)++count;
    }

    public void decodeInstructions(){ 
        for(int i=0;i<operations.size();++i){
            String operation=operations.get(i);
            System.out.println("\n////new operation////");
            System.out.println("operation string: "+operation);
            System.out.println("operation substring: "+operation.substring(1)+"string length: "+operation.length());
            int amnt=Integer.parseInt(operation.substring(1,operation.length()));
            char direction=operation.charAt(0);
            //System.out.println(direction);
            //System.out.println(amnt);
            if(direction=='L'){
                turnLeft(amnt);
            }
            else if(direction=='R'){
                turnRight(amnt);
            }
            System.out.println("count: "+count);
            System.out.println("pointer: "+pointer);
        }
        System.out.println("\n////Decoding complete////");
        System.out.println("The code is: "+count);
    }
}