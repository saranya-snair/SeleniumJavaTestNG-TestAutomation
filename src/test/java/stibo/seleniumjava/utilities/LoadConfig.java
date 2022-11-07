package stibo.seleniumjava.utilities;
import java.util.Properties;

public class LoadConfig {

    private final Properties prop;
    private static LoadConfig LoadConfig;
    private LoadConfig(){
        prop= PropertyUtils.propertyLoader("src/test/resources/ProjectProperties.properties");
    }
    public static LoadConfig getInstance(){
        if(LoadConfig == null){
            LoadConfig = new LoadConfig();
        }
        return LoadConfig;
    }
    public String getBaseUrl(){
        String url = prop.getProperty("baseUrl");
        if(url != null) return url;
        else throw new RuntimeException("Base url not found in config file");
    }
}
