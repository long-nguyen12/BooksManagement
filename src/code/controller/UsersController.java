package code.controller;

import code.dal.UsersDAO;
import code.entity.Users;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class UsersController {

    private UsersDAO usersDAO;

    public UsersController() {
        usersDAO = new UsersDAO();
    }
     
    public void addUser(JDialog root,Users user) throws Exception{
        if (!usersDAO.isValidUser(user)) {
        usersDAO.addUser(user);
        }else{
            JOptionPane.showConfirmDialog(root, "Registered name already in use");
        }
    }
    
    public void updateUser(Users user) throws Exception{
        usersDAO.updateUser(user);
    }
}
