package doit.myself;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Connector {

    public void run() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try{
            while(true) {
                socket = serverSocket.accept();
                Handler handler = new Handler(8888);
                handler.start();

            }


        }catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
