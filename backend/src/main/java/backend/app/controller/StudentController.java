package backend.app.controller;

import java.util.Properties;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import backend.app.service.StudentService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/studenti")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	
	// Kreiranje slanja email-a

//	@RequestMapping(value = "/pustiObavjestenje", method = RequestMethod.POST)
//	public String sendEmailObavjestenje() {
//
//		return "Email sent successfully";
//	}
//
//	@Bean
//	public JavaMailSender getJavaMailSender() {
//		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//		mailSender.setHost("smtp.gmail.com");
//		mailSender.setPort(587);
//
//		mailSender.setUsername("my.gmail@gmail.com");
//		mailSender.setPassword("password");
//		Properties props = mailSender.getJavaMailProperties();
//		props.put("mail.transport.protocol", "smtp");
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.debug", "true");
//		return mailSender;
//	}

}
