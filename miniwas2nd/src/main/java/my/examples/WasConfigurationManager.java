package my.examples;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class WasConfigurationManager {

    //싱글턴패턴.
    private ObjectMapper objectMapper;

    //2.자기자신을참조하는privateStatic변수를선언한다.
    //static한변수는딱한번초기화되고,메모리에딱한번만올라간다.
    private static WasConfigurationManager instance = new WasConfigurationManager();

    //1.private생성자를만든다.
    public WasConfigurationManager() {
        this.objectMapper = objectMapper;
    }

    //3.pubulic static한메소드를만든다.instance를리턴하는.
    public static WasConfigurationManager getInstance() {
        return instance;
    }

    public void saveMiniWasConfiguration(MiniWasConfiguration miniWasConfiguration, String fileName)
        throws RuntimeException {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(fileName), miniWasConfiguration);
        }catch (Exception ex) {
            throw new RuntimeException("파일저장이안됩니다!");
        }
    }

    public MiniWasConfiguration getMiniWasConfiguration(String fileName) {
        try{
            MiniWasConfiguration readObj =
                    objectMapper.readValue(new File(fileName), MiniWasConfiguration.class);
            return readObj;
        }catch (Exception ex) {
            return null;
        }
    }
}
