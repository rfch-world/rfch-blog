package world.rfch.service;

import world.rfch.jpa.entity.SupportArticleEntity;
import world.rfch.jpa.entity.UserEntity;

import java.util.List;

public interface SupportArticleService {

    List<SupportArticleEntity> findAll();
    List<SupportArticleEntity> findByStatus(boolean status);
    SupportArticleEntity findById(Long id);
    SupportArticleEntity findByUserEntity(UserEntity userEntity);
    void save(SupportArticleEntity supportArticleEntity);
    void deleteById(Long id);

}
