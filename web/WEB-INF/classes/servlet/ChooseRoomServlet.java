package servlet;

import entity.Room;
import services.RoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static util.ServletUtil.createViewPath;

@WebServlet("/chooseRoom")

public class ChooseRoomServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDate localDate1 = LocalDate.parse(req.getParameter("arrivalDay"));
        LocalDate localDate2 = LocalDate.parse(req.getParameter("departureDay"));
        Integer roomId = new Integer(req.getParameter("roomTypeId"));
        Integer numberOfPlaces = new Integer(req.getParameter("numberOfPlaces"));

        List<Room> rooms = RoomService.getInstance().findEmptyRooms(localDate1, localDate2,
                roomId, numberOfPlaces);
        req.setAttribute("rooms", rooms);
        resp.addCookie(new Cookie("arrivalDay", req.getParameter("arrivalDay")));
        resp.addCookie(new Cookie("departureDay", req.getParameter("departureDay")));
        getServletContext()
                .getRequestDispatcher(createViewPath("rooms"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
