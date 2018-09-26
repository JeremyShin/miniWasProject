package my.examples;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPExam01 {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();

        InputStream in = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String requestLine = br.readLine();
        System.out.println(requestLine);
        System.out.println();

        String headerLine = null;
        while((headerLine=br.readLine())!=null){
            if(headerLine.equals("")) break;
            System.out.println(headerLine);
        }

        //응답하기

        File file = new File("/home/jycs/dev/index.html");

        OutputStream out = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
        pw.println("HTTP/1.1 200 OK");
        pw.println("Content-Type: text/html; charset=UTF-8");
        pw.println("Content-Length: " + file.length());
        pw.println("");

        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[1024];
        int readCount = 0;
        while((readCount=fis.read(buffer)) != -1) {
            out.write(buffer, 0, readCount);
            out.flush();
        }
        fis.close();
        in.close();
        out.close();

        socket.close();
        serverSocket.close();
    }
}
