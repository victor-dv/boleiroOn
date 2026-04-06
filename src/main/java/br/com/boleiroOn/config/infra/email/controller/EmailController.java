package br.com.boleiroOn.config.infra.email.controller;

import br.com.boleiroOn.config.infra.email.entity.EmailEntity;
import br.com.boleiroOn.config.infra.email.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/email")
public class EmailController {
    @Autowired
    private EmailService emailService;
    
    @PostMapping("/send")
    public  void enviarEmail(@RequestBody EmailEntity email) throws MessagingException {
        emailService.enviarEmail(email);
    }
}
