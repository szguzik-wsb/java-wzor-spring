package com.example.helpdesk.service;
// Importowanie niezbędnych klas
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.helpdesk.model.Ticket;
import com.example.helpdesk.repository.TicketRepository;
import java.util.List;

// Adnotacja informująca, że klasa jest serwisem
@Service
public class TicketService {

    // Wstrzyknięcie repozytorium
    @Autowired
    private TicketRepository ticketRepository;

    // Metoda do pobierania wszystkich zgłoszeń
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    // Metoda do tworzenia nowego zgłoszenia
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    // Metoda do pobierania zgłoszenia po id
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    // Metoda do aktualizowania zgłoszenia
    public Ticket updateTicket(Long id, Ticket ticketDetails) {
        Ticket ticket = ticketRepository.findById(id).orElse(null);

        ticket.setTitle(ticketDetails.getTitle());
        ticket.setDescription(ticketDetails.getDescription());
        ticket.setStatus(ticketDetails.getStatus());

        return ticketRepository.save(ticket);
    }

    // Metoda do usuwania zgłoszenia
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}

