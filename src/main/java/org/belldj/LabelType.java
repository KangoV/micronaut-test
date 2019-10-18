package org.belldj;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum LabelType {
	@JsonProperty("client")
	CLIENT, 
	@JsonProperty("site")
	SITE, 
	@JsonProperty("game")
	GAME, 
	@JsonProperty("channel")
	CHANNEL; 
}