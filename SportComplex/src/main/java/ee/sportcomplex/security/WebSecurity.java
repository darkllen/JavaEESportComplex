package ee.sportcomplex.security;

import ee.sportcomplex.dto.Permissions;
import ee.sportcomplex.repos.users.AuthRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import ee.sportcomplex.services.users.UserLoginService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter {


    private final AuthRepo authRepo;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .authenticationProvider(authProvider())
                .authorizeRequests()
                .antMatchers("/favourites").authenticated()
                .antMatchers("/add_book").hasAuthority(Permissions.PermissionName.ADMIN.name())
                .anyRequest().permitAll()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable().cors();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new UserLoginService(authRepo);
    }
}
