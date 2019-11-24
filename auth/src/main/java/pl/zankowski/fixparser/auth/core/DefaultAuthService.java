package pl.zankowski.fixparser.auth.core;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.zankowski.fixparser.auth.api.ImmutableJwtTokenTO;
import pl.zankowski.fixparser.auth.api.JwtTokenTO;
import pl.zankowski.fixparser.auth.api.LoginTO;
import pl.zankowski.fixparser.common.security.TokenProvider;

@Service
public class DefaultAuthService implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;

    public DefaultAuthService(final AuthenticationManager authenticationManager, final TokenProvider tokenProvider) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
    }

    @Override
    public JwtTokenTO createAuthToken(final LoginTO login) {
        final UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                login.getEmail(), login.getPassword());

        final Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return ImmutableJwtTokenTO.builder()
                .idToken(tokenProvider.createAuthToken(authentication, true))
                .build();
    }

}
