package world.rfch.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import world.rfch.exception.SupportArticleNotFoundException;
import world.rfch.jpa.entity.SupportArticleEntity;
import world.rfch.jpa.entity.UserEntity;
import world.rfch.jpa.repository.SupportArticleJpaRepository;
import world.rfch.service.SupportArticleService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SupportArticleServiceImpl implements SupportArticleService {

    private final SupportArticleJpaRepository supportArticleJpaRepository;

    @Override
    public List<SupportArticleEntity> findAll() {
        return supportArticleJpaRepository.findAll();
    }

    @Override
    public List<SupportArticleEntity> findByStatus(boolean status) {
        return supportArticleJpaRepository.findAllByStatus(status);
    }

    @Override
    public SupportArticleEntity findById(Long id) {
        return supportArticleJpaRepository.findById(id)
                .orElseThrow(()->new SupportArticleNotFoundException("Can't found article with given id"));
    }

    @Override
    public SupportArticleEntity findByUserEntity(UserEntity userEntity) {
        return supportArticleJpaRepository.findByUserEntity(userEntity)
                .orElseThrow(()->new SupportArticleNotFoundException("Can't found article with given id"));
    }

    @Override
    public void save(SupportArticleEntity supportArticleEntity) {
        supportArticleJpaRepository.save(supportArticleEntity);
    }

    @Override
    public void deleteById(Long id) {
        supportArticleJpaRepository.deleteById(id);
    }
}
