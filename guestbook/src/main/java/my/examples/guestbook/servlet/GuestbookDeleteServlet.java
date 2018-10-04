package my.examples.guestbook.servlet;

import my.examples.guestbook.dao.GuestbookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/guestbook/delete")
public class GuestbookDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //id를읽어들인다.
        String id = req.getParameter("id");
        System.out.println(id);

        //세션에정보가있는지확인한다.
        HttpSession session = req.getSession();
        String admin = (String)session.getAttribute("admin");

        if(admin != null && admin.equals("true")) {
            //id에해당하는방명록을삭제한다.
            System.out.println(id+"를삭제합니다.");
            GuestbookDao guestbookDao = new GuestbookDao();
            guestbookDao.deleteGuestbook(Long.parseLong(id));
        }

        //list로리다이렉트.
        resp.sendRedirect("/guestbook/list");
    }
}
