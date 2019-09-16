package com.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
//扫描Elasticsearch的dao加入到spring容器
@EnableElasticsearchRepositories(basePackages = "com.api.es")
public class ShoppingCommodityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCommodityApplication.class, args);
	}

}
