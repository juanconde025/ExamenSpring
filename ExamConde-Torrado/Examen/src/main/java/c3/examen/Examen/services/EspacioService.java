package c3.examen.Examen.services;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import c3.examen.Examen.entities.espacio;
import c3.examen.Examen.repositories.EspacioRepository;

@Service
public class EspacioService {
    private EspacioRepository espacioRepository;

    public EspacioService() {
        this.espacioRepository = espacioRepository;
    }

    public List<espacio> getAllEspacios() {
        return espacioRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User updateUser(Integer id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setName(updatedUser.getName());
            user.setLastname(updatedUser.getLastname());
            user.setEmail(updatedUser.getEmail());
            user.setUsername(updatedUser.getUsername());
            user.setPhone(updatedUser.getPhone());
            user.setAge(updatedUser.getAge());
            user.setBio(updatedUser.getBio());
            user.setPhoto(updatedUser.getPhoto());

            if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
                user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
            }

            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User with ID " + id + " not exist"));
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
