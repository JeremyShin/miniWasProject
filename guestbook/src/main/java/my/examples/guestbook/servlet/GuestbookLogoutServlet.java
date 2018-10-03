package my.examples.guestbook.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/guestbook/logout")
public class GuestbookLogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //세션에로그인정보를삭제한다.

        // /guestbook/list로redirect한다.
        resp.sendRedirect("/guestbook/list");
    }
}
