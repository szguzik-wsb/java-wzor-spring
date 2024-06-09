package com.example.helpdesk.controller;
// Importowanie niezbędnych klas
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.helpdesk.model.User;
import com.example.helpdesk.service.UserService;

// Adnotacja informująca, że klasa jest kontrolerem
@Controller
public class AuthController {

    // Wstrzyknięcie serwisu użytkownika
    @Autowired
    private UserService userService;

    // Mapowanie żądania GET do metody showLoginPage()
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    // Mapowanie żądania GET do metody showRegistrationForm()
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }


    // Mapowanie żądania POST do metody registerUser()
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        // Ustawienie domyślnej roli użytkownika na "USER"
        user.setRole("USER");
        // Zapis użytkownika w bazie danych
        userService.save(user);
        // Przekierowanie na stronę logowania
        return "redirect:/login";
    }
}

