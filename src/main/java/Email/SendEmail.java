package Email;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail {
    public static void send() {
        Properties props = new Properties();/*创建一个Property文件对象*/
        props.put("mail.smtp.host", "smtp.mxhichina.com");/*设置邮件服务器的信息，这里设置smtp主机名称*/
        props.put("mail.smtp.socketFactory.port", "465");/*设置socket factory 的端口*/
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");/*设置socket factory*/
        props.put("mail.smtp.auth", "true");/*设置需要身份验证*/
        props.put("smtp.smtp.com", "25");/*设置SMTP的端口，的smtp端口是25*/
        // 身份验证实现
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                // 第二个参数，就是开启smtp的授权码
                return new PasswordAuthentication("hunter@gchoicetech.com", "Yanglin~");
            }
        });
        try {
            Message message = new MimeMessage(session);/*创建一个MimeMessage类的实例对象*/
            message.setFrom(new InternetAddress("hunter@gchoicetech.com"));/*设置发件人邮箱地址*/
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("1226992896@qq.com"));/*设置收件人邮箱地址*/
            message.setSubject("测试发送邮件");/*设置邮件主题*/
            BodyPart messageBodyPart1 = new MimeBodyPart();/*创建一个MimeBodyPart的对象，以便添加内容*/
            messageBodyPart1.setText("这个是邮件的正文部分");/*设置邮件正文内容*/
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();/*创建另外一个MimeBodyPart对象，以便添加其他内容*/
            String filename = ".\\test-output\\emailable-report.html";/*设置邮件中附件文件的路径*/
            DataSource source = new FileDataSource(filename);/*创建一个datasource对象，并传递文件*/
            messageBodyPart2.setDataHandler(new DataHandler(source));/*设置handler*/
            messageBodyPart2.setFileName(filename);/*加载文件*/
            Multipart multipart = new MimeMultipart();/*创建一个MimeMultipart类的实例对象*/
            multipart.addBodyPart(messageBodyPart1);/*添加正文1内容*/
            multipart.addBodyPart(messageBodyPart2);/*添加正文2内容*/
            message.setContent(multipart);/*设置内容*/
            Transport.send(message);/*最终发送邮件*/
            System.out.println("=====邮件已经发送=====");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
