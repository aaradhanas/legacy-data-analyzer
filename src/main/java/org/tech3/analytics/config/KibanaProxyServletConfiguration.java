package org.tech3.analytics.config;

import org.apache.http.HttpRequest;
import org.mitre.dsmiley.httpproxy.ProxyServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class KibanaProxyServletConfiguration{


    private final Logger log = LoggerFactory.getLogger(KibanaProxyServletConfiguration.class);

    private final ApplicationProperties applicationProperties;

    public KibanaProxyServletConfiguration(ApplicationProperties applicationProperties){
        this.applicationProperties = applicationProperties;
    }

    @Bean
    public ServletRegistrationBean kibanaServletRegistrationBean(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new ProxyServlet(){
            @Override
            protected void copyRequestHeaders(HttpServletRequest servletRequest, HttpRequest proxyRequest) {

                String method = servletRequest.getMethod();
                log("The requested method = " + method);
                if(applicationProperties.getProxy().getKibana().isAuthEnabled()) {
                    proxyRequest.addHeader("Authorization", applicationProperties.getProxy().getKibana().getBasicAuth());
                }

                super.copyRequestHeaders(servletRequest, proxyRequest);
            }
        }, applicationProperties.getProxy().getKibana().getServletUrl());
        servletRegistrationBean.addInitParameter("targetUri", applicationProperties.getProxy().getKibana().getTargetUrl());
        servletRegistrationBean.addInitParameter(ProxyServlet.P_LOG, String.valueOf(applicationProperties.getProxy().getKibana().isLoggingEnabled()));
        return servletRegistrationBean;
    }
}
