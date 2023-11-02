/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APIs;

/**
 *
 * @author louay
 */
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SMSManager {
    private static final String ACCOUNT_SID = "AC3d76eb9005b49c7a2a73ce650a34c6f5";
    private static final String AUTH_TOKEN = "c3329e404b08f328c124ea310c5f307a";
    private static final String TWILIO_PHONE_NUMBER = "+17196940243 ";

    public void sendSMS(String receiverPhoneNumber, String message) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message.creator(
                new PhoneNumber(receiverPhoneNumber),
                new PhoneNumber(TWILIO_PHONE_NUMBER),
                message
        ).create();

        System.out.println("SMS sent successfully."); // Print a success message
    }
}
