//package com.example.demo.config;
//
//import org.apache.catalina.connector.Connector;
//import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
//import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @Auther 旷彬
// * @Date 2021/3/6
// */
//@Configuration
//public class PortConfig {
//    @Bean
//    public ServletWebServerFactory servletContainer() {
//        TomcatServletWebServerFactory tomcatServletWebServerFactory = new
//                TomcatServletWebServerFactory();
//        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//        connector.setPort(80);
//        tomcatServletWebServerFactory.addAdditionalTomcatConnectors(connector);
//        return tomcatServletWebServerFactory;
//    }
//}
