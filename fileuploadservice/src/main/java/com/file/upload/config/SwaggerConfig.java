package com.file.upload.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI springOpenAPi() {
        return new OpenAPI()
                .info(new Info()
                        .title("FileUploadService").description("FUS")
                        .version("v1.0"));
    }
}
