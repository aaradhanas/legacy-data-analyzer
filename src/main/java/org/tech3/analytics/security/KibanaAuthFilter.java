package org.tech3.analytics.security;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Vidhyadharan
 * <p>
 * 27-Feb-2018
 */
public class KibanaAuthFilter extends GenericFilterBean {


    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws
            IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //Add authentication & role check
        chain.doFilter(req, resp);
    }

    /**
     * Find a specific HTTP cookie in a request.
     *
     * @param request The HTTP request object.
     * @param name    The cookie name to look for.
     * @return The cookie, or <code>null</code> if not found.
     */
    protected Cookie getCookieByName(HttpServletRequest request, String name) {
        if (request.getCookies() == null) {
            return null;
        }
        for (int i = 0; i < request.getCookies().length; i++) {
            if (request.getCookies()[i].getName().equals(name)) {
                return request.getCookies()[i];
            }
        }
        return null;
    }

    @Override
    public void destroy() {
        //nothing
    }
}
