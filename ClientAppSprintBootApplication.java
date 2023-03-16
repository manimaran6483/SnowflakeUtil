package com.client.app;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bsc.snow.flake.model.SnowflakeProperties;
import com.bsc.snow.flake.service.SnowflakeTemplate;

@SpringBootApplication
public class ClientAppSprintBootApplication {

	@Value("${snowflake.url}")
	private String URL;
	
	@Value("${snowflake.account.identifier}")
	private String accountIdentifier;
	
	@Value("${snowflake.account.user}")
	private String accountUser;
	
	@Value("${snowflake.private.key.path}")
	private String privateKey;
	
	@Value("${snowflake.public.key.path}")
	private String publicKey;
	
	public static void main(String[] args) {
		SpringApplication.run(ClientAppSprintBootApplication.class, args);
	}

	@Bean
	public SnowflakeTemplate snowFlakeServiceImpl() {
		SnowflakeProperties properties = new SnowflakeProperties();
		properties.setAccountIdentifier(accountIdentifier);
		properties.setPrivateKey(privateKey);
		properties.setPublicKey(publicKey);
		properties.setURL(URL);
		properties.setUser(accountUser);
		SnowflakeTemplate template = new SnowflakeTemplate(properties);
		return template;
		
	}
	
}
