package pl.zankowski.fixparser.auth.core;

import pl.zankowski.fixparser.auth.api.JwtTokenTO;
import pl.zankowski.fixparser.auth.api.LoginTO;

public interface AuthService {

    JwtTokenTO createAuthToken(LoginTO login);

}
