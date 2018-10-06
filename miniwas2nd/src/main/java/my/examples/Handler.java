package my.examples;

import java.io.*;
import java.net.Socket;

public class Handler extends Thread{

    private Socket socket;

    public Handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            //요청받기.
            InputStream in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            OutputStream out = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));

            Request request = new Request(in, br);
            Response response = new Response(out, pw);

            String path = request.getPath();


            //close
            in.close();
            out.close();;
            socket.close();

        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
