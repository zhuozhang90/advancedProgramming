package edu.bu.cs622.network;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart; 
import javax.mail.internet.MimeMessage; 
import javax.mail.internet.MimeMultipart; 
import java.io.File; 
import java.util.Properties; 
public class SendingEmailAttachment { 
 private String host = ""; 
 private int port = 0; 
 private String username = ""; 
 private String password = ""; 
 
 private void sendMail(String host, int port, String username, String password) { 
 Properties prop = new Properties(); 
 prop.put("mail.smtp.auth", true); 
 prop.put("mail.smtp.starttls.enable", "true"); 
 prop.put("mail.smtp.host", host); 
 prop.put("mail.smtp.port", port); 
 prop.put("mail.smtp.ssl.trust", host); 
 Session session = Session.getInstance(prop, new Authenticator() { 
 @Override
 protected PasswordAuthentication getPasswordAuthentication() { 
 return new PasswordAuthentication(username, password); 
 } 
 }); 
 try { 
 Message message = new MimeMessage(session); 
 message.setFrom(new InternetAddress("sender@attachment.com")); 
 message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("xxx@attachment.edu")); 
 message.setSubject("I don't forget to include METCS622 in my email title"); 
 // Create a multipart message
 Multipart multipart = new MimeMultipart(); 
 BodyPart messageBodyPart = new MimeBodyPart(); 
 messageBodyPart.setText("This is sample text"); 
 // Set text message part
 multipart.addBodyPart(messageBodyPart); 
 // Part two is attachment
 messageBodyPart = new MimeBodyPart(); 
 
 protected PasswordAuthentication getPasswordAuthentication() { 
 return new PasswordAuthentication(username, password); 
 } 
 }); 
 try { 
 Message message = new MimeMessage(session); 
 message.setFrom(new InternetAddress("sender@attachment.com")); 
 message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("xxx@attachment.edu")); 
 message.setSubject("I don't forget to include METCS622 in my email title"); 
 // Create a multipart message
 Multipart multipart = new MimeMultipart(); 
 BodyPart messageBodyPart = new MimeBodyPart(); 
 messageBodyPart.setText("This is sample text"); 
 // Set text message part
 multipart.addBodyPart(messageBodyPart); 
 // Part two is attachment
 messageBodyPart = new MimeBodyPart(); 
 String filename = "/Users/rawassizadeh/WORK/eclipseworkspace/CSMET622/Introduction.pdf"; 
 DataSource source = new FileDataSource(filename); 
 System.out.println("---->"+source.getContentType()); 
 messageBodyPart.setDataHandler(new DataHandler(source)); 
 messageBodyPart.setFileName(filename); 
 multipart.addBodyPart(messageBodyPart); 
 message.setContent(multipart); 
 Transport.send(message); 
 } catch (Exception e) { 
 e.printStackTrace(); 
 } 
 } 
 
 public static void main(String ... args) { 
 SendingEmailAttachment semail = new SendingEmailAttachment(); 
 System.out.println("start initiating the connection"); 
 semail.sendMail("localhost", 25, "someusername", "somepass"); 
 System.out.println("email send process is finished"); 
 } 
} 
