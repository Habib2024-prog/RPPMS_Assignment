import ChatServerSystem.ChatServer;
import ClientSide.Client;
import Date.CustomeDate;
import EmailNotifier.EmailNotification;
import EmergencyAlertSystem.EmergencyAlert;
import Notifi.Notifiable;
import Notificaton.NotificationService;
import PanicButtonSystem.PanicButton;
import RemiderService.Reminder;
import SMSnotifier.SMSnotification;
import VideoConsultation.VideoCall;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class AlertSystem {
    public static void main(String[] args) {
        final String hospitalEmergencyEmail = "anwermohammadi809@gmail.com";
        final String hospitalEmergencyNumber = "+92336578289";
        try {
            Notifiable emailNotification = new EmailNotification();
            Notifiable smsNotification = new SMSnotification();
            NotificationService notificationService = new NotificationService(emailNotification
                    , smsNotification);
            EmergencyAlert emergencyAlert = new EmergencyAlert(notificationService,
                    hospitalEmergencyEmail,hospitalEmergencyNumber);
            // set normal Threshold;
            emergencyAlert.checkVitals(80,130,98,37);
          PanicButton panicButton=new PanicButton(notificationService
                    ,hospitalEmergencyEmail,hospitalEmergencyNumber);

            panicButton.press();

            CustomeDate date=new CustomeDate(2025,4,28,10);
            Reminder appointment=new Reminder("hashimis663@gmail.com",
                    "Your have an appointment with Dr.John at",
                    date,emailNotification);
            appointment.sendReminder();

             ChatServer server=new ChatServer();
             Client doctor=new Client(server,"Doctor");
             Client patient =new Client(server,"Patient");
             server.startSession();
             doctor.sendMessage("How are you Mr Habib?");
             patient.sendMessage("Fine,I'm feeling well today.");
             doctor.sendMessage(" That is great. your health becoming  in normal situation ");
             server.endSession();

             doctor.displayChat();

            VideoCall videoCall =new VideoCall("GoogleMeet");
            videoCall.startConsultation();
            videoCall.endConsultation();
            VideoCall zoom= new VideoCall("Zoom");
            zoom.startConsultation();
            zoom.endConsultation();



        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }

    }


}