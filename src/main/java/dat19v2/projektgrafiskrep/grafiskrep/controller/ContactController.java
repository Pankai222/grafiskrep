package dat19v2.projektgrafiskrep.grafiskrep.controller;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Properties;

// NOTE: YOU HAVE TO ENABLE LESS SECURE APPS ON THE GMAIL ACCOUNT YOU ARE
// SENDING FROM, ELSE GOOGLE WONT ALLOW IT TO GO THROUGH AND ENABLE IMAP(gives access to gmail through other clients)
// FOUND ON SETTINGS PAGE ON YOUR GMAIL ACCOUNT

// NOTE: upper limit of 2000 messages per day
// NOTE: smtp = simple mail transfer protocol
// NOTE: imap = internet message access protocol
@Controller
public class ContactController {
    @RequestMapping("/contact")
    public String contact(){
        return "contact";
    }

    @PostMapping( "/contact" )
    /**
     * @param name name of sender
     * @param emailSender mail of sender
     * @param phoneNr phone number of sender
     * @param message message to write in email
     **/
    public void sendEmail( String name, String emailSender, String phoneNr,
                          String emailMessage ) {

        // NOTE: servicetest.grafiskrep@gmail.com password: tilfoersteeksamen
        final String TO = "servicetest.grafiskrep@gmail.com";
        final String FROM = "testingproductionstuff@gmail.com";
        final String PASSWORD = "KEAfoersteeksamen";
        final String HOST = "smtp.gmail.com";

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        // set mail server host
        mailSender.setHost( HOST );
        // gmail TLS port( see docs )
        mailSender.setPort( 587 );
        mailSender.setUsername( FROM );
        mailSender.setPassword( PASSWORD );

        // set properties of the mail service
        Properties properties = new Properties();
        properties.put( "mail.transport.protocol", "smtp" );
        // authenticate user
        properties.put( "mail.smtp.auth", "true" );
        // switch connection to TLS-protected one before doing
        // any login commands(this might fail, and continues without TLS)
        properties.put( "mail.smtp.starttls.enable", "true" );
        // we trust the host specified( see docs )
        properties.put( "mail.smtp.ssl.trust", HOST );
        properties.put( "mail.debug", "true" );
        mailSender.setJavaMailProperties( properties );


        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo( TO );
        message.setSubject( name + " ønsker kontakt!" );
        message.setText( "Email: " + emailSender + "\n" +
                "Phone number: " + phoneNr + "\n" +
                emailMessage );
        mailSender.send( message );
    }
}
