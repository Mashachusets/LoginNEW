package org.example.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import javax.persistence.*;

@Builder
@ApiModel(description = "Model of account roles")
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @ApiModelProperty(notes = "Unique id of role")
    private Integer id;

    @ApiModelProperty(notes = "Name of role")
    private ERole name;
}