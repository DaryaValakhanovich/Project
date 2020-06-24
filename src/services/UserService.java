package services;

import dao.UserDao;
import entity.User;

public class UserService{
    private static UserService INSTANCE = null;

    private UserService() {
    }

    public static UserService getInstance() {
        if (INSTANCE == null) {
            synchronized (UserService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UserService();
                }
            }
        }
        return INSTANCE;
    }

    public void addAdmin(User user) {
        UserDao.getInstance().addAdmin(user.getId());
    }

    public void createNewUser(User user){
        UserDao.getInstance().create(user);
    }
}
