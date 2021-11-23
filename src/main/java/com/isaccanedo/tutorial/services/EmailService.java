package com.isaccanedo.tutorial.services;

import org.springframework.mail.SimpleMailMessage;

import com.isaccanedo.tutorial.domain.Cliente;
import com.isaccanedo.tutorial.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);
}
