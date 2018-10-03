package my.examples.guestbook.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/guestbook/delete")
public class GuestbookDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // read id value. query parameter?id=100
        String id = req.getParameter("id");
        System.out.println(id);

        // check out login information at the session

        // delete id from guestbook

        // redirect to the /guestbook/list
        resp.sendRedirect("/guestbook/list");

    }
}
