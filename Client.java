import java.until.*;
import java.net.*;
import java.io.*;

//public class Client {
//    private static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        tre(Socket socket = new Socket("14.215.177.39",443)){
//            scanner.nextLine();
//        }
//    }
//}
public class Client{
    private static void main(String[] args){
         try(Socket socket = new Socket("192.168.1.4",8080)){
             //2.代表三次握手中，我的TCP作为主动方，收到了对方的syn+ack了，并且第三次ack也发送了，但没有达到对方
             //TCP的状态一定是ESTABLISHED
             String httpReauest = "Get / ...";
             socket.getOutputStream().write(httpReauest.getBytes());
             socket.getOutputStream().flush;
             //3.数据刚到达TCP的发送缓冲区
         } catch (Exception e) {
             //TODO: handle exception
         }
    }
}