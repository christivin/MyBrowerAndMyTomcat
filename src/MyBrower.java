import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by zoujing on 2017/5/10.
 */
public class MyBrower {
    public static void main(String[] args) {
        try {
            Socket browser = new Socket("127.0.0.1", 9090);
            PrintWriter pw = new PrintWriter(browser.getOutputStream(),true);
            // 封装请求第一行
            pw.println("GET/ HTTP/1.1");
            // 封装请求头
            pw.println("User-Agent: Java/1.8.0_131");
            pw.println("Host: 127.0.0.1:9090");
            pw.println("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            pw.println("Connection: keep-alive");
            // 空行
            pw.println();
            // 封装实体主体
            //pw.println("UserName=JessieZou&Age=22");
            // 写入完毕
            browser.shutdownOutput();


            // 接受服务器返回信息，
            InputStream in = browser.getInputStream();
            //
            int length = 0;
            StringBuffer request = new StringBuffer();
            byte[] buf = new byte[1024];
            //
            while ((length = in.read(buf)) != -1) {
                String line = new String(buf, 0, length);
                request.append(line);
            }
            System.out.println(request);
            //browser.close();
        } catch (IOException e) {
            System.out.println("亲，出现了异常哦!");
        }finally{

        }
    }
}
