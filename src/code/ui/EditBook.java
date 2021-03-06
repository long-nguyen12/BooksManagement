package code.ui;

import code.dal.AuthorDAO;
import code.dal.PublisherDAO;
import code.entity.Author;
import code.entity.Book;
import code.entity.Publisher;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.util.List;
import javax.swing.JOptionPane;

public class EditBook extends javax.swing.JDialog {

    MyBook myBook;
    DefaultListModel<Author> modelAvailabeleAuthor;
    DefaultListModel<Author> modelSelectedAuthor;
    DefaultComboBoxModel<Publisher> modelPublishers;
    Book book;

    public void listAuthors() {
        try {
            List<Author> authors = new AuthorDAO().selectAll();
            authors.forEach(a -> modelAvailabeleAuthor.addElement(a));
        } catch (Exception ex) {
            Logger.getLogger(EditBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void listPublishers() {
        try {
            List<Publisher> publishers = new PublisherDAO().selectAll();
            publishers.forEach(p -> modelPublishers.addElement(p));
        } catch (Exception ex) {
            Logger.getLogger(EditBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showBook(String bookID) {
        try {
            book = myBook.bookController.getBookByBookID(bookID);
            txtBookID.setText(book.getId());
            txtBookTitle.setText(book.getTitle());
            txtNote.setText(book.getNote());
            cboPublisher.setSelectedItem(book.getPub());
            List<Author> authors = book.getAuthors();
            authors.forEach(a -> {
                modelSelectedAuthor.addElement(a);
                modelAvailabeleAuthor.removeElement(a);
            });
        } catch (Exception ex) {
            Logger.getLogger(EditBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public EditBook(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        myBook = (MyBook) parent;
        lstAvailableAuthors.setModel(modelAvailabeleAuthor = new DefaultListModel<>());
        lstSelectedAuthors.setModel(modelSelectedAuthor = new DefaultListModel<>());
        cboPublisher.setModel(modelPublishers = new DefaultComboBoxModel<>());
        listAuthors();
        listPublishers();
        showBook(myBook.getSelectedBookID());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtBookID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtBookTitle = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cboPublisher = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNote = new javax.swing.JTextArea();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstAvailableAuthors = new javax.swing.JList();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstSelectedAuthors = new javax.swing.JList();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnAddPublisher = new javax.swing.JButton();
        btnAddAuthor = new javax.swing.JButton();
        btnEditPublisher = new javax.swing.JButton();
        btnEditAuthor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel1.setText("Book ID");

        txtBookID.setEditable(false);
        txtBookID.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("*");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel3.setText("Book Title");

        txtBookTitle.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("*");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel5.setText("Publisher");

        cboPublisher.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel6.setText("Notes");

        txtNote.setColumns(20);
        txtNote.setRows(5);
        jScrollPane1.setViewportView(txtNote);

        btnSave.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        btnSave.setText("Update");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 51));
        jLabel7.setText("*:required field");

        lstAvailableAuthors.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(lstAvailableAuthors);

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel8.setText("Available Authors");

        lstSelectedAuthors.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(lstSelectedAuthors);

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel9.setText("Selected Authors");

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 51));
        jLabel10.setText("*");

        btnAdd.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        btnAdd.setText(">");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemove.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        btnRemove.setText("<");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnClose.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnAddPublisher.setText("+");
        btnAddPublisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPublisherActionPerformed(evt);
            }
        });

        btnAddAuthor.setText("+");
        btnAddAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAuthorActionPerformed(evt);
            }
        });

