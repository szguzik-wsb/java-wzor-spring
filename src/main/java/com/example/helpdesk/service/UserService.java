package com.example.helpdesk.service;
// Importowanie niezbędnych klas
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.helpdesk.model.User;
import com.example.helpdesk.repository.UserRepository;

// Adnotacja informująca, że klasa jest serwisem
@Service
public class UserService {

    // Wstrzyknięcie repozytorium użytkownika
    @Autowired
    private UserRepository userRepository;

    // Wstrzyknięcie kodera haseł
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Metoda do zapisywania użytkownika
    public void save(User user) {
        // Zakodowanie hasła przed zapisem
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    // Metoda do wyszukiwania użytkownika po nazwie użytkownika
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}

