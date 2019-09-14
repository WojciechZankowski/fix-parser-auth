package pl.zankowski.fixparser.auth.api;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableLoginTO.class)
@JsonDeserialize(as = ImmutableLoginTO.class)
public interface LoginTO {

    String getEmail();

    String getPassword();

}
