package ru.clevertec.util.yaml;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class YamlProperties {

    private YamlDatasourceProperties datasource;
    private YamlHibernateProperties hibernate;
}
