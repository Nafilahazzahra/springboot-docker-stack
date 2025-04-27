package com.universitas.user_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universitas.user_service.model.User;
import com.universitas.user_service.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Mengambil semua user
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Mengambil user berdasarkan ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Menambahkan user baru
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Mengupdate data user
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User tidak ditemukan dengan id " + id));

        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setAddres(userDetails.getAddres());

        return userRepository.save(user);
    }

    // Menghapus user berdasarkan ID
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User tidak ditemukan dengan id " + id));
        userRepository.delete(user);
    }
}
