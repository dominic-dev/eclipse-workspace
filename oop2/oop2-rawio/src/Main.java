import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Main main = new Main();
        //main.writeRaw("/home/dominic/Desktop/raw.dat");
        //main.readRaw("/home/dominic/Desktop/nkz_model_secret.png");
        //main.writeSecret("Een goede morgen.", "/home/dominic/Desktop/nkz_model.bmp");
        //main.readSecret("/home/dominic/Desktop/nkz_model.bmp");
        //main.writePrimitive("/home/dominic/Desktop/raw_int.dat");
        //main.readPrimitive("/home/dominic/Desktop/raw_int.dat");
        //Circle c = new Circle(0, 0, 5.0);
        //main.writeCircle("/home/dominic/Desktop/circle.dat", c);
        //main.readCircle("/home/dominic/Desktop/circle.dat");
        byte b = (byte) 2;
        System.out.println(main.readBitsFromByte(b));
        b = main.setLastBit(b, 1);
        System.out.println(main.readBitsFromByte(b));
    }

    public void readSecret(String pathString){
        Path path = Paths.get(pathString);
        try {
            byte[] bytes = Files.readAllBytes(path);
            for(int i=0; i < bytes.length; i+=1000){
                System.out.println((char) bytes[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeSecret(String message, String pathString){
        Path path = Paths.get(pathString);
        try {
            byte[] bytes = Files.readAllBytes(path);
            for (int i=0; i < message.length(); i++) {
                bytes[i * 1000] = (byte) message.charAt(i);
                LOGGER.log(Level.INFO, String.valueOf(bytes[i * 1000]));
                
            }
            FileOutputStream fos = new FileOutputStream(pathString);
            fos.write(bytes);
            fos.close();
            //for(int i = 0; i < bytes.length; i++){
                //if (i % 1000 == 0){
                    //System.out.println(bytes[i]);
                //}
            //}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeRaw(String path){
        File output = new File(path);
        if (output.exists()){
            System.out.println("File exists.");
            System.out.println("Overwriting.");
        }
        
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(output);
            for (int i = 0; i < 500; i++) {
                fos.write(i);
            }
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public void readRaw(String path){
        FileInputStream fis;
        try {
            fis = new FileInputStream(path);
            int b = 0;
            while(true){
                b = fis.read();
                if (b == -1){
                    break;
                }
                System.out.println(b);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writePrimitive(String path){
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(path);
            DataOutputStream dos = new DataOutputStream(fos);
            for(int i=0; i<255; i++){
                dos.writeInt(i);
            }
            dos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readPrimitive(String path){
        try {
            FileInputStream fis = new FileInputStream(path);
            DataInputStream dis = new DataInputStream(fis);
            boolean eof = false;

            while(!eof){
                try {
                    int n = dis.readInt();
                    System.out.println(n);
                    
                } catch(EOFException e){
                    eof = true;
                }
            }
            dis.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }

    public void writeCircle(String filename, Circle c){
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(c);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }

    public void readCircle(String filename){
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream dis = new ObjectInputStream(fis);
            boolean eof = false;

            while(!eof){
                try {
                    Circle c = (Circle) dis.readObject();
                    System.out.println("Circle with radius: " + c.getRadius());
                    
                } catch(EOFException e){
                    eof = true;
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			 }
            dis.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readBitsFromByte(byte input){
        String result = "";
        for (int bit=7; bit>=0; bit--){
            int b = (input >>> bit) & 1;
            result += String.valueOf(b);
        }
        return result;
    }

    public byte setLastBit(byte input, int value){
        return (byte) ((input & 0xFE ) | value); 
    }

    public byte[] encryptMessage(byte[] data, String message){
        byte[] messageBytes = message.getBytes();
        if(data.length < messageBytes.length){
            throw new IllegalArgumentException("The data size is not big enough.");
        }
    
        return data;
    }

}
