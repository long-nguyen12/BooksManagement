
package code.controller;

import code.dal.BookDAO;
import code.entity.Book;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BookController {
    
    private BookDAO bookDAO;
    
    public BookController() {
        bookDAO = new BookDAO();
    }
    
    public void add(Book b) throws Exception {
        bookDAO.addBook(b);
    }
    
    public void list(JTable tblBook) throws Exception {
        DefaultTableModel model = (DefaultTableModel) tblBook.getModel();
        model.setRowCount(0);
        List<Book> books = bookDAO.selectAll();
        books.forEach(b -> model.addRow(b.toDataRow()));
    }
    
    public void search(String column, String keyword,JTable tblBook) throws Exception {
        DefaultTableModel model = (DefaultTableModel) tblBook.getModel();
        model.setRowCount(0);
        List<Book> books = bookDAO.select(column, keyword);
        books.forEach(b -> model.addRow(b.toDataRow()));
    }
    
    public Book getBookByBookID(String bookID)throws Exception {
        return bookDAO.getBookByBookID(bookID);
    }
    
    public void editBook(Book b)throws Exception  {
        bookDAO.editBook(b);
    }
    
    public void deleteBook(String bookID)throws Exception  {
        bookDAO.deleteBook(bookID);
    }
}
