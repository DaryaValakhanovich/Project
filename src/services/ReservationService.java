package services;

import entity.Reservation;

public class ReservationService{

    private static ReservationService INSTANCE = null;

    private ReservationService() {
    }

    public static ReservationService getInstance() {
        if (INSTANCE == null) {
            synchronized (ReservationService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ReservationService();
                }
            }
        }
        return INSTANCE;
    }

    public double getCost(Reservation r){
        return r.getRoom().getType().getCostForOneNight()
                *r.getRoom().getNumberOfPlaces()
                *r.getDayOfArrival().until(r.getDayOfDeparture()).getDays();
    }
}
