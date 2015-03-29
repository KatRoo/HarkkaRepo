
package ohtu.data_access;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import ohtu.domain.User;

/**
 *
 * @author Katri Roos
 */
public class FileUserDAO implements UserDao{
    
     private List<User> users;
     String tiedostonnimi;

    public FileUserDAO(String tiedostonnimi) {
        this.tiedostonnimi = tiedostonnimi;
        users = new ArrayList<User>();
        lukeminen(tiedostonnimi);
    }        

    public void lukeminen(String tiedosto)   {
        Object o = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(tiedosto);
            ois = new ObjectInputStream(fis);

            while((o = ois.readObject()) != null) {
                    if(o instanceof User && !users.contains(o))   {    
                        users.add((User)o);
                    }
                    
            }
        } catch(Exception e) {
                System.out.println(e);
        } finally {
            if(ois != null) {
                    try {
                            ois.close();
                    } catch(Exception e) {
                            System.out.println(e);
                    }
            }
        }
        
    }
    
    public void kirjoitus(User o) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(tiedostonnimi);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(o);
        } catch(Exception e) {
                System.out.println(e);
        } finally {
            if(oos != null) {
                    try {
                            oos.close();
                    } catch(Exception e) {
                            System.out.println(e);
                    }
            }
        }
    }
    
    @Override
    public List<User> listAll() {
        return users;
    }

    @Override
    public User findByName(String name) {
        for (User user : users) {
            if (user.getUsername().equals(name)) {
                return user;
            }
        }

        return null;
    }

    @Override
    public void add(User user) {
        kirjoitus(user);
        lukeminen(tiedostonnimi);
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }
    
}
