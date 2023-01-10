package br.com.thallesr;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

/**
 * Hello world!
 */
public class Populate {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        String sizeInKb = args[1];
        Integer KBs = Integer.valueOf(sizeInKb);
        byte[] barray = new byte[1024];
        ByteBuffer b = ByteBuffer.wrap(barray);
        RandomAccessFile file;
        file = new RandomAccessFile(fileName, "w");
        FileChannel channel = file.getChannel();
        Random r = new Random();
        for (int s = 0; s < KBs; s++) {
            for (int i = 0; i < 256; i++) { //256 * 4 bytes -> 1KByte
                b.putInt(r.nextInt());

            }
            b.flip();
            channel.write(b);
            b.flip();
        }
        channel.close();
        file.close();

    }

}
