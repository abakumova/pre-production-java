package com.viktoriia_abakumova.task12.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/hospital/*");
    }

    @Bean(name = "soap_qa_task_hospital")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema hospitalSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("hospitalPort");
        wsdl11Definition.setLocationUri("/hospital");
        wsdl11Definition.setTargetNamespace("http://soaphomework/qa");
        wsdl11Definition.setSchema(hospitalSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema hospitalSchema() {
        return new SimpleXsdSchema(new ClassPathResource("soap_qa_task_hospital.xsd"));
    }
}