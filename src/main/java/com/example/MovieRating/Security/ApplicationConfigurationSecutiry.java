package com.example.MovieRating.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ApplicationConfigurationSecutiry extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsServiceObject;

    AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProviderObject = new DaoAuthenticationProvider();
        authenticationProviderObject.setPasswordEncoder(passwordEncoder());
        authenticationProviderObject.setUserDetailsService(userDetailsServiceObject);
        return authenticationProvider();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors().disable();
        http.authorizeRequests()
                .antMatchers("/").permitAll()

//               For Movie
                .antMatchers("/FindAll").hasAuthority("user")
                .antMatchers("/displayByID/{id}").hasAuthority("admin")
                .antMatchers("/deleteByID/{id}").hasAuthority("admin")
                .antMatchers("/update/{id}").hasAuthority("admin")
                .antMatchers("/deleteAll").hasAuthority("admin")

//               For Comments & Rate
                .antMatchers("/addComment").hasAuthority("user")
                .antMatchers("/FindAllComment").hasAnyAuthority("user","manager")
                .antMatchers("/displayCommentByID/{id}").hasAnyAuthority("user","admin","manager")
                .antMatchers("/deleteCommentByID/{id}").hasAnyAuthority("admin","manager")
                .anyRequest().authenticated().and().httpBasic();
    }
}
