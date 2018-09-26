package my.examples;

import java.io.BufferedReader;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Request {
    private InputStream in  = null;
    private BufferedReader br = null;
    private Map<String, String> headers = null;
    private String method;
    private String path;

    public Request(InputStream in, BufferedReader br) {
        this.in = in;
        this.br = br;
        headers = new HashMap<>();

        try {
            String requestLine = br.readLine();
            String[] split = requestLine.split(" ");
            if(split.length > 2) {
                method = split[0];
                path = split[1];
            }

            String headerLine = null;
            while((headerLine = br.readLine()) != null) {
                if(headerLine.equals("")) break;

                int idx1 = headerLine.indexOf(":");
                String headerKey = null;
                String headerValue = null;

                if(idx1 != -1){
                    headerKey = headerLine.substring(0, idx1);
                    headerValue = headerLine.substring(idx1+1);
                }
                headers.put(headerKey, headerValue);
            }

        }catch (Exception ex) {
            throw new RuntimeException("잘못된 요청 : "+ ex.toString());
        }finally {
            try { in.close(); } catch (Exception e) {}
            try { br.close(); } catch (Exception e) {}
        }
    }

    public InputStream getIn() {
        return in;
    }

    public BufferedReader getBr() {
        return br;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }
    public String getUserAgent() {
        return headers.get("User-Agent");
    }
    public String getCookie() {
        return headers.get("Cookie");
    }
    public String getAccept() {
        return headers.get("Accept");
    }
}
