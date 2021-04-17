package ee.sportcomplex.services;

import ee.sportcomplex.dto.Permissions;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ee.sportcomplex.repos.UserRepo;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
public class UserLoginService implements UserDetailsService {

    private final UserRepo userRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final ee.sportcomplex.dto.User user = userRepository.findUserByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("No user with login: " + username));

        user.getPermissions().forEach(System.out::println);
        return User.builder()
                .username(username)
                .password(user.getPassword())
                .authorities(mapAuthorities(user.getPermissions()))
                .build();
    }

    private static List<GrantedAuthority> mapAuthorities(final List<Permissions> permissions) {
        return permissions.stream()
                .map(Permissions::getPermission)
                .map(Enum::name)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
