package com.example.helpdesk.repository;
// Importowanie niezbędnych klas
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.helpdesk.model.Ticket;

// Interfejs repozytorium dla encji Ticket
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}

