package bussiness.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AuthConfig{
    private static final Properties props = new Properties();

    static {
        try (InputStream input = AuthConfig.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                throw new RuntimeException("Not found file auth.properties!");
            }
            props.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Error while reading auth.properties", e);
        }
    }

    public static String getUrl() {
        return props.getProperty("db.url");
    }

    public static String getUsername() {
        return props.getProperty("db.username");
    }

    public static String getPassword() {
        return props.getProperty("db.password");
    }
}
