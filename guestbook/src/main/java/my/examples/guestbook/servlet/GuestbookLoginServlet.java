package my.examples.guestbook.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/guestbook/login")
public class GuestbookLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //리스트로포워딩해줌.
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/views/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //암호를읽어들인다.
        String password = req.getParameter("password");
        System.out.println(password);

        //암호가관리자암호인지확인.
        if("1234".equals(password)) {
            //맞다면session에값을저장.
            HttpSession session = req.getSession();
            session.setAttribute("admin", "true");
        }

        //로그인후에list로리다이렉트.
        resp.sendRedirect("/guestbook/list");
    }
}
