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
                .antMatchers(
                        "/add_existing_abonement",
                        "/*_schedule_ind",
                        "/book_personal",
                        "/show_personal"
                        ).hasAuthority(Permissions.PermissionName.CLIENT.name())
                .antMatchers(
                        "/show_personal_coach"
                ).hasAuthority(Permissions.PermissionName.COACH.name())
                .antMatchers(
                        "/*_schedule_group"
                ).hasAuthority(Permissions.PermissionName.ADMIN.name())
                .antMatchers(
                        "/add_complex",
                        "/remove_complex",
                        "/remove_admin",
                        "/edit_admin",
                        "/admins"
                ).hasAuthority(Permissions.PermissionName.OWNER.name())

                .antMatchers(
                        "/edit_complex",
                        "/generate_code",
                        "/remove_coach",
                        "/edit_coach",
                        "/remove_code",
                        "/coaches",
                        "/available_codes"
                ).hasAnyAuthority(Permissions.PermissionName.ADMIN.name(),
                                    Permissions.PermissionName.OWNER.name())
                .antMatchers(
                        "/add_abonement",
                        "/buy_abonement"
                ).not().hasAnyAuthority(Permissions.PermissionName.ADMIN.name(),
                                        Permissions.PermissionName.COACH.name(),
                                        Permissions.PermissionName.OWNER.name())
                .antMatchers(
                        "/send_code"
                ).hasAnyAuthority(Permissions.PermissionName.ADMIN.name(),
                                    Permissions.PermissionName.COACH.name(),
                                    Permissions.PermissionName.CLIENT.name())
                .antMatchers(
                        "/change_user_info",
                        "/settings"
                ).authenticated()

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
