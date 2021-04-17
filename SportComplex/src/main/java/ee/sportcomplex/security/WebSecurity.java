package ee.sportcomplex.security;

import ee.sportcomplex.dto.Permissions;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import ee.sportcomplex.repos.UserRepo;
import ee.sportcomplex.services.UserService;

@RequiredArgsConstructor
@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private final UserRepo userRepository;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
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
    @Override
    protected UserDetailsService userDetailsService() {
        return new UserService(userRepository);
    }
}
