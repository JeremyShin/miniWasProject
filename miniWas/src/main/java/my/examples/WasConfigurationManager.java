package my.examples;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class WasConfigurationManager {
    // 오브젝트 맵퍼 생성
    private ObjectMapper objectMapper;

    //싱글턴 패턴

    //2. 자기 자신을 참조하는 private static 변수를 선언한다.
    private static WasConfigurationManager instance =
            new WasConfigurationManager();

    //1. private 생성자를 만든다.
    private WasConfigurationManager() {
        objectMapper = new ObjectMapper();
    }

    //3. public static 한 메소드를 만든다. instance를 리턴하는..
    public static WasConfigurationManager getInstance() {
        return instance;
    }

    public void saveWasConfiguration(WasConfiguration wasConfiguration, String fileName)
            throws RuntimeException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(fileName), wasConfiguration);
        } catch (Exception ex) {
            throw new RuntimeException("파일 저장이 안됩니다.");
        }
    }

    public WasConfiguration getwasConfiguration(String fileName) {
        try {
            WasConfiguration readObj =
                    objectMapper.readValue(new File(fileName), WasConfiguration.class);
            return readObj;
        } catch (Exception ex) {
            return null;
        }
    }
}
