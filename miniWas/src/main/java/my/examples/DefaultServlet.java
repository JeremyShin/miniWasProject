package my.examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class DefaultServlet {
    public void service(Request request, Response response) {

        //응답하기
        String webpath = request.getPath();
        if("/".equals(webpath)) {
            webpath = webpath+ "index.html";
        }

        WasConfigurationManager wcm = WasConfigurationManager.getInstance();
        WasConfiguration wasConfiguration = wcm.getwasConfiguration("/home/jycs/m.json");
        String path = wasConfiguration.getStaticDir() + webpath;
        File file = new File(path);

        OutputStream out = response.getOut();
        PrintWriter pw = response.getPw();

        if(file.exists()) {
            pw.println("HTTP/1.1 200 OK");
            pw.println("Content-Type: text/html; charset=UTF-8");
            pw.println("Contnet-Length: "+ file.length());
            pw.println("");
            pw.flush();

            FileInputStream fis = null;
            try{
                fis = new FileInputStream(file);
                byte[] buffer = new byte[1024];
                int readCount = 0;
                while((readCount = fis.read(buffer)) != -1) {
                    out.write(buffer, 0, readCount);
                    out.flush();
                }

            }catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                // try{ out.close(); } catch (Exception ex) {}
                try{ fis.close();} catch (Exception ex) {}
            }

        }else{
            pw.println("HTTP/1.1 404 NOT FOUND");
            pw.println("Content-Type: text/html; charset=UTF-8");
            pw.println("");
            pw.flush();
        }


    }
}
