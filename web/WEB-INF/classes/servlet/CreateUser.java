package servlet;

import entity.Role;
import entity.User;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

import static util.ServletUtil.createViewPath;

@WebServlet("/createUser")

public class CreateUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher(createViewPath("user"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(req.getParameter("name"), req.getParameter("surname"), LocalDate.now(), req.getParameter("email"), req.getParameter("password"), Role.USER);
        UserService.getInstance().createNewUser(user);
        getServletContext()
                .getRequestDispatcher(createViewPath("ok"))
                .forward(req, resp);
    }
}
