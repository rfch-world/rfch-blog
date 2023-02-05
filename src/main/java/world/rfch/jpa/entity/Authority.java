package world.rfch.jpa.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import world.rfch.jpa.common.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@Table(name = "authority")
@NoArgsConstructor
@AllArgsConstructor
public class Authority extends AbstractEntity implements GrantedAuthority {

    @Column(name = "authority")
    private String authority;

    @ManyToMany(mappedBy = "authorities")
    List<UserEntity> userEntityList;

}
