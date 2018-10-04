package my.examples.guestbook.servlet;

import my.examples.guestbook.dao.GuestbookDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/guestbook/list")
public class GuestbookListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //db에서정보를읽어온다.
        GuestbookDao guestbookDao = new GuestbookDao();
        List<Guestbook> list = guestbookDao.getGuestbookList();

        //읽어온결과를jsp전달위해request에값을저장한다.
        req.setAttribute("guestbookList", list);
        req.setAttribute("guestbookSize", list.size());

        // /WEB-INF/views/list.jsp로포워딩해준다.
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/views/list.jsp");
        dispatcher.forward(req, resp);
    }
}
