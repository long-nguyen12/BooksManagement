package code.dal;

import code.context.DBContext;
import code.entity.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersDAO {

    public List<Users> selectAll() throws Exception {
        String query = " select * from Users ";
        Connection con = new DBContext().getConnection();
        PreparedStatement ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();
        List<Users> users = new ArrayList<>();
        while (rs.next()) {
            String userName = rs.getString("username");
            String displayName = rs.getString("displayname");
            String password = rs.getString("password");
            String description = rs.getString("description");
            users.add(new Users(userName, displayName, password, description));
        }
        rs.close();
        con.close();
        return users;
    }

    public Users getUserByUsername(String username) throws Exception {
        String query = " select * from Users where username = ?";
        Connection con = new DBContext().getConnection();
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        Users user = null;
        if (rs.next()) {
            String userName = rs.getString("username");
            String displayName = rs.getString("displayname");
            String password = rs.getString("password");
            String description = rs.getString("description");
            user = new Users(userName, displayName, password, description);
        }
        rs.close();
        con.close();
        return user;
    }

    public boolean validUser(Users x) throws Exception {
        List<Users> users = selectAll();

        Optional<Users> match = users.stream()
            .filter(u -> u.getUsername().equalsIgnoreCase(x.getUsername())
            && u.getPassword().equals(x.getPassword())).findFirst();
        return match.isPresent();
    }

    public void addUser(Users user) throws SQLException, Exception {
        String insert = " insert into users values(?,?,?,?)";
        Connection con = new DBContext().getConnection();
        PreparedStatement ps = con.prepareStatement(insert);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getDisplayName());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getDescription());
        ps.executeUpdate();
        con.close();
    }

    public boolean isValidUser(Users user) throws Exception {
        List<Users> users = selectAll();
        Optional<Users> match = users.stream()
            .filter(u -> u.getUsername().equalsIgnoreCase(user.getUsername()))
            .findFirst();
        return match.isPresent();
    }

    public void updateUser(Users user) throws SQLException, Exception {
         String insert = " update users set displayname = ?, password = ?, "
             + " description = ? where username = ?";
        Connection con = new DBContext().getConnection();
        PreparedStatement ps = con.prepareStatement(insert);
        ps.setString(1, user.getDisplayName());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getDescription());
        ps.setString(4, user.getUsername());
        ps.executeUpdate();
        con.close();
    }
}
