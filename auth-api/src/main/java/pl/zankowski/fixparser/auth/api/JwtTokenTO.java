package pl.zankowski.fixparser.auth.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableJwtTokenTO.class)
@JsonDeserialize(as = ImmutableJwtTokenTO.class)
public interface JwtTokenTO {

    @JsonProperty("id_token")
    String getIdToken();

}
