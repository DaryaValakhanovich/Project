package services;

import dao.RoomDao;
import entity.Room;

import java.time.LocalDate;
import java.util.List;

public class RoomService{
    private static RoomService INSTANCE = null;

    private RoomService() {
    }

    public static RoomService getInstance() {
        if (INSTANCE == null) {
            synchronized (RoomService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new RoomService();
                }
            }
        }
        return INSTANCE;
    }
    public List<Room> findEmptyRooms(LocalDate localDateFrom, LocalDate localDateTo, int roomTypeId, int numberOfPlaces) {
        if(localDateFrom.isAfter(localDateTo)){
            return null;
        }
        return RoomDao.getInstance().findEmptyRooms(localDateFrom, localDateTo, roomTypeId, numberOfPlaces);
    }
}
