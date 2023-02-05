package world.rfch.service;

import world.rfch.jpa.entity.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> findAll();
    UserEntity findById(Long id);
    UserEntity findByEmail(String email);
    UserEntity findByUsername(String username);
    void save(UserEntity userEntity);
    void deleteById(Long id);

}
