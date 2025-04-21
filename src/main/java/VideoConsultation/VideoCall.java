package VideoConsultation;

import ExceptionHandler.RpmsErrorHandling;

import java.util.UUID;

public class VideoCall {
    final private String platform;
    private String currentMeeteinglink;
    public VideoCall(String platform)throws RpmsErrorHandling{
        if(!platform.equalsIgnoreCase("GoogleMeet")&&!platform.equalsIgnoreCase("Zoom")){
            throw new RpmsErrorHandling ("Unsupported platform!");
        }
        this.platform=platform;

    }
    public String startConsultation() throws RpmsErrorHandling {
        if(currentMeeteinglink !=null){
            endConsultation();
        }
        String Id= UUID.randomUUID().toString().substring(0, 8);
        currentMeeteinglink =generatePlatformlink(Id);
        System.out.println(platform+" Consultation start with this Link:"+ currentMeeteinglink);
        return platform+" Consultation start with this Link:"+ currentMeeteinglink;

    }



    private String generatePlatformlink(String meetingId){
        return platform.equalsIgnoreCase(
                "GoogleMeet")?"http://meet.google.com/"+meetingId:"http://zoom.us/j/"+meetingId;
    }
    public void endConsultation() throws RpmsErrorHandling{
        if(currentMeeteinglink ==null)throw new RpmsErrorHandling("no active consultation");
        System.out.println("Ended"+platform+"Meeting "+ currentMeeteinglink);
        currentMeeteinglink =null;
    }



}
