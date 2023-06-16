package com.example.i18n.filters;

import com.example.i18n.config.LocaleConfig;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Locale;

/**
 * @author Paul
 * 
 */
@Component
public class LocaleFilter extends OncePerRequestFilter {
	
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String localeHeader = request.getHeader("Accept-Language");
        if (localeHeader != null) {
            LocaleConfig.GLOBAL_LOCALE = new Locale(localeHeader);
        }
        filterChain.doFilter(request, response);
    }
}
