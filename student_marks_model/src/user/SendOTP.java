package user;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import user.OTP_match;



public class SendOTP {
	public SendOTP(String to){
		String to1 = to;
        String from = "helloworld.personal.me@gmail.com";
        String host = "smtp.gmail.com";

        // Setup mail server
        Properties properties = System.getProperties();
        properties.put("mail.smtp.ssl.protocols","TLSv1.2");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication("helloworld.personal.me@gmail.com", "qfpo xrym revj tvhl");
            }
        });
        //session.setDebug(true);
        try {
        	
        	Random rnd = new Random();
        	int number = rnd.nextInt(999999);
        	String msg="Your OTP is:"+number;
        	
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("OTP verification");
            message.setText(msg);
            System.out.println("sending...");
            Transport.send(message);
            System.out.println("Sent otp successfully....");
            OTP_match otp=new OTP_match(number,to1);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
	}
}
