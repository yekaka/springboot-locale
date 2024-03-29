package com.yvq.locale.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * 配置国际化语言
 *
 * @author yzq
 * @date 2019-07-26
 */
@Configuration
public class LocaleConfig implements WebMvcConfigurer{

	/**
	 * 默认解析器 其中locale表示默认语言
	 */
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	/**
	 * 默认拦截器 其中lang表示切换语言的参数名
	 */
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		//LocaleChangeInterceptor可以自己重写
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		// 参数名
		lci.setParamName("lang");
		return lci;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}
}
