echo "Borkus boingus"
#create directory
mkdir DayX
cd DayX
#create classes
touch DriverX.java
touch ReaderX.java
touch DecoderX.java
#write basic classes
printf "public class DriverX {\npublic static void main(String[] args)\n\t{\n\t\t@SuppressWarnings("unused")\n\t\tDecoderX decoder = new DecoderX();\n\t}\n}" >>DriverX.java
printf 