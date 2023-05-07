import java.util.ArrayList;

class library extends Book{
  public ArrayList<Book> books = new ArrayList<>();
  public ArrayList<Member> members = new ArrayList<Member>();
  public String title;
  public String id;
  
  public void addbook(Book book){
    //akan di cek apakah book tidak memiliki id yang sama
    if (!isBookIdExist(book.id)) {
      this.books.add(book);
      System.out.println("Book added successfully.");
  } else {
      System.out.println("Book with ID " + book.id + " already exists.");
  }
}
  
  //pengecekan jika ada nilai yang sama
  public Boolean isBookIdExist(String id) {
    Boolean isExist = false;
    for (Book book : this.books) {
      if (book.id.equals(id)) {
        isExist = true;
      }
    }
    return isExist;
  }

  public void addMember(Member member) {
    //akan di cek apakah member tidak memiliki id yang sama
    if (!isMemberIdExist(member.id)) {
      this.members.add(member);
      System.out.println("Member added successfully.");
  } else {
      System.out.println("Member with ID " + member.id + " already exists.");
  }
}

  //pengecekan jika ada nilai yang sama
  public Boolean isMemberIdExist(String id) {
    Boolean isExist = false;
    for (Member member : this.members) {
      if (member.id.equals(id)) {
        isExist = true;
      }
    }
    return isExist;
  }

  //giveBook berfungsi untuk meminjamkan buku ke member
  public void giveBook(String memberId, String bookId) {
    Book book = this.getBookById(bookId, books);
    this.books.remove(book);

    Member member = this.getMemberById(memberId);
    int memberIndex = this.getMemberIndex(member);
    this.members.get(memberIndex).receiveBook(book);
  }

  //mengembalikan buku yang telah dipinjam
  public void receiveBook(String memberId, String bookId) {
    Member member = this.getMemberById(memberId);
    int memberIndex = this.getMemberIndex(member);
    
    Book book = this.getBookById(bookId, member.borrowedBooks);
    this.books.add(book);
    this.members.get(memberIndex).giveBook(book);
  }

  //mengembalikan nilai dari index member yang ingin dicari
  private int getMemberIndex(Member member) {
    return this.members.indexOf(member);
  }

  private Member getMemberById(String id) {
    //melakukan pengulangan untuk mengecek member yang ada di list
    for (Member member : this.members) {
      //pengeekan jika member yang dicari memiliki id yang sama
      if (member.id.equals(id)) {
        //mengembalikan member
        return member;
      }
    }
    //mengembalikan nilai null kita tidak ada ID yang dicari
    return null;
  }

  private Book getBookById(String id, ArrayList<Book> List) {
    //melakukan pengulangan untuk mengecek buku yang ada di list
    for (Book book : List) {
      //pengecekan jika buku yang dicari memiliki id yang sama
      if (book.id.equals(id)) {
        //mengembalikan buku
        return book;
      }
    }
    //mengembalikan nilai null kita tidak ada ID yang dicari
    return null;
  }
}