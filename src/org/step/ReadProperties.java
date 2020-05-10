package org.step;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

public class ReadProperties {

    private static Map<String,Properties> properties = new HashMap<String, Properties>();

    public static String readPropertyKey(String path, String key){
        String result = "";
        InputStream input = null;
        try{
            Properties prop = new Properties();
            if(!properties.containsKey(path)){
                input = new FileInputStream(path);
            }else{
                prop = properties.get(path);
            }

            try {
                if(!properties.containsKey(path)) {
                    prop.load(input);
                }

                if(prop.getProperty(key)!=null){
                    properties.put(path,prop);
                    result = prop.getProperty(key);
                }else{
                    System.out.println("Ключа в данном файле не существует");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }catch (IOException e){
            System.out.println("Файла не существует");
        }
        return result;
    }
}
