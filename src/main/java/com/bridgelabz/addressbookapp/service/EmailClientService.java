package com.bridgelabz.addressbookapp.service;


import com.bridgelabz.addressbookapp.dto.ResponseDto;
import com.bridgelabz.addressbookapp.model.Email;
import org.springframework.http.ResponseEntity;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Properties;


@Service
public class EmailClientService implements IEmailService {

    @Override
    public ResponseEntity<ResponseDto> sendEmail(Email email) {
        final String fromEmail = "tanuja.pathak13@gmail.com";//change with your sender email
        final String fromPwd = "jywpcrgabcuuigcv";//change with your sender password
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication

            getPasswordAuthentication() {
                // TODO Auto-generated method stub
                return new PasswordAuthentication(fromEmail, fromPwd);
            }
        };
        //create a new email  message using session
        Session session = Session.getInstance(properties,authenticator);
        MimeMessage mail = new MimeMessage(session);
        try {
            mail.addHeader("Content-type","text/HTML;charset=UTF-8");
            mail.addHeader("format", "flowed");
            mail.addHeader("Content-Transfer-Encoding", "8bit");
            mail.setFrom(new InternetAddress(fromEmail));
            mail.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getTo()));
            mail.setText(email.getBody(), "UTF-8");
            mail.setSubject(email.getSubject(), "UTF-8");
            //sending message
            Transport.send(mail);
            ResponseDto responseDTO = new ResponseDto("Sent email ", mail, null);
            return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.OK);
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ResponseDto responseDTO = new ResponseDto("ERROR: Couldn't send email" , null, null);
        return new ResponseEntity<ResponseDto> (responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

    }


}


