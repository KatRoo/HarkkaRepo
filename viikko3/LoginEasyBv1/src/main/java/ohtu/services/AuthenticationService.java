package ohtu.services;

import ohtu.domain.User;
import ohtu.data_access.UserDao;
import org.apache.commons.lang.StringUtils;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        
        if(username.length() > 2 && StringUtils.isAlpha(username) && 
                password.length() > 7 && !StringUtils.isAlpha(password) )   {
            
            return false;
        }

        return true;
    }
}
