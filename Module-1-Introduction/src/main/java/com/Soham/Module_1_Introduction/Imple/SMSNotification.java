package com.Soham.Module_1_Introduction.Imple;

import com.Soham.Module_1_Introduction.NotificationServcie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("smsNoti")
public class SMSNotification implements NotificationServcie {
    @Override
    public void send() {
        System.out.println("Sending with SMS");
    }
}
