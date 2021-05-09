package code.controller;

import code.dal.PublisherDAO;
import code.entity.Publisher;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class PublisherController {

    private PublisherDAO publisherDAO;

    public PublisherController() {
        publisherDAO = new PublisherDAO();
    }

    public String addPublisher(JDialog root, Publisher p) throws Exception {
        if (!publisherDAO.isValidPublisher(p)) {
            return publisherDAO.addPublisher(p);
        } else {
            JOptionPane.showConfirmDialog(root, "Registered name already in use");
            return null;
        }

    }

    public void updatePublisher(Publisher p) throws Exception {
        publisherDAO.updatePublisher(p);
    }
}
