package com.example.helpdesk.repository;
// Importowanie niezbędnych klas
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.helpdesk.model.User;

// Interfejs repozytorium dla encji User
public interface UserRepository extends JpaRepository<User, Long> {
    // Metoda do wyszukiwania użytkownika po nazwie użytkownika
    User findByUsername(String username);
}
