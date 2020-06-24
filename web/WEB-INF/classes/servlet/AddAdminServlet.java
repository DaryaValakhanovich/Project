package servlet;

import dao.UserDao;
import entity.User;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static util.ServletUtil.createViewPath;

@WebServlet(urlPatterns = "/admin", name = "addAdmin")
public class AddAdminServlet extends HttpServlet {

    private static final Map<String, String> USERS = new HashMap<>();

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher(createViewPath("admin"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String email = req.getParameter("email");

        List<User> users = UserDao.getInstance().findAll();
        for (User user : users) {
            USERS.put(user.getEmail(), user.getPassword());
        }
        if (USERS.containsKey(email)) { //TODO: replace with DB call
            UserService.getInstance().addAdmin(UserDao.getInstance().findByEmail(email).get());
            resp.sendRedirect("/menu");
        }
    }
}
