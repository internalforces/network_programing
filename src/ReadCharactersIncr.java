import java.io.*;

class ReadCharactersIncr {
    static int size =0;
    static int bufferSize=80;
    static byte buffer[] = new byte[bufferSize];
    public static void main(String[] args) throws java.io.IOException {
        try {
            int dataRead;
            while((dataRead=System.in.read(buffer,size,bufferSize-size))>=0) {
                size+=dataRead;
                if(size==bufferSize)
                    increaseBufferSize();
            }
            System.out.write(buffer,0,size);
        }catch(IOException e) {
            System.err.println("스트림으로부터 데이터를 읽을 수 없습니다.");
        }
    }
    static void increaseBufferSize() {
        bufferSize+=80;
        byte[] newBuffer=new byte[bufferSize];
        System.arraycopy(buffer, 0, newBuffer, 0, size);
        buffer = newBuffer; // buffer 배열이 크기가 80개 늘어난다.
    }
}