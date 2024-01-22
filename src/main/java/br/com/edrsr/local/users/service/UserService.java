package br.com.edrsr.local.users.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edrsr.local.users.model.UserModel;
import br.com.edrsr.local.users.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    public UserModel findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("user not found"));
    }

    public UserModel save(@Valid UserModel userModel) {
        return userRepository.save(userModel);
    }

    public UserModel updateById(@Valid UserModel updatedUser) {
        if (!userRepository.existsById(updatedUser.getId())) {
            throw new EntityNotFoundException("user not found");
        }

        UserModel userModel = userRepository.findById(updatedUser.getId()).get();
        BeanUtils.copyProperties(updatedUser, userModel);

        return userRepository.save(userModel);
    }

    public void deleteById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("user not found");
        }

        userRepository.deleteById(id);
    }
}