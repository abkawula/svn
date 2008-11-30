package mypackage;

import javax.mail.Address;
import javax.mail.Multipart;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.masukomi.aspirin.core.MailQue;
import org.masukomi.aspirin.core.SimpleMimeMessageGenerator;

public class SendEmail {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MimeMessage email = SimpleMimeMessageGenerator.getNewMimeMessage();
			
//			Multipart content = new MimeMultipart();
//			email.setContent(content);
			
			Address fromAddress = new InternetAddress("abkawula@adamandmichelle.servebeer.com");
			Address toAddress = new InternetAddress("abkawula@yahoo.com");
			email.setFrom(fromAddress);
			email.setRecipient(RecipientType.TO, toAddress);
			email.setSubject("Adam rules");
			email.setText("Per the subject: Adam Rules");
			
			MailQue.queMail(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
