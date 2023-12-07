package dasturlash.uz.controller;

import dasturlash.uz.container.ComponentContainer;
import dasturlash.uz.service.BookService;
import dasturlash.uz.service.StudentBookService;
import dasturlash.uz.util.ScannerService;

public class StudentController {
    private StudentBookService studentBookService;
    private BookService bookService;
    private ComponentContainer componentContainer;
    private ScannerService scannerService;
    public void start() {
        System.out.println("Mazgi you must return the following books:");
        studentBookService.booksOnHand();
        boolean loop = true;
        while (loop) {
            showMenu();
            int action = scannerService.getAction();
            switch (action) {
                case 1:
                    bookService.all();
                    break;
                case 2:
                    search();
                    break;
                case 3:
                    takeBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    studentBookService.booksOnHand();
                    break;
                case 6:
                    studentBookService.takenBookHistory();
                    break;
                case 0:
                    loop = false;
                    break;
                default:
                    System.out.println("Mazgi bu hatoku.");
            }

        }

    }

    public void showMenu() {
        System.out.println("*** Student Menu ***");
        System.out.println("1. BookList");
        System.out.println("2. Search");
        System.out.println("3. Take book");
        System.out.println("4. Return book");
        System.out.println("5. Books on hand");
        System.out.println("6. Take book history");
        System.out.println("0. Exit");
    }


    public void search() {
        System.out.print("Enter query:");
        String query = componentContainer.getScannerText().next();
        bookService.search(query);
    }

    public void takeBook() {
        System.out.print("Enter book Id:");
        Integer bId = componentContainer.getScannerNumber().nextInt();
        studentBookService.takeBook(bId);
    }

    private void returnBook() {
        System.out.print("Enter book Id:");
        Integer bId = componentContainer.getScannerNumber().nextInt();
        studentBookService.returnBook(bId);
    }

    public void setStudentBookService(StudentBookService studentBookService) {
        this.studentBookService = studentBookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public void setComponentContainer(ComponentContainer componentContainer) {
        this.componentContainer = componentContainer;
    }
    public void setScannerService(ScannerService scannerService) {
        this.scannerService = scannerService;
    }
}
