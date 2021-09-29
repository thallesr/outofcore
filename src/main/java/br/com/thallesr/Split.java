package br.com.thallesr;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.Random;

public class Split {
    public static void main(String[] args) throws IOException {
        String filename = args[0];
        String fileSizeString = args[1];
        Integer fileSize = Integer.valueOf(fileSizeString);
        int[] memorySpace = new int[fileSize / 4];

        RandomAccessFile file = new RandomAccessFile(filename, "rw");
        for (int i = 0; i < fileSize / 4; i++) {
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
}
