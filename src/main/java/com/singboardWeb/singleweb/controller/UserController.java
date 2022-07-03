package com.singboardWeb.singleweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.singboardWeb.singleweb.dto.KakaoProfileDto;
import com.singboardWeb.singleweb.dto.KakaoTokenDto;
import com.singboardWeb.singleweb.model.RoleType;
import com.singboardWeb.singleweb.model.RootType;
import com.singboardWeb.singleweb.model.User;
import com.singboardWeb.singleweb.service.UserService;

@Controller
public class UserController {
	@Value("${kakao.key}")
	private String kPassword;

	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@GetMapping("/auth/loginform")
	public String loginForm() {
		System.out.println("hello");
		return "user/login_form";
	}
	
	@GetMapping("/auth/joinform")
	public String joinForm() {
		System.out.println("hello");
		return "user/join_form";
	}
	
	@PostMapping("/auth/joinProc")
	public String joinUser( User user){
		user.setOauth(RootType.Normal);
		User reponseUser = userService.saveUser(user);
		return "redirect:/";
	}
	
	@GetMapping("/user/logout")
	public String logout() {
		httpSession.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/oauth/kakao/callback")
	public String loginFromKaKao(@RequestParam String code) {
		KakaoTokenDto tokenDto = getKakaoCode(code);
		KakaoProfileDto kakaUserProfile = getKakaoUserProfile(tokenDto.getAccessToken());
		loginKakaoUser(kakaUserProfile);
		System.out.println("SSSSSSS");
		return "redirect:/";
	}
	
	private KakaoTokenDto getKakaoCode(String code) {
		RestTemplate message = new RestTemplate();
		HttpHeaders header = new HttpHeaders();
		header.add("Content-type", KakaoDefine.formType);
		
		MultiValueMap<String, String> parameter = new LinkedMultiValueMap<>();
		parameter.add("grant_type", KakaoDefine.grantType);
		parameter.add("client_id", KakaoDefine.restApiKey);
		parameter.add("redirect_uri", KakaoDefine.redirectUri);
		parameter.add("code", code);
		
		HttpEntity<MultiValueMap<String, String>> kakaoRequest = new HttpEntity<>(parameter, header);
		ResponseEntity<KakaoTokenDto> response 
				= message.exchange(KakaoDefine.tokenUri, HttpMethod.POST, kakaoRequest, KakaoTokenDto.class);
		return response.getBody();
	}
	
	
	private KakaoProfileDto getKakaoUserProfile(String accessToken) {
		RestTemplate message = new RestTemplate();
		HttpHeaders header = new HttpHeaders();
		header.add("Authorization", "Bearer "+ accessToken);
		
		HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest = new HttpEntity<>(header);
		ResponseEntity<KakaoProfileDto> kakaoProfileRes = message.exchange(KakaoDefine.profileUri, HttpMethod.POST,
				kakaoProfileRequest, KakaoProfileDto.class);
		return kakaoProfileRes.getBody();
	}
	
	private void loginKakaoUser(KakaoProfileDto profileDto) {
		User user = User.builder()
				.username(profileDto.getProperties().getNickname() + "_" + profileDto.getId())
				.password("1234")
				.email(profileDto.getKakaoAccount().getEmail())
				.role(RoleType.User)
				.oauth(RootType.Kakao)
				.build();
		System.out.println(user);
		userService.saveKakaoUser(user);
		System.out.println("DDDDDDD");
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), "1234"));
		System.out.println("ddddddddd");
		SecurityContextHolder.getContext().setAuthentication(authentication);
		System.out.println("aaaaaaaaaa");
		
	}
	


}
