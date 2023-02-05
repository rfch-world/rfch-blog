package world.rfch.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import world.rfch.exception.UserNotFoundException;
import world.rfch.jpa.entity.UserEntity;
import world.rfch.jpa.repository.UserJpaRepository;
import world.rfch.service.UserService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserJpaRepository userJpaRepository;


    @Override
    public List<UserEntity> findAll() {
        return userJpaRepository.findAll();
    }

    @Override
    public UserEntity findById(Long id) {
        return userJpaRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException("Can't find user with given id"));
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userJpaRepository.findByEmail(email)
                .orElseThrow(()->new UserNotFoundException("Can't find user with given email"));
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userJpaRepository.findByUsername(username)
                .orElseThrow(()->new UserNotFoundException("Can't find user with given username"));
    }

    @Override
    public void save(UserEntity userEntity) {
        userJpaRepository.save(userEntity);
    }

    @Override
    public void deleteById(Long id) {
        userJpaRepository.deleteById(id);
    }
}
