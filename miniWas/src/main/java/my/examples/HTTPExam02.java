package my.examples;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class HTTPExam02 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();

        // 요청받기
        InputStream in = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String requestLine = br.readLine();
        System.out.println(requestLine);

        String headerLine = null;
        while((headerLine = br.readLine()) != null){
            if(headerLine.equals("")) break;
            System.out.println(headerLine);
        }

        LocalDateTime localDateTime = LocalDateTime.now();
        String str = localDateTime.toString();

        OutputStream out = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));

        pw.println("HTTP/1.1 200 OK");
        pw.println("Content-Type: text/html; charset=UTF-8");
        pw.println("Content-Length: " +str.length() );
        pw.println("");
        pw.flush();

        pw.print(str);
        pw.flush();

        in.close();
        out.close();

        socket.close();
        serverSocket.close();
    }
}
