#echo "////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////"
#echo "================================================================================================================================================================================"
#echo "////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////"
#echo " ######  ########  ########    ###    ######## #### ##    ##  ######         ###       ##    ## ######## ##      ##    ########     ###    ##      ## ##    ##             "
#echo "##    ## ##     ## ##         ## ##      ##     ##  ###   ## ##    ##       ## ##      ###   ## ##       ##  ##  ##    ##     ##   ## ##   ##  ##  ## ###   ##             "
#echo "##       ##     ## ##        ##   ##     ##     ##  ####  ## ##            ##   ##     ####  ## ##       ##  ##  ##    ##     ##  ##   ##  ##  ##  ## ####  ##             "
#echo "##       ########  ######   ##     ##    ##     ##  ## ## ## ##   ####    ##     ##    ## ## ## ######   ##  ##  ##    ##     ## ##     ## ##  ##  ## ## ## ##             "
#echo "##       ##   ##   ##       #########    ##     ##  ##  #### ##    ##     #########    ##  #### ##       ##  ##  ##    ##     ## ######### ##  ##  ## ##  ####             "
#echo "##    ## ##    ##  ##       ##     ##    ##     ##  ##   ### ##    ##     ##     ##    ##   ### ##       ##  ##  ##    ##     ## ##     ## ##  ##  ## ##   ###   ###   ###   ### "
#echo " ######  ##     ## ######## ##     ##    ##    #### ##    ##  ######      ##     ##    ##    ## ########  ###  ###     ########  ##     ##  ###  ###  ##    ##   ###   ###   ### "
figlet DayMaker -f broadway
figlet "Creating a New Dawn" -f banner3
#create directory
mkdir Day$1
cd Day$1
#create classes
touch Driver$1.java
touch Parser$1.java
touch Decoder$1.java
echo "Java files created"
#write basic classes
printf 'public class Driver%d {\npublic static void main(String[] args)\n\t{\n\t\t@SuppressWarnings("unused")\n\t\tDecoder%d decoder = new Decoder%d();\n\t}\n}' $1 $1 $1 >>Driver$1.java
echo "Driver class written"
printf 'import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser%d {
    private File input;
    private Scanner reader;
    private ArrayList<String> ranges;

    public Parser%d(){
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
        input=new File("Day%d''\\\''input%d.txt");
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
        reader.useDelimiter("%s");
        ranges=new ArrayList<String>();
        }

    public ArrayList<String> getRanges(){
        return ranges;
    }
}' $1 $1 $1 $1 $2>>Parser$1.java
echo "Parser class written"
printf 'import java.util.*;

public class Decoder%d {

    private Parser%d parser;
    private ArrayList<String> ranges;

    public Decoder%d()
    {
        parser=new Parser%d();
        ranges=parser.getRanges();
        decode();
    }

    public void decode()
    {
        System.out.println("Test decode done!");
    }
}' $1 $1 $1 $1 >>Decoder$1.java
echo "Decoder class written"
touch test$1.txt
echo "Test file created"