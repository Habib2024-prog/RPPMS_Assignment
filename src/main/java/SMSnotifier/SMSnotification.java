package SMSnotifier;

import ExceptionHandler.RpmsErrorHandling;
import Notifi.Notifiable;

public class SMSnotification implements Notifiable {
    @Override
    public void sendNotification(String receiver,String messege)throws RpmsErrorHandling {
        if( receiver==null||messege==null){
            throw new RpmsErrorHandling("recipient and message not be null!");}

        System.out.println( "SMS to "+receiver+": "+messege);

    }

}
