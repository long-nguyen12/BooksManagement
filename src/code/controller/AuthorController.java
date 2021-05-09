package code.controller;

import code.dal.AuthorDAO;
import code.entity.Author;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class AuthorController {

    private AuthorDAO authorDAO;

    public AuthorController() {
        authorDAO = new AuthorDAO();
    }

    public boolean addAuthor(JDialog root, Author author) throws Exception {
        if (!authorDAO.isValidAuthor(author)) {
            authorDAO.addAuthor(author);
            return true;
        } else {
            JOptionPane.showConfirmDialog(root, "Registered phone already in use");
            return false;
        }
    }

    public void updateAuthor(Author author) throws Exception {
        authorDAO.updateAuthor(author);
    }

}
