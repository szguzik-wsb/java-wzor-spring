// Importowanie niezbędnych klas
package com.example.helpdesk.model;

import jakarta.persistence.*;

// Adnotacja informująca, że klasa jest encją JPA
@Entity
// Określenie nazwy tabeli w bazie danych
@Table(name = "tickets")
public class Ticket {

    // Identyfikator zgłoszenia
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Tytuł zgłoszenia
    @Column(nullable = false)
    private String title;

    // Opis zgłoszenia
    @Column(nullable = false)
    private String description;

    // Status zgłoszenia
    @Column(nullable = false)
    private String status;

    // Właściciel zgłoszenia
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Gettery i Settery dla pól klasy

    // Pobierz id zgłoszenia
    public Long getId() {
        return id;
    }

    // Ustaw id zgłoszenia
    public void setId(Long id) {
        this.id = id;
    }

    // Pobierz tytuł zgłoszenia
    public String getTitle() {
        return title;
    }

    // Ustaw tytuł zgłoszenia
    public void setTitle(String title) {
        this.title = title;
    }

    // Pobierz opis zgłoszenia
    public String getDescription() {
        return description;
    }

    // Ustaw opis zgłoszenia
    public void setDescription(String description) {
        this.description = description;
    }

    // Pobierz status zgłoszenia
    public String getStatus() {
        return status;
    }

    // Ustaw status zgłoszenia
    public void setStatus(String status) {
        this.status = status;
    }

    // Pobierz właściciela zgłoszenia
    public User getUser() {
        return user;
    }

    // Ustaw właściciela zgłoszenia
    public void setUser(User user) {
        this.user = user;
    }
}
