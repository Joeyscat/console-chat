package fun.oook.webchat.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ZhouYu
 * @version 1.0.0
 * @since 2020/4/28
 */
@Slf4j
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/console").hasAnyRole("admin", "user")
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login")
                .loginProcessingUrl("/user/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler((request, response, authentication) -> {
                    response.setContentType("application/text;charset=utf-8");
                    response.setStatus(HttpStatus.OK.value());
                    final PrintWriter writer = response.getWriter();
                    writer.print("{msg:success}");
                    log.info(authentication.getName());
//                    request.getRequestDispatcher("/console").forward(request,response);
                })
                .failureHandler((request, response, exception) -> {
                    response.setContentType("application/text;charset=utf-8");
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    final PrintWriter writer = response.getWriter();
                    writer.print("{msg:fail}");
                })
                .permitAll()
                .and().logout().logoutUrl("/logout")
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        final PrintWriter writer = response.getWriter();
                        writer.write("logout success");
                        writer.flush();
                    }
                })
                .permitAll()
                .and().httpBasic()
                .and().csrf()
                .disable();
    }

    @Override
    public void configure(final WebSecurity web) throws Exception {
        web.debug(true);
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Joeyscat").roles("admin").password("$2a$10$k0AAwaGJq6mXtXvSOMWtgekMcC4xoKMrM9F5oWB34gGxLjfF.wuRW")//$2a$10$jxCWd3BYQj3nX2CFHFyuiu2jGKWckq8OY4q1sYSs./Z5HEZZ7kiQO
                .and()
                .withUser("user").roles("user").password("$2a$10$p1H8iWa8I4.CA.7Z8bwLjes91ZpY.rYREGHQEInNtAp4NzL6PLKxi");
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
