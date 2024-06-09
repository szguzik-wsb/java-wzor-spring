package com.example.helpdesk.controller;
// Importowanie niezbędnych klas
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.helpdesk.model.Ticket;
import com.example.helpdesk.service.TicketService;
import java.util.List;

// Adnotacja informująca, że klasa jest kontrolerem
@Controller
@RequestMapping("/tickets")
public class TicketController {

    // Wstrzyknięcie serwisu
    @Autowired
    private TicketService ticketService;

    // Mapowanie żądania GET do metody viewHomePage()
    @GetMapping
    public String viewHomePage(Model model) {
        // Pobranie wszystkich zgłoszeń i dodanie ich do modelu
        List<Ticket> listTickets = ticketService.getAllTickets();
        model.addAttribute("listTickets", listTickets);
        return "index";
    }

    // Mapowanie żądania GET do metody showNewTicketForm()
    @GetMapping("/new")
    public String showNewTicketForm(Model model) {
        // Utworzenie nowego obiektu Ticket i dodanie go do modelu
        Ticket ticket = new Ticket();
        model.addAttribute("ticket", ticket);
        return "new_ticket";
    }

    // Mapowanie żądania POST do metody saveTicket()
    @PostMapping
    public String saveTicket(@ModelAttribute("ticket") Ticket ticket) {
        // Zapisanie nowego zgłoszenia
        ticketService.createTicket(ticket);
        return "redirect:/tickets";
    }

    // Mapowanie żądania GET z parametrem id do metody showFormForUpdate()
    @GetMapping("/edit/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
        // Pobranie zgłoszenia po id i dodanie go do modelu
        Ticket ticket = ticketService.getTicketById(id);
        model.addAttribute("ticket", ticket);
        return "update_ticket";
    }

    // Mapowanie żądania POST do metody updateTicket()
    @PostMapping("/update/{id}")
    public String updateTicket(@PathVariable(value = "id") Long id, @ModelAttribute("ticket") Ticket ticket) {
        // Aktualizacja zgłoszenia
        ticketService.updateTicket(id, ticket);
        return "redirect:/tickets";
    }

    // Mapowanie żądania GET z parametrem id do metody deleteTicket()
    @GetMapping("/delete/{id}")
    public String deleteTicket(@PathVariable(value = "id") Long id) {
        // Usunięcie zgłoszenia
        ticketService.deleteTicket(id);
        return "redirect:/tickets";
    }
}

