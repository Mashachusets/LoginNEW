package org.example.models;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Builder
@ApiModel(description = "Model of user account data ")
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @ApiModelProperty(notes = "Unique id of user account")
    private Long id;

    @ApiModelProperty(notes = "Account username")
    private String username;

    @ApiModelProperty(notes = "User email address")
    private String email;

    @ApiModelProperty(notes = "User password")
    private String password;

    @ApiModelProperty(notes = "User roles")
    private ERole roleType;
}