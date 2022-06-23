package project;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            FileReader x=new FileReader("name.txt");
            int data =x.read();
            while(data!=-1)
            {
                System.out.print((char)data);
                data =x.read();
            }
            x.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException z)
        {
            z.printStackTrace();
        }


    }
    }


