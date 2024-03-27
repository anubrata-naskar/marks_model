package user;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

public class MailSend {
    String to, msg, subject, filepath;

    public MailSend(String to, String msg, String subject, String filepath) {
        this.to = to;
        this.subject = subject;
        this.msg = msg;
        this.filepath = filepath;
        System.out.println("hello");
    }

    public void send() {
        String from = "ankan.samanta8017@gmail.com";
        String host = "smtp.gmail.com";

        // Setup mail server
        Properties properties = System.getProperties();
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication("ankan.samanta8017@gmail.com", "kkmh bzuy usvv oyen");
            }
        });
        // session.setDebug(true);
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);

            MimeBodyPart messageBodyPart1 = new MimeBodyPart();
            messageBodyPart1.setText(msg);

            MimeBodyPart messageBodyPart2 = new MimeBodyPart();

            File file = new File(filepath);
            String filename = file.getName();
            FileDataSource source = new FileDataSource(file);
            messageBodyPart2.setDataHandler(new DataHandler(source));
            messageBodyPart2.setFileName(filename);

            MimeMultipart multipartObject = new MimeMultipart();
            multipartObject.addBodyPart(messageBodyPart1);
            multipartObject.addBodyPart(messageBodyPart2);

            message.setContent(multipartObject);

            // message.setText(msg);
            System.out.println("sending...");
            Transport.send(message);
            System.out.println("Sent message successfully....");
            JOptionPane.showMessageDialog(null, "Message sent successfully..!");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
