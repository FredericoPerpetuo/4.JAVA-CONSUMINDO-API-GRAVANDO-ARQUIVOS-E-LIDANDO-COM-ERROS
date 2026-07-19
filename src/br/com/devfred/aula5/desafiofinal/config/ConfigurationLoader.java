package br.com.devfred.aula5.desafiofinal.config;

import br.com.devfred.aula5.desafiofinal.exception.FalhaConfiguracaoException;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class ConfigurationLoader {
    private final String urlBase;
    private final Duration connectTimeout;
    private final Duration readTimeout;

    public ConfigurationLoader() {
        Properties properties = new Properties();
        try(FileInputStream configuracoes =
                    new FileInputStream("src/br/com/devfred/aula5/desafiofinal/resources/application.properties")){
            properties.load(configuracoes);
            this.urlBase = properties.getProperty("url.base");
            this.connectTimeout = Duration.ofSeconds(Integer.parseInt(properties.getProperty("timeout.connect.seconds")));
            this.readTimeout = Duration.ofSeconds(Integer.parseInt(properties.getProperty("timeout.read.seconds")));
        } catch (IOException e) {
            throw new FalhaConfiguracaoException("Falha ao carregar configurações: " + e.getMessage());
        }
    }

    public String getUrlBase() {
        return urlBase;
    }

    public Duration getConnectTimeout() {
        return connectTimeout;
    }

    public Duration getReadTimeout() {
        return readTimeout;
    }
}
