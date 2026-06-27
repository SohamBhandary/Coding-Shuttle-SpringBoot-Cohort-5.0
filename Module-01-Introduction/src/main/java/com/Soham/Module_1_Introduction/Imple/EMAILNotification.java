package com.Soham.Module_1_Introduction.Imple;

import com.Soham.Module_1_Introduction.NotificationServcie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Qualifier("EmailNoti")
public class EMAILNotification implements NotificationServcie {
    @Override
    public void send() {
        System.out.println("Emaail Sending");
    }
}
