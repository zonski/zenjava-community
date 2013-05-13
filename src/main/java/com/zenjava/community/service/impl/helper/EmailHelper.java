package com.zenjava.community.service.impl.helper;

import com.zenjava.community.service.data.exception.EmailSendException;
import com.zenjava.community.service.impl.entity.SystemInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailHelper {

    private static final Logger log = LoggerFactory.getLogger(EmailHelper.class);

    @Autowired private SystemInfoHelper systemInfoHelper;

    public void sendEmail(String toAddress, String subject, String text) {
        log.debug("Sending email to: '{}'", toAddress);

        SystemInfo systemInfo = systemInfoHelper.getSystemInfo();

        final String username = systemInfo.getEmailUsername();
        final String password = systemInfo.getEmailPassword();

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", systemInfo.getEmailServer());
        props.put("mail.smtp.port", systemInfo.getEmailPort());

        if (log.isTraceEnabled()) {
            log.trace("Email host: '{}'", systemInfo.getEmailServer());
            log.trace("Email port: '{}'", systemInfo.getEmailPort());
            log.trace("Email username: '{}'", systemInfo.getEmailUsername());
            log.trace("Email password: '{}'", systemInfo.getEmailPassword());
        }

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);

            log.info("Email sent to '{}', with subject '{}'", toAddress, subject);

        } catch (MessagingException e) {
            throw new EmailSendException("Error while sending email to '" + toAddress + "'", e);
        }
    }
}
