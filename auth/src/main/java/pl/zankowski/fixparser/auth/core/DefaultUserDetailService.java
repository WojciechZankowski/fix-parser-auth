package pl.zankowski.fixparser.auth.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.zankowski.fixparser.user.api.AccountTO;
import pl.zankowski.fixparser.user.spi.UserService;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class DefaultUserDetailService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public DefaultUserDetailService(final UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        return userService.findAccountByEmail(username)
                .map(this::map)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found."));
    }

    private User map(final AccountTO account) {
        final List<SimpleGrantedAuthority> authorities = account.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(toList());

        return new User(account.getEmail(), account.getPassword(), authorities);
    }

}
