package world.rfch.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import world.rfch.jpa.entity.SupportArticleEntity;
import world.rfch.jpa.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface SupportArticleJpaRepository extends JpaRepository<SupportArticleEntity,Long> {

    List<SupportArticleEntity> findAllByStatus(boolean status);
    Optional<SupportArticleEntity> findByUserEntity(UserEntity userEntity);
}
