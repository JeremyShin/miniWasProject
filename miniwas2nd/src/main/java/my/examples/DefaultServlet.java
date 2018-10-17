package my.examples;

public class DefaultServlet {
    public void service(Request request, Response response) {
        //응답하기.
        String webpath = request.getPath();
        if("/".equals(webpath)) {
            webpath = webpath + "index.html";
        }

        WasConfigurationManager wcm = WasConfigurationManager.getInstance();

    }
}
