package com.ToDoApp.service.impl;

import com.ToDoApp.dto.request.UserCreateDTO;
import com.ToDoApp.dto.response.SingleValueDTO;
import com.ToDoApp.exception.InternalServerErrorException;
import com.ToDoApp.mapper.UserDTOMapper;
import com.ToDoApp.model.User;
import com.ToDoApp.repository.UserRepository;
import com.ToDoApp.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserDTOMapper userDTOMapper;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           UserDTOMapper userDTOMapper,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.userDTOMapper = userDTOMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    @Transactional
    public SingleValueDTO<Integer> createUser(UserCreateDTO userCreateDTO) {
        if (userCreateDTO != null) {
            SingleValueDTO<Integer> singleValueDTO;
            User user = prepareUser(userCreateDTO);
            try {
                User savedUser = userRepository.save(user);
                singleValueDTO = new SingleValueDTO<>(savedUser.getId());
                return singleValueDTO;
            } catch (Exception e) {
                throw new InternalServerErrorException(e);
            }
        } else {
            throw new InternalServerErrorException("User entered bad login or password");
        }
    }

    private User prepareUser(UserCreateDTO userCreateDTO) {
        userCreateDTO.setPasswordHash(bCryptPasswordEncoder.encode(userCreateDTO.getPasswordHash()));
        User user;
        user = userDTOMapper.userCreateDTOToUser(userCreateDTO);
        return user;
    }
}
