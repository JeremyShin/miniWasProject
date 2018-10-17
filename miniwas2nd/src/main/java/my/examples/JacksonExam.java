package my.examples;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonExam {
    public static void main(String[] args) throws Exception{
        MiniWasConfiguration miniWasConfiguration =
                new MiniWasConfiguration();
        miniWasConfiguration.setStaticDir("/home/jycs/dev/");
        miniWasConfiguration.setClassPath(".");

        //객체를json메시지로변환한다.(직렬화한다)
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonConfiguration =
                objectMapper.writeValueAsString(miniWasConfiguration);
        System.out.println(jsonConfiguration);
        System.out.println("--");
        String jsonData = "{\"staticDir\":\"/home/jycs/dev/\",\"classPath\":\".\"}";
        MiniWasConfiguration readObj = objectMapper.readValue(jsonData, MiniWasConfiguration.class);
        System.out.println(readObj.getClassPath());
        System.out.println(readObj.getStaticDir());
    }
}
