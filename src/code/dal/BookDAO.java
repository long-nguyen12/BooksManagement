package code.dal;

import code.context.DBContext;
import code.entity.Author;
import code.entity.Book;
import code.entity.Publisher;
import code.entity.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public void deleteBook(String bookID) throws Exception {
        String delete = " delete from TitleAuthor where title_id = ? ";
        Connection con = new DBContext().getConnection();
        PreparedStatement ps = con.prepareStatement(delete);
        ps.setString(1, bookID);
        ps.executeUpdate();
        ps.close();
        String deleteFromBooks = "delete from books where title_id = ?";
        ps = con.prepareStatement(deleteFromBooks);
        ps.setString(1, bookID);
        ps.executeUpdate();
        ps.close();
        con.close();
    }

    public void editBook(Book b) throws Exception {
        String update = " update Books set title = ?, pub_id = ?, notes = ? where "
            + " title_id = ? ";
        Connection con = new DBContext().getConnection();
        PreparedStatement ps = con.prepareStatement(update);
        ps.setString(1, b.getTitle());
        ps.setString(2, b.getPub().getId());
        ps.setString(3, b.getNote());
        ps.setString(4, b.getId());
        ps.executeUpdate();
        ps.close();
        String delete = "delete from TitleAuthor where title_id = ?";
        ps = con.prepareStatement(delete);
        ps.setString(1, b.getId());
        ps.executeUpdate();
        ps.close();
        List<Author> authors = b.getAuthors();
        for (int i = 0; i < authors.size(); i++) {
            Author a = authors.get(i);
            String insert = "insert into TitleAuthor values(?,?,?)";
            PreparedStatement p = con.prepareStatement(insert);
            p.setString(1, a.getId());
            p.setString(2, b.getId());
            p.setInt(3, i);
            p.executeUpdate();
            p.close();

        }

        con.close();
    }

    public void addBook(Book b) throws Exception {
        String insert = " insert into Books values(?,?,?,?,?)";
        Connection con = new DBContext().getConnection();
        PreparedStatement ps = con.prepareStatement(insert);
        ps.setString(1, b.getId());
        ps.setString(2, b.getTitle());
        ps.setString(3, b.getPub().getId());
        ps.setString(4, b.getNote());
        ps.setString(5, b.getUser().getUsername());
        ps.executeUpdate();
        ps.close();
        List<Author> authors = b.getAuthors();
        for (int i = 0; i < authors.size(); i++) {
            Author a = authors.get(i);
            insert = "insert into TitleAuthor values(?,?,?)";
            PreparedStatement p = con.prepareStatement(insert);
            p.setString(1, a.getId());
            p.setString(2, b.getId());
            p.setInt(3, i);
            p.executeUpdate();
            p.close();

        }

        con.close();
    }

    public Book getBookByBookID(String bookID) throws Exception {
        String select = " select * from Books where title_id = ? ";
        Connection con = new DBContext().getConnection();
        PreparedStatement ps = con.prepareStatement(select);
        ps.setString(1, bookID);
        ResultSet rs = ps.executeQuery();
        PublisherDAO pubDAO = new PublisherDAO();
        AuthorDAO authorDAO = new AuthorDAO();
        UsersDAO usersDAO = new UsersDAO();
        Book books = null;
        while (rs.next()) {
            String id = rs.getString("title_id");
            String title = rs.getString("title");
            String pubId = rs.getString("pub_id");
            String note = rs.getString("notes");
            String userName = rs.getString("username");
            Publisher pub = pubDAO.getPublisherByID(pubId);
            List<Author> authors = authorDAO.selectAuthorsByBookID(id);
            Users user = usersDAO.getUserByUsername(userName);
            books = new Book(id, title, note, pub, authors, user);
        }
        rs.close();
        con.close();
        return books;
    }

    public List<Book> select(String columnName, String keyword) throws Exception {
        String select = " select distinct Books.* from Books, Publishers, Authors,"
            + " TitleAuthor where Books.pub_id = Publishers.pub_id and "
            + " Books.title_id = TitleAuthor.title_id and TitleAuthor.au_id = Authors.au_id and ";
        select += columnName + " like '%" + keyword + "%'";
        Connection con = new DBContext().getConnection();
        PreparedStatement ps = con.prepareStatement(select);
        ResultSet rs = ps.executeQuery();
        List<Book> books = new ArrayList<>();
        PublisherDAO pubDAO = new PublisherDAO();
        AuthorDAO authorDAO = new AuthorDAO();
        while (rs.next()) {
            String id = rs.getString("title_id");
            String title = rs.getString("title");
            String pubId = rs.getString("pub_id");
            String note = rs.getString("notes");
            // Get publisher of the book
            Publisher pub = pubDAO.getPublisherByID(pubId);
            List<Author> authors = authorDAO.selectAuthorsByBookID(id);
            books.add(new Book(id, title, note, pub, authors));
        }
        rs.close();
        con.close();
        return books;
    }

    public List<Book> selectAll() throws Exception {
        String query = " select * from Books";
        Connection con = new DBContext().getConnection();
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Book> books = new ArrayList<>();
        PublisherDAO pubDAO = new PublisherDAO();
        AuthorDAO authorDAO = new AuthorDAO();
        while (rs.next()) {
            String id = rs.getString("title_id");
            String title = rs.getString("title");
            String pubId = rs.getString("pub_id");
            String note = rs.getString("notes");
            Publisher pub = pubDAO.getPublisherByID(pubId);
            List<Author> authors = authorDAO.selectAuthorsByBookID(id);
            books.add(new Book(id, title, note, pub, authors));
        }
        rs.close();
        con.close();
        return books;
    }
}
