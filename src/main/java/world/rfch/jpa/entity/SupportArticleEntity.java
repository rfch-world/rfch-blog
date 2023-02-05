package world.rfch.jpa.entity;

import lombok.*;
import org.apache.tomcat.jni.Local;
import world.rfch.jpa.common.AbstractEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "support_article")
public class SupportArticleEntity extends AbstractEntity {

    @Lob
    @Column(name = "article")
    private String article;

    @Column(name = "created_at")
    private LocalDateTime createDate;

    @Column(name = "updated_at")
    private LocalDateTime updateDate;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "status")
    private boolean status;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity userEntity;

    @PrePersist
    public void createDate(){
        createDate=LocalDateTime.now();
    }

    @PreUpdate
    public void updateDate(){
        updateDate=LocalDateTime.now();
    }
}
