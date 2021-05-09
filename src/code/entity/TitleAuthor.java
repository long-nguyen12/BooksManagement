package code.entity;

import java.io.Serializable;

public class TitleAuthor implements Serializable {
    
    private Book book;
    private Author author;
    private int authorOrder;

    public TitleAuthor() {
    }

    public TitleAuthor(Book book, Author author, int authorOrder) {
        this.book = book;
        this.author = author;
        this.authorOrder = authorOrder;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

     

    public int getAuthorOrder() {
        return authorOrder;
    }

    public void setAuthorOrder(int authorOrder) {
        this.authorOrder = authorOrder;
    }
    
    
}
