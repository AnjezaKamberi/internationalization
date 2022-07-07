package com.engineering.discriminator.internationalization.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.engineering.discriminator.internationalization.dto.LanguageDTO;
import com.engineering.discriminator.internationalization.service.LanguageService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LanguageFilter implements Filter {

	private static final String LANGUAGE_HEADER = "X-LanguageID";
	private final LanguageService languageService;

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpServletRequest request = (HttpServletRequest) servletRequest;

		String languageHeader = request.getHeader(LANGUAGE_HEADER);

		if (languageHeader != null && !languageHeader.isEmpty()) {
			LanguageDTO registeredLanguage = languageService.getLanguageByCode(languageHeader);
			LanguageContext.setCurrentLanguage(registeredLanguage.getCode());
		} else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.setContentType(MediaType.APPLICATION_JSON_VALUE);
			response.getWriter().write("{\"error\": \"No language supplied\"}");
			response.getWriter().flush();
			return;
		}

		filterChain.doFilter(request, response);

	}

}
