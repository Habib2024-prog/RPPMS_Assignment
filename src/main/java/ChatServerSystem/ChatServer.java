package ChatServerSystem;

import ExceptionHandler.RpmsErrorHandling;

import java.util.ArrayList;
import java.util.List;

public class ChatServer {
   final private List <String>chatHistory;
    private boolean isActiveSession;
    public ChatServer( ){
        this.chatHistory=new ArrayList<>();
        this.isActiveSession=false;
    }
    // start chat session
    public void startSession() throws RpmsErrorHandling{
        //with custom exception handling
        if (isActiveSession)throw new RpmsErrorHandling(" chat Session already in progress!");
        isActiveSession=true;
        chatHistory.clear();
        logSystemMassage("Chat Session Started");
    }
    // during chat session
    public void routMassage(String sender,String massage) throws RpmsErrorHandling{
        if(!isActiveSession) throw new RpmsErrorHandling("No Active Chat Session!");
        String formattedMassege="["+sender+"]:"+massage;
        chatHistory.add(formattedMassege);
        System.out.println("Messege routed:"+formattedMassege);
    }
    // end  chat session
    public void endSession() throws RpmsErrorHandling {
        if(!isActiveSession)throw new RpmsErrorHandling("Session is not active");
        logSystemMassage("Session ended");
        isActiveSession=false;

    }
    // return a complete chat session
    public List<String> getSessionTranscripted(){
        return new ArrayList<>(chatHistory);
    }
    // method for showing system message
    public void logSystemMassage(String massage){
        String systemMassage="[System]:"+massage;
        chatHistory.add(systemMassage);
        System.out.println(systemMassage);

    }


}
