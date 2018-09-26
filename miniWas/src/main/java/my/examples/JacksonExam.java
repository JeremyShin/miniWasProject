package my.examples;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonExam {
    public static void main(String[] args) throws Exception{
        WasConfiguration wasConfiguration =
                new WasConfiguration();
        wasConfiguration.setStaticDir("/home/jycs/dev/resource");
        wasConfiguration.setClassPath(".");

        //객체를 json메시지로 변환한다.(직렬화한다.)
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonConfiguration =
                objectMapper.writeValueAsString(wasConfiguration);
        System.out.println(jsonConfiguration);

        // 역직렬화
        String jsonData = "{\"staticDir\":\"/home/jycs/dev/resource\",\"classPath\":\".\"}";
        WasConfiguration readObj =
                objectMapper.readValue(jsonData, WasConfiguration.class);
        System.out.println(readObj.getClassPath());
        System.out.println(readObj.getStaticDir());
    }
}
