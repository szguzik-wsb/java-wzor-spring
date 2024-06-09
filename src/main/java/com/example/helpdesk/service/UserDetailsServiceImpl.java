package com.example.helpdesk.service;
// Importowanie niezbędnych klas
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.helpdesk.model.User;
import com.example.helpdesk.repository.UserRepository;
import org.springframework.security.core.userdetails.User.UserBuilder;

// Adnotacja informująca, że klasa jest serwisem
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    // Wstrzyknięcie repozytorium użytkownika
    @Autowired
    private UserRepository userRepository;

    // Metoda do ładowania użytkownika po nazwie użytkownika
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Wyszukanie użytkownika po nazwie użytkownika
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Użytkownik nie znaleziony");
        }

        // Budowanie obiektu UserDetails
        UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(username);
        builder.password(user.getPassword());
        builder.roles("USER");
        return builder.build();
    }
}

