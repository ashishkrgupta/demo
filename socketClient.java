import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
 
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
 
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQDestination;
 
import com.google.common.net.InetAddresses;
 
public class SendMessage{
  
      
       /*public static void main(String[] args) throws IOException {
              ActiveMQConnectionFactory mqConnFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
              Connection mqConn = null;
              Session sendSession = null;
              MessageProducer msgProducer = null;
              try {
                     mqConn = mqConnFactory.createConnection();
                     mqConn.start();
                     sendSession = mqConn.createSession(false, Session.AUTO_ACKNOWLEDGE);
                     msgProducer = sendSession.createProducer(null);
                     ActiveMQDestination dest = (ActiveMQDestination) sendSession.createQueue("jms.project.in");
                     File lvbAckFile = new File("I:\\Netbay\\abc.txt");
 
                     BufferedReader br = new BufferedReader(new FileReader(lvbAckFile));
                     StringBuffer message = new StringBuffer();
                     while (br.ready()) {
                           message.append(br.readLine());
                     }
                     br.close();
                     System.out.println("Message is :" + message.toString());
                     final String msg = message.toString();
                    
                     // byte[] b = new byte[(int) lvbAckFile.length()];
 
                     // MapMessage message = sendSession.createMapMessage();
                     // message.setObject("StKarnataka", b);
                     // msgProducer.send(dest, message);
                     TextMessage bytesMessage = sendSession.createTextMessage();
                     bytesMessage.setText(msg);
                     msgProducer.send(dest, bytesMessage);
              } catch (JMSException e1) {
 
                     e1.printStackTrace();
              }
              try {
                     msgProducer.close();
                     sendSession.close();
                     mqConn.close();
              } catch (JMSException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
              }
 
       }*/
   public static void main(String args[]) {
          Socket socket = null;
          try {
              InetAddress addr = InetAddress.getByName("localhost");
              socket =  new Socket(addr,8080);
              PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
           BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           // send an HTTP request to the web server
           out.println("GET / HTTP/1.1");
           out.println("Host:localhost:8080");
           out.println("Connection: Close");
           out.println("Content-Length");
           out.println();
           boolean loop = true;
           StringBuilder sb = new StringBuilder(8096);
       while(loop){
          if(in.ready()){  
                     int i = 0;
                     while(i != -1){
                      i = in.read();
                      sb.append((char) i);
                     }
         
              loop = false;
          }
      }
      System.out.println(""+sb.toString());
      socket.close();
 
 
       } catch (UnknownHostException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
       } catch (IOException e) {
 
                 if(socket != null){
                           try {
                                  socket.close();
                           } catch (IOException e1) {
                                  e1.printStackTrace();
                           }
                     }  
       }
   }
}
