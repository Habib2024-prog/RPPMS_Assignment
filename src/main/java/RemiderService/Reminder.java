package RemiderService;

import Date.CustomeDate;
import ExceptionHandler.RpmsErrorHandling;
import Notifi.Notifiable;

public class Reminder {
    final private Notifiable email_notifier;
    final private String reminderMassage;
    final private String receiver;
    final private CustomeDate dueDate;

    // constructor
    public Reminder(String reciever, String reminderMassage, CustomeDate dueDate, Notifiable email) {
        this.email_notifier = email;
        this.dueDate = dueDate;
        this.reminderMassage = reminderMassage;
        this.receiver = reciever;
    }

    public void sendReminder() {
        // creating Reminder massage with date
        String massage = String.format("REMINDER: %s |DueDate: %s", reminderMassage, dueDate.toString());
        // Sending Reminder via email
        try {
            email_notifier.sendNotification(receiver, massage);
        } catch (Exception e) {
            System.err.println("Reminder Failed to send !" + e.getMessage());
        }


    }
}
