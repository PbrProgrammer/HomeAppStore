package net.fakour.homeappliances.service;

import net.fakour.homeappliances.entity.UserEntity;

public interface AdminService {
    String register(UserEntity users);
    UserEntity login (UserEntity userEntity);
}
