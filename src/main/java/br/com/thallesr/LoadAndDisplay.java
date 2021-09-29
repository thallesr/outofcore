package br.com.thallesr;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class LoadAndDisplay {
    public static void main(String[] args) throws IOException {
        String filename = args[0];
        String fileSizeString = args[1];
        Integer fileSize = Integer.valueOf(fileSizeString);
        int[] memorySpace = new int[fileSize / 4];

        RandomAccessFile file = new RandomAccessFile(filename, "rw");
        for (int i = 0; i < fileSize / 4; i++) {
            memorySpace[i] = file.readInt();
            System.out.print(memorySpace[i]+" , ");
        }
        file.close();

    }
}
