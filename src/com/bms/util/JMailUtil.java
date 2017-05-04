package com.bms.util;

import javax.mail.Session;

import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;

public class JMailUtil {

    public static Session MailSession() {
        Session session = MailUtils.createSession("smtp.163.com", "15738869155", "bms1234");
        return session;
    }

    public static void BMSSendEmail(String to, String subject,String content) throws Exception {
        Mail mail = new Mail("15738869155@163.com", to, subject, content);
        MailUtils.send(MailSession(), mail);

    }

}
