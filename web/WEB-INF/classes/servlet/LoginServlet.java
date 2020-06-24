package servlet;

import dao.UserDao;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static util.ServletUtil.createViewPath;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final Map<String, String> USERS = new HashMap<>();

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher(createViewPath("login"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        List<User> users = UserDao.getInstance().findAll();
        for (User user : users) {
            USERS.put(user.getEmail(), user.getPassword());
        }
        if (USERS.containsKey(email) && USERS.get(email).equals(password)) { //TODO: replace with DB call
            User user = UserDao.getInstance().findByEmail(email).get();
            req.getSession().setAttribute("currentUser", user.getId());
            resp.sendRedirect("/menu");
        } else {
            resp.sendRedirect("/login");
        }
    }
}
