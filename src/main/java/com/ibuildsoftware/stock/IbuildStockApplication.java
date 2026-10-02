package com.ibuildsoftware.stock;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Locale;
import java.util.TimeZone;

@SpringBootApplication
@EnableAsync
@EnableCaching
@EnableScheduling
@EnableTransactionManagement
@EntityScan(basePackages = "com.ibuildsoftware.stock.model")
@EnableJpaRepositories(basePackages = "com.ibuildsoftware.stock.repository")
@ComponentScan(basePackages = "com.ibuildsoftware")
public class IbuildStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(IbuildStockApplication.class, args);
	}

	@Bean(name = "cacheManager")
	public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("cacheIbuildStock");
	}

	@PostConstruct
	private void configTimeZone() {
		Locale.setDefault(Locale.US);
		TimeZone.setDefault(TimeZone.getTimeZone("America/New_York"));
	}

}
