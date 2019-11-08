package xyz.hos6dev.svgIcons.svgIconsApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This class holds the configuration bean for Swagger and also an optional augmentation of the Swagger Docket
 * (configuration bean) in the form of an ApiInfo object for defining things like the title, description, and license
 * for the API
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * @return a Docket object (the configuration bean for Swagger)
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiEndpointsInfo())
                .tags(
                        new Tag("sgvIcons API", "Operations pertaining to get files list to display")
                );
    }
    /**
     * This method returns an ApiInfo object with additional, but optional information about our API
     *
     * @return An ApiInfo object
     */
    private ApiInfo apiEndpointsInfo() {
        return new ApiInfoBuilder().title("sgvIcons API documentation")
                .description("Operations pertaining to get file list to display")
                .license("hos6dev")
                .version("1.0.0")
                .build();
    }
}
