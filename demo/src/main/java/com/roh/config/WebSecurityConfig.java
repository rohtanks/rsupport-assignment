package com.roh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.roh.service.MemberServiceImpl;

// 클래스 설정하면 스프링 시큐리티가 제공하는 기본 설정을 덮어 씀
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	MemberServiceImpl service;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2console/**");
	}
	
	/**
	 * http 요청 처리에 대한 설정
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		super.configure(http);
		
		// 경로 권한 및 인증 설정
		// 요청별 어떻게 보안을 걸어줄지
		http.authorizeRequests()
		// 모두에게 응답
				.antMatchers("/", "/boards", "/members/regist", "/resources/**").permitAll()
				.antMatchers("/boards/post").hasRole("USER")
				.antMatchers(HttpMethod.PUT).hasRole("USER")
				.antMatchers(HttpMethod.DELETE, "/boards/{bno}").hasRole("USER")
		// 이외의 요청에 인증을 할 수 있도록
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/members/login")
				.defaultSuccessUrl("/boards")
				.permitAll()
				.and()
			.logout()
				.logoutSuccessUrl("/boards")
				.permitAll();
		
		// post method 테스트를 위해
		http.csrf()
				.disable();
	}
	
	/**
	 * 패스워드 인코딩 설정
	 * 평문으로 저장 위한 NoOpPasswordEncoder
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return NoOpPasswordEncoder.getInstance();
	}
	
	/**
	 * 패스워드 인코딩 설정
	 * 
	 * @return
	 */
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		
//		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	}
	
	/**
	 * 인메모리 테스트용도
	 * UserDetailsService 는 MemberService 가 구현해서 사용
	 */
//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//		// 스프링 시큐리티의 User가 가지고 있는 핵심 속성들
//		// 암호화는 제외함
//		// UserDetails 라는 추상화한 인터페이스에 유저 도메인을 변환해 줘야함
//		UserDetails user = 
//				User.builder()
//				.username("user")
//				.password("password")
//				.roles("USER")
//				.build();
//		
//		return new InMemoryUserDetailsManager(user);
//	}
	
}