package servlet;

import dao.ReservationDao;
import dao.RoomDao;
import dao.RoomTypeDao;
import entity.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;

import static util.ServletUtil.createViewPath;

@WebServlet(urlPatterns = "/createReservation", name = "CreateReservation")

public class CreateReservationServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roomTypes", RoomTypeDao.getInstance().findAll());
        getServletContext()
                .getRequestDispatcher(createViewPath("Reservation"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Reservation reservation = new Reservation();
        Cookie[] cookies = req.getCookies();
        HashMap<String, String> map = new HashMap<>();
        for (Cookie cookie : cookies) {
            map.put(cookie.getName(), cookie.getValue());
        }
        System.out.println(map);
       reservation.setRoom(RoomDao.getInstance().findById(new Integer(map.get("room"))).get());
        reservation.setDayOfArrival(LocalDate.parse(map.get("arrivalDay")));
        reservation.setDayOfDeparture(LocalDate.parse(map.get("departureDay")));
        req.setAttribute("cost", reservation);

        Integer id = new Integer(req.getSession().getAttribute("currentUser").toString());
        reservation.setUserId(id);
        System.out.println(reservation);
        System.out.println(id);
        ReservationDao.getInstance().create(reservation);
        req.setAttribute("reservation", reservation);
        getServletContext()
                .getRequestDispatcher(createViewPath("finalReservation"))
                .forward(req, resp);
    }
}
