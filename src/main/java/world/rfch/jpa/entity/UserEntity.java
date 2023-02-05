package world.rfch.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import world.rfch.jpa.common.AbstractEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class UserEntity extends AbstractEntity {

    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    @Column(name = "created_at")
    private LocalDateTime registrationDate;

    @Column(name = "updated_at")
    private LocalDateTime updateDate;

    @Column(name = "is_subscribe")
    private boolean isSubscribe;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "status")
    private boolean status;

    @OneToOne(mappedBy = "userEntity")
    SupportArticleEntity supportArticleEntity;

    @PreUpdate
    public void preUpdate(){
        updateDate=LocalDateTime.now();
    }
    @PrePersist
    public void prePersist() {
        registrationDate = LocalDateTime.now();
    }

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "user_authorities",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id")})
    private Set<Authority> authorities = new HashSet<>();

}
