package doit.myself;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Handler extends Thread{
    Socket socket = null;

    public Handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream in = null;
        BufferedReader br = null;

        OutputStream out = null;
        PrintWriter pw = null;

    }
}
