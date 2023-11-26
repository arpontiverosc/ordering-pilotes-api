package com.tui.ordering.pilotes.out.jpa.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;


@Configuration
@Getter
@Setter
@ConfigurationProperties(prefix = "configuration")
public class ConfigProperties {

	private Integer minutes;
	private List<Integer> pilotesPossibleValue;
	private Double pilotePrice;

}
