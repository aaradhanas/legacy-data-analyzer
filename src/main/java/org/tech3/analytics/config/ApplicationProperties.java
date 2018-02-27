package org.tech3.analytics.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to Blog.
 * <p>
 * Properties are configured in the application.yml file.
 * See {@link io.github.jhipster.config.JHipsterProperties} for a good example.
 */
@ConfigurationProperties(
    prefix = "application",
    ignoreUnknownFields = false
)
public class ApplicationProperties {

    private final ApplicationProperties.Proxy proxy = new ApplicationProperties.Proxy();

    public ApplicationProperties() {
    }

    public Proxy getProxy() {
        return proxy;
    }

    public static class Proxy{
        private final ApplicationProperties.Proxy.Kibana kibana = new ApplicationProperties.Proxy.Kibana();

        public Proxy() {}

        public Kibana getKibana() {
            return kibana;
        }

        public static class Kibana{
            private String servletUrl;
            private String targetUrl;
            private boolean loggingEnabled;
            private boolean authEnabled;
            private String basicAuth;

            public Kibana(){ }

            public String getServletUrl() {
                return servletUrl;
            }

            public void setServletUrl(String servletUrl) {
                this.servletUrl = servletUrl;
            }

            public String getTargetUrl() {
                return targetUrl;
            }

            public void setTargetUrl(String targetUrl) {
                this.targetUrl = targetUrl;
            }

            public boolean isLoggingEnabled() {
                return loggingEnabled;
            }

            public void setLoggingEnabled(boolean loggingEnabled) {
                this.loggingEnabled = loggingEnabled;
            }

            public boolean isAuthEnabled() {
                return authEnabled;
            }

            public void setAuthEnabled(boolean authEnabled) {
                this.authEnabled = authEnabled;
            }

            public String getBasicAuth() {
                return basicAuth;
            }

            public void setBasicAuth(String basicAuth) {
                this.basicAuth = basicAuth;
            }
        }
    }

}
