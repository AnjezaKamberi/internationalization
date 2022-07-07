package com.engineering.discriminator.internationalization.config;

public class LanguageContext {

	private static ThreadLocal<String> currentLanguage = new ThreadLocal<>();

	public static String getCurrentLanguage() {
		return currentLanguage.get();
	}

	public static void setCurrentLanguage(String language) {
		currentLanguage.set(language);
	}

}
