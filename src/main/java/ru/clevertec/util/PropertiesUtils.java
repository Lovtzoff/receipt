package ru.clevertec.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.IOException;
import java.io.InputStream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PropertiesUtils {

    private static final Yaml YAML = new Yaml(new Constructor(YamlProperties.class));
    private static YamlProperties yamlProperties;

    static {
        loadProperties();
    }

    public static YamlProperties getYamlProperties() {
        return yamlProperties;
    }

    private static void loadProperties() {
        try (InputStream inputStream = PropertiesUtils.class.getClassLoader()
                .getResourceAsStream("jdbcTemplate.yml")) {
            yamlProperties = YAML.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Properties file not found!");
        }
    }
}
