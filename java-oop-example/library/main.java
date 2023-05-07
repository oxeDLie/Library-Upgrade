import java.io.IOException;
import java.util.Scanner;

class Main {

  static Scanner scan = new Scanner(System.in);
  static library library = new library();

  public static void main(String[] args) {
    initLibraryData();

    String isContinue = "y";

    //While do digunakan untuk melakukan pengulangan jika user ingin memilih menu yang berbeda tanpa melakukan running berkali kali
    while (isContinue.equals("y")) {
      showMenu();
      int selectedMenu = chooseMenu();
    try {
      if (selectedMenu == 1) {
        showBooks();
      } else if (selectedMenu == 2) {
        showMembers();
      } else if (selectedMenu == 3) {
        addMember();
        
      } else if (selectedMenu == 4) {
        borrowBook();
      } else if (selectedMenu == 5) {
        returnBook();  
      } else if (selectedMenu == 6){
        addBook();
      } else {
        throw new IllegalArgumentException("wrong input");
      }
    } catch (Exception e){
        System.out.println("Error "+ e.getMessage());
      }
      System.out.print("continue ? ");
      isContinue = scan.next();
    }
  }

  //mencetak show menu
  public static void showMenu() {
    System.out.println("================================");
    System.out.println("1. show books list");
    System.out.println("2. show members list");
    System.out.println("3. add member");
    System.out.println("4. borrow book");
    System.out.println("5. return book");
    System.out.println("6. add book");
    System.out.println("================================");
  }

  //memberikan nilai ke arrays yang ada
  public static void initLibraryData() {
    Book book1 = new library();
    book1.id = "1";
    book1.title = "pemrograman java";

    Book book2 = new library();
    book2.id = "2";
    book2.title = "pemrograman oop";

    Book book3 = new library();
    book3.id = "3";
    book3.title = "pemrograman android";

    Member member1 = new Member();
    member1.id = "1";
    member1.name = "aka";

    Member member2 = new Member();
    member2.id = "2";
    member2.name = "budi";

    Member member3 = new Member();

    member3.id = "3";
    member3.name = "tono";

    library.books.add(book1);
    library.books.add(book2);
    library.books.add(book3);

    library.members.add(member1);
    library.members.add(member2);
    library.members.add(member3);
  }

  //untuk inputan pilihan Menu (While diatas)
  public static int chooseMenu() {
    System.out.print("choose menu : ");
    int pilihan = scan.nextInt();
    return pilihan;
  }

  //menampilkan buku yang tersedia
  public static void showBooks() {
    for (Book book : library.books) {
      System.out.println(book.id + " " + book.title);
    }
  }

  //menampilkan member yang ada
  public static void showMembers() {
    for (Member member : library.members) {
      System.out.println(member.id + " " + member.name);
    }
  }

  //melakukan input untuk menambahkan member
  public static void addMember() {
    Member member = new Member();

    System.out.print("id : ");
    member.id = scan.next();

    System.out.print("name : ");
    member.name = scan.next();
    //inputan akan dimasukan kedalam arrays Members
    library.addMember(member);
  }

  //melakukan inputan untuk menambahkan buku
  public static void addBook(){
    Book book = new library();

      System.out.print("id : ");
      book.id = scan.next();
  
      System.out.print("nama : ");
      book.title = scan.next();

      //memasukan inputan kedalam arrays book
    library.addbook(book);
  }

  public static void borrowBook() {
    System.out.print("id member : ");
    String memberId = scan.next();

    System.out.print("id book : ");
    String bookId = scan.next();

    library.giveBook(memberId, bookId);
  }

  public static void returnBook() {
    System.out.print("id member : ");
    String memberId = scan.next();

    System.out.print("id book : ");
    String bookId = scan.next();

    library.receiveBook(memberId, bookId);
  }
}