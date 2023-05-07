import java.util.ArrayList;

class Member {
  public String id;
  public String name;
  public ArrayList<Book> borrowedBooks = new ArrayList<Book>();
  
public Book[] getBorrowedList(){
  Book[] bookArrayBooks = new Book[borrowedBooks.size()];
  int i = 0;
  for (Book book : borrowedBooks){
    bookArrayBooks[i++] = book;
  }
  return bookArrayBooks;
}

  //berfungsi untuk memidahkan arrays ke arrays yang lain
  public void receiveBook(Book book) {
    this.borrowedBooks.add(book);
  }

  //menghapus nilai dari arrays
  public void giveBook(Book book) {
    this.borrowedBooks.remove(book);
  }
}