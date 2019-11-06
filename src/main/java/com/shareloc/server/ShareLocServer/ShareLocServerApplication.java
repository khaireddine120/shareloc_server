package com.shareloc.server.ShareLocServer;

import com.shareloc.server.ShareLocServer.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class ShareLocServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShareLocServerApplication.class, args);
	}

}
