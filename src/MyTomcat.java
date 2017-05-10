import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zoujing on 2017/5/10.
 */

public class MyTomcat {

    public static void main(String[] args) {
        try {
            ServerSocket tomcat = new ServerSocket(9090);
            System.out.println("服务器启动");
            //
            Socket s = tomcat.accept();
            //
            byte[] buf = new byte[1024];
            InputStream in = s.getInputStream();
            //

            int length = 0;
            StringBuffer request = new StringBuffer();
            while ((length = in.read(buf)) != -1) {
                String line = new String(buf, 0, length);
                request.append(line);
            }
            //
            System.out.println("request:"+request);

            PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
            pw.println("<html>");
            pw.println("<head>");
            pw.println("<title>LiveSession List</title>");
            pw.println("</head>");
            pw.println("<body>");
            pw.println("<p style=\"font-weight: bold;color: red;\">welcome to MyTomcat</p>");
            pw.println("</body>");
            s.close();
            tomcat.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
