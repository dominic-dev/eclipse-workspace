import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static String PATH = "/home/dominic/Desktop/files.txt";

    public static void main(String[] args) {

        //File file = new File(PATH);
        //printFile(file);

        /*
        File directory = new File("/home/dominic/Books/");
        ArrayList<File> files = listFilesRecursively(directory);


        for(File f: files){
            System.out.println(f.getAbsolutePath() + " ~ " + meaningfullSize(f.length()));
        }
        System.out.println(files.size());

        File outputFile = new File(PATH);
        try {
            writeToFile(files, outputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        try {
            bin2Dec("00000001");
            bin2Dec("00000010");
            bin2Dec("00000011");
            bin2Dec("00000100");
            bin2Dec("00000101");
            bin2Dec("00000110");
            bin2Dec("00000111");
            bin2Dec("00001000");
            bin2Dec("00001001");
            bin2Dec("00001010");
            bin2Dec("a00001010");
        } catch (BinaryFormatException e) {
            e.printStackTrace();
        }

    }

    public static void printFile(File file){
        Scanner input;
        try {
            input = new Scanner(file);
            while(input.hasNext()){
                System.out.println(input.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(ArrayList<File> arrayList, String path) throws IOException {
        File file = new File(path);
        writeToFile(arrayList, file);
    }

    public static void writeToFile(ArrayList<File> arrayList, File file) throws IOException {
        if(file.exists()){
            throw new IOException("File already exists.");
        }
        try(PrintWriter  output = new PrintWriter(file)){
            for(File f : arrayList){
                output.println(f.getAbsolutePath() + " ~ " + meaningfullSize(f.length()));
            }
        }
    }

    public static String meaningfullSize(long bytes){
        String[] sizes = {"b", "kb", "mb", "gb"};
        for(int i=sizes.length; i>=0; i--){
            int factor = (int) Math.pow(2, 10 * (i));
            if(bytes < factor){
                continue;
            }
            return (int) (bytes / factor) + " " + sizes[i];
        }
        return "";
    }

    public static ArrayList<File> listFilesRecursively(File f){
        ArrayList<File> filelist = new ArrayList<>();
        if (f.isDirectory()){
            for(File childFile : f.listFiles()){
                ArrayList<File> childFiles = listFilesRecursively(childFile);
                filelist.addAll(childFiles);
            }
        }
        else{
            filelist.add(f);
        }
        return filelist;
    }

    public static int bin2Dec(String binary) throws BinaryFormatException{
           String pattern = "[0|1]+";
        if(!binary.matches(pattern)){
            throw new BinaryFormatException("This is not a binary string.");
        }
        System.out.println(binary);
        int result = 0;
        for(char c : binary.toCharArray()){
            int value = Character.getNumericValue(c);
            result = (result | value);
            result = result << 1;
        }
        result = result >>> 1;
        System.out.println(result);
        return result;
    }


}
