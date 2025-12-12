import java.util.*;

public class Decoder6 {

    private Parser6 parser;
    private ArrayList<String> ranges;

    public Decoder6()
    {
        parser=new Parser6();
        ranges=parser.getRanges();
        decode();
    }

    public void decode()
    {
        System.out.println("Test decode done!");
    }
}