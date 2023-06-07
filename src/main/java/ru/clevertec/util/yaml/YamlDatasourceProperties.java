package ru.clevertec.util.yaml;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class YamlDatasourceProperties {

    private String url;
    private String username;
    private String password;
    private String driver;
}
