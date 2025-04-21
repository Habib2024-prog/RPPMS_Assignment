package EmailNotifier;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;
import Notifi.Notifiable;

public class EmailNotification implements Notifiable {
    @Override
     public  void sendNotification(String to, String messageText) {
        final String from = "habibullahanoosha2019@gmail.com";
        final String password = "mvqsctfceaicasra"; // Use App Password for Gmail

        // SMTP configuration for Gmail
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Authenticated session
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(to)
            );
            message.setSubject("ALERT!");
            message.setText(messageText);

            Transport.send(message);
            System.out.println("Email sent to " + to + " successfully!");

        } catch (MessagingException e) {
            e.getStackTrace();
            System.err.println("Failed to send email.");
        }
    }
}

