import com.sun.xml.internal.messaging.saaj.util.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ragvalod on 10.06.16.
 */
public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String partNumber = request.getParameter("number");
        String hash = request.getParameter("hash");
        String data = request.getParameter("data");
        Boolean isLast = Boolean.valueOf(request.getParameter("isLast"));

        data = Base64.base64Decode(data);
        System.out.println(data);

        if (isLast) {
            System.out.println("isLast:" + isLast);
            Saver saver = new Saver(partNumber, data, isLast);
            saver.savePart();
        } else if (hash.equals(DigestUtils.md5Hex(data))) {
            Saver saver = new Saver(partNumber, data);
            saver.savePart();
        } else {
            response.sendError(400, "REPEAT");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.write("<h1>use POST method</h1>");
    }
}
