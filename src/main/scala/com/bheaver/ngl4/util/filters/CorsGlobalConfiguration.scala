package com.bheaver.ngl4.util.filters

import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.{CorsRegistry, EnableWebFlux, WebFluxConfigurer}

@Configuration
@EnableWebFlux
class CorsGlobalConfiguration extends WebFluxConfigurer{
  override def addCorsMappings(registry: CorsRegistry): Unit = {
    registry.addMapping("/**")
      .allowedOrigins("*")
      .allowedMethods("PUT","GET","POST","DELETE")
      .maxAge(3600);
  }
}
