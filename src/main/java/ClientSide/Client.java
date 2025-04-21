package ClientSide;

import ChatServerSystem.ChatServer;
import ExceptionHandler.RpmsErrorHandling;

public class Client {
    private final String userRole;
    private final ChatServer server;
    public Client(ChatServer server,String userRole){
        this.server=server;
        this.userRole=userRole;
    }

    public void sendMessage(String Massage)throws RpmsErrorHandling {
        if (Massage==null||Massage.trim().isEmpty()) {
            throw new RpmsErrorHandling ("Message can't be empty");
        }
        server.routMassage(userRole, Massage);
    }
    public void displayChat(){
        System.out.println("\n---Chat History---");
        for (String chat:server.getSessionTranscripted()){
            System.out.println(chat);
        }
    }

}

