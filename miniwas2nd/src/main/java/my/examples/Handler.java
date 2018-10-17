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

            // 1동적프로그램일경우.
            //request, response를이용하여무엇을할까?
            //path정보에해당하는프로그램이있는지확인한다.
            //ex: /today--> TodayServlet이실행한결과를출력.

            //2.동적프로그램이아닐경우.
            //path에해당하는파일이있는지찾아본다.
            //있으면해당파일의내용을보여주고, 없으면404오류를출력한다.
            DefaultServlet defaultServlet = new DefaultServlet();
            defaultServlet.service(request, response);


            //close
            in.close();
            out.close();;
            socket.close();

        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
