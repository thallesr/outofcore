package br.com.thallesr;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.Random;

public class Split {
    public static void main(String[] args) throws IOException {
        long milis = System.currentTimeMillis();
        try {
            String filename = args[0];
            String fileSizeStringKB = args[1];
            System.out.println();
            Integer fileSizeKB = Integer.valueOf(fileSizeStringKB);
            int[] memorySpace = new int[fileSizeKB * 256]; //    fileSizeKB * 1024 /4

            RandomAccessFile file = new RandomAccessFile(filename, "r");
            for (int i = 0; i < fileSizeKB / 4; i++) {
                memorySpace[i] = file.readInt();
            }
            System.out.println("Load Time: "+ (System.currentTimeMillis() - milis)+"ms");
            milis = System.currentTimeMillis();
            file.close();
            Arrays.sort(memorySpace);

            System.out.println("Sort Time: "+ (System.currentTimeMillis() - milis)+"ms");
            milis = System.currentTimeMillis();
            String fileOutput = "out1.data";
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileOutput));
            for (int value : memorySpace) {
                bos.write(ByteBuffer.allocate(4).putInt(value).array());
            }
            bos.flush();
            bos.close();

            System.out.println("Write Time: "+ (System.currentTimeMillis() - milis)+"ms");
        }
        catch (Exception e ){
            e.printStackTrace();

        }

    }
}
