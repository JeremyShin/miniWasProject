package my.examples;

import java.io.OutputStream;
import java.io.PrintWriter;

public class DefaultServlet {
    Request request;
    Response response;

    public DefaultServlet(Request request, Response response) {
        this.request = request;
        this.response = response;
    }

    OutputStream out = response.getOut();
    PrintWriter pw = response.getPw();

    //pw.println("")
}
