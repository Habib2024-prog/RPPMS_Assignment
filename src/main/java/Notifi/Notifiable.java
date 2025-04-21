package Notifi;

import ExceptionHandler.RpmsErrorHandling;

public interface Notifiable {
        ///method send  for notification
        void sendNotification(String receiver,String massage) throws RpmsErrorHandling;

}
