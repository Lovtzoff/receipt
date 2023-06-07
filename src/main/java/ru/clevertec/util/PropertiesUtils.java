package ru.clevertec.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import ru.clevertec.util.yaml.YamlProperties;

import java.io.IOException;
import java.io.InputStream;

/**
 * Класс, содержащий методы для получения свойств из yml-файла.
 *
 * @author Lovtsov Aliaksei
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PropertiesUtils {

    private static final Yaml YAML = new Yaml(new Constructor(YamlProperties.class));
    private static YamlProperties yamlProperties;

    static {
        loadProperties();
    }

    /**
     * Получить свойства из yml-файла.
     *
     * @return the yaml properties
     */
    public static YamlProperties getYamlProperties() {
        return yamlProperties;
    }

    private static void loadProperties() {
        try (InputStream inputStream = PropertiesUtils.class.getClassLoader()
                .getResourceAsStream("application.yml")) {
            yamlProperties = YAML.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Properties file not found!");
        }
    }
}
