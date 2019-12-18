package dat19v2.projektgrafiskrep.grafiskrep.controller;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Properties;

//Controller for the contact page.
@Controller
public class ContactController {
//    returns the contact html file when /contact is requested
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
    // TODO: add info validation on form input
    public void sendEmail( String name, String emailSender, String phoneNr,
                          String emailMessage ) {

        final String TO = "<INSERT TO EMAIL ADDRESS HERE>";
        final String FROM = "<INSERT FROM EMAIL ADDRESS HERE>";
        final String PASSWORD = "<INSERT PASSWORD HERE>";
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
        message.setSubject( name + " oensker kontakt!" );
        message.setText( "Email: " + emailSender + "\n" +
                "Phone number: " + phoneNr + "\n" +
                emailMessage );
        mailSender.send( message );
    }
}
