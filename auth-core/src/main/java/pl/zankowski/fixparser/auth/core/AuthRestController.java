package pl.zankowski.fixparser.auth.core;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zankowski.fixparser.auth.api.JwtTokenTO;
import pl.zankowski.fixparser.auth.api.LoginTO;
import pl.zankowski.fixparser.common.security.JwtConfigurer;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/authenticate")
@Api(tags = "Auth", description = "Perform authentication operations.")
public class AuthRestController {

    private final AuthService authService;

    @Autowired
    public AuthRestController(final AuthService authService) {
        this.authService = authService;
    }

    @ApiOperation(value = "Authenticate user.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "JWT returned for an user.")})
    @PostMapping
    public ResponseEntity authenticate(@Valid @RequestBody final LoginTO login, final HttpServletResponse response) {
        final JwtTokenTO authToken = authService.createAuthToken(login);
        response.addHeader(JwtConfigurer.AUTHORIZATION_HEADER, "Bearer " + authToken.getIdToken());
        return ResponseEntity.ok(authToken);
    }

}
