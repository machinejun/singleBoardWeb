package com.singboardWeb.singleweb.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class KakaoProfileDto {

	private long id;
	private String connectedAt;
	private Properties properties;
	private KakaoAccount kakaoAccount;
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public class Properties{
		private String nickname;

	}
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
	public class KakaoAccount{
		private Boolean profileNicknameNeedsAgreement;
		private Boolean hasEmail;
		private Boolean emailNeedsAgreement;
		private Boolean isEmailValid;
		private Boolean isEmailVerifiedTrue;
		private String email;
	}
	
}
