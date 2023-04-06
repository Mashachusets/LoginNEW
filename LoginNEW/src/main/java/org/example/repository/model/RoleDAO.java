package org.example.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.models.ERole;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class RoleDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column
    private ERole name;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE},
//            mappedBy = "roles")
//    @JsonIgnore
//    private Set<UserDAO> userDAOS = new HashSet<>();
}