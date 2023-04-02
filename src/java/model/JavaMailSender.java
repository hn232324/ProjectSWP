/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import dal.DAOAccount;
import javax.mail.Authenticator;
import javax.mail.Message;
import model.Account;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;
import java.util.Random;

/**
 *
 * @author USER
 */
public class JavaMailSender {

    public String getRandom() {
        Random r = new Random();
        int num = r.nextInt(99999999);
        return String.format("%08d", num);
    }

    public boolean sendEmailSignup(Account a , String code) {
        boolean test = false;

        String fromEmail = "congmanhbn2112@gmail.com";
        String password = "iuqdfmlgfykzsgdm";
        String toEmmail = a.getEmail();
        Properties pr = new Properties();
        pr.setProperty("mail.smtp.host", "smtp.gmail.com");
        pr.setProperty("mail.smtp.port", "587"); //TLS
        pr.setProperty("mail.smtp.auth", "true");
        pr.setProperty("mail.smtp.starttls.enable", "true");

        //get Session
        Session session = Session.getInstance(pr, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }

        });

        try {
            Message mess = new MimeMessage(session);
            mess.setFrom(new InternetAddress(fromEmail));
            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmmail));
           
            mess.setSubject("Security Code");
            mess.setText("Hi " + a.getUsename()+ "\n"
                    + "Your security code: " + code + "\n"
                    + "To be able to log in, please enter the security code to activate your account."
                    + "Please do not share the code with anyone.");
            Transport.send(mess);
            test = true;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return test;
    }

    public static void main(String[] args) {
        JavaMailSender jm = new JavaMailSender();
        jm.getRandom();
        Account a = null;
        jm.sendEmailSignup(a, jm.getRandom());
    }
    
}
