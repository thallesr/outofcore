package br.com.thallesr;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.Random;

public class Split {
    public static void main(String[] args) throws IOException {
        try {
            String filename = args[0];
            String fileSizeStringKB = args[1];
            Integer fileSizeKB = Integer.valueOf(fileSizeStringKB);
            int[] memorySpace = new int[fileSizeKB * 256]; //    fileSizeKB * 1024 /4

            RandomAccessFile file = new RandomAccessFile(filename, "r");
            for (int i = 0; i < fileSizeKB / 4; i++) {
                memorySpace[i] = file.readInt();
            }
            file.close();
            Arrays.sort(memorySpace);

            String fileOutput = "out1.data";
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileOutput));
            for (int value : memorySpace) {
                bos.write(ByteBuffer.allocate(4).putInt(value).array());
            }
            bos.flush();
            bos.close();
        }
        catch (Exception e ){
            e.printStackTrace();

        }

    }
}