        btnEditPublisher.setText("Edit");
        btnEditPublisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditPublisherActionPerformed(evt);
            }
        });

        btnEditAuthor.setText("Edit");
        btnEditAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditAuthorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBookTitle)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtBookID)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2)
                                        .addGap(181, 181, 181)))
                                .addGap(47, 47, 47))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnEditAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnAddAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel9)
                                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))))
                                        .addContainerGap())
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cboPublisher, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnEditPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnAddPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(47, 47, 47))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(btnSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnClose)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(16, 16, 16))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnEditAuthor, btnEditPublisher});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddAuthor, btnAddPublisher});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBookID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtBookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(cboPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAddPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRemove)
                                .addGap(20, 20, 20))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                .addGap(6, 6, 6)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(84, 84, 84))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSave)
                        .addComponent(btnDelete)
                        .addComponent(btnClose)))
                .addGap(23, 23, 23))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //when users click on delete button
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            if (myBook.getUser().getUsername().equalsIgnoreCase(book.getUser().getUsername())) {
                if (JOptionPane.showConfirmDialog(this, "Do you wanna delete this book",
                    "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    myBook.bookController.deleteBook(txtBookID.getText());
                    JOptionPane.showMessageDialog(this, "A Book "
                        + txtBookID.getText() + " has been deleted");
                    dispose();
                    myBook.showAllBooks();
                }
            } else {
                JOptionPane.showMessageDialog(this, "You don't have permission "
                    + "to delete this book");
            }

        } catch (Exception ex) {
            Logger.getLogger(EditBook.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    public boolean validBook(Book b) throws Exception {
        if (b.getTitle().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Book title cannot be empty",
                "Alert", JOptionPane.ERROR_MESSAGE);
            txtBookTitle.requestFocus();
            return false;
        }
        if (modelSelectedAuthor.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Authors cannot be empty",
                "Alert", JOptionPane.ERROR_MESSAGE);
            lstAvailableAuthors.setSelectedIndex(0);
            return false;
        }
        return true;
    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            String bookID = txtBookID.getText().trim();
            String bookTitle = txtBookTitle.getText().trim();
            Publisher pub = ((Publisher) cboPublisher.getSelectedItem());
            String notes = txtNote.getText().trim();
            List<Author> authors = Collections.list(modelSelectedAuthor.elements());
            Book book = new Book(bookID, bookTitle, notes, pub, authors);
            if (validBook(book)) {
                myBook.bookController.editBook(book);
                JOptionPane.showMessageDialog(this, "Update book successfully");
                myBook.showAllBooks();
            }
        } catch (Exception ex) {
            Logger.getLogger(EditBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed
  
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
     
        int selectedRow = lstAvailableAuthors.getSelectedIndex();
        if (selectedRow != -1) {
            modelSelectedAuthor.addElement(modelAvailabeleAuthor.get(selectedRow));
            modelAvailabeleAuthor.remove(selectedRow);
        }
    }//GEN-LAST:event_btnAddActionPerformed
    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        int selectedRow = lstSelectedAuthors.getSelectedIndex();
        if (selectedRow != -1) {
            modelAvailabeleAuthor.addElement(modelSelectedAuthor.get(selectedRow));
            modelSelectedAuthor.remove(selectedRow);
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnAddPublisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPublisherActionPerformed
        // TODO add your handling code here:
        AddPublisher addPublisher = new AddPublisher(this, false);
        addPublisher.setPublishersModel(modelPublishers);
        addPublisher.setVisible(true);
    }//GEN-LAST:event_btnAddPublisherActionPerformed

    private void btnAddAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAuthorActionPerformed
        AddAuthor addAuthor = new AddAuthor(this, false);
        addAuthor.setAvailabeleAuthorModel(modelAvailabeleAuthor);
        addAuthor.setVisible(true);
    }//GEN-LAST:event_btnAddAuthorActionPerformed

    private void btnEditPublisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditPublisherActionPerformed
        // TODO add your handling code here:
        Publisher p = (Publisher) cboPublisher.getSelectedItem();
        EditPublisher editPublisher = new EditPublisher(this, false);
        editPublisher.setPublisher(p,modelPublishers, cboPublisher);
        editPublisher.setVisible(true);
    }//GEN-LAST:event_btnEditPublisherActionPerformed

    private void btnEditAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditAuthorActionPerformed
        int selectedRow = lstAvailableAuthors.getSelectedIndex();
        if (selectedRow != -1) {
            Author author = (Author) lstAvailableAuthors.getSelectedValue();
            EditAuthor editAuthor = new EditAuthor(this, false);
            editAuthor.setAuthor(author, modelAvailabeleAuthor, lstAvailableAuthors);
            editAuthor.setVisible(true);
        }else{
        JOptionPane.showMessageDialog(this, "Please, select one");
        }
    }//GEN-LAST:event_btnEditAuthorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Logger.getLogger(EditBook.class.getName()).log(Level.SEVERE, null, ex);
            }
            EditBook dialog = new EditBook(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddAuthor;
    private javax.swing.JButton btnAddPublisher;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEditAuthor;
    private javax.swing.JButton btnEditPublisher;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cboPublisher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList lstAvailableAuthors;
    private javax.swing.JList lstSelectedAuthors;
    private javax.swing.JTextField txtBookID;
    private javax.swing.JTextField txtBookTitle;
    private javax.swing.JTextArea txtNote;
    // End of variables declaration//GEN-END:variables
}
