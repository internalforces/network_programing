import java.io.*;

class ReadCharactersIncr {
    static int size = 0;
    static int bufferSize = 80;
    static byte buffer[] = new byte[bufferSize];

    public static void main(String[] args) throws IOException {
        try {
            int dataRead;
            while ((dataRead = System.in.read(buffer, size, bufferSize - size)) >= 0) {
                size += dataRead;
                if (size == bufferSize)
                    increaseBufferSize();
            }
            System.out.write(buffer, 0, size);
        } catch (IOException e) {
            System.err.println("스트림으로부터 데이터를 읽을 수 없습니다.");
        }
    }

    static void increaseBufferSize() {
        bufferSize += 80;
        byte[] newBuffer = new byte[bufferSize];
        copyArray(buffer, 0, newBuffer, 0, size);
        buffer = newBuffer;
    }

    static void copyArray(byte[] src, int srcPos, byte[] dest, int destPos, int length) {
        for (int i = 0; i < length; i++) {
            dest[destPos + i] = src[srcPos + i];
        }
    }
}