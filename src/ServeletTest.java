
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;
/**
 * Created by zoujing on 2017/5/10.
 */
public class ServeletTest extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        for (Enumeration e = request.getHeaderNames(); e.hasMoreElements();) {
            String header = (String) e.nextElement();
            if (header != null)
                System.out.println((new StringBuilder(String.valueOf(header)))
                        .append(":").append(request.getHeader(header))
                        .toString());
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
