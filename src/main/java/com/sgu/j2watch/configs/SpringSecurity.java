package com.sgu.j2watch.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.sgu.j2watch.serviceImpl.CustomUserDetailService;
import com.sgu.j2watch.services.AccountService;


@Configuration
@EnableWebSecurity
public class SpringSecurity {
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	
	
//	@SuppressWarnings("removal")
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((auth) -> auth
                		.requestMatchers("/home/thongtin/**").hasAuthority("Khách hàng")
                        .requestMatchers("/home/**").permitAll()
                        .requestMatchers("/js/**").permitAll()
                        .requestMatchers("/css/**").permitAll()
                        .requestMatchers("/img/**").permitAll()
                        
                        .requestMatchers("/admin/qltaikhoan/**", "/admin/qlquyen/**").hasAnyAuthority("Admin", "Giám sát ca")
                        .requestMatchers("/admin/**").hasAnyAuthority("Admin", "Nhân viên bán hàng", "Giám sát ca")
//                 
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/home/dangnhap")
                        .loginProcessingUrl("/home/dangnhap")
                        .usernameParameter("user_name")
                		.passwordParameter("password")
                        .defaultSuccessUrl("/home", true)
//                        .failureUrl("/home/dangnhap")
                        .permitAll()
                )
                .logout((logout) -> logout
                		.permitAll()
				        .deleteCookies("remove")
				        .logoutUrl("/dangxuat")
				        .logoutSuccessUrl("/home")
				        .invalidateHttpSession(true));
//                .exceptionHandling().accessDeniedPage("/home");
        return http.build();
    }
	
	@Autowired
	private CustomUserDetailService customUserDetailService;


	
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
	}

}
