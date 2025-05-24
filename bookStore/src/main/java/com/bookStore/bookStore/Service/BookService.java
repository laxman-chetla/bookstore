package com.bookStore.bookStore.Service;

import com.bookStore.bookStore.Entity.Book;
import com.bookStore.bookStore.Entity.MyBooks;
import com.bookStore.bookStore.Repository.BookRepository;
import com.bookStore.bookStore.Repository.MyBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
  @Autowired
  private BookRepository bRepo;
  @Autowired
  private MyBooksRepository mybRepo;


   public void save(Book b) {
        bRepo.save(b);
     }
   public List<Book>  getAllBooks(){
       return bRepo.findAll();
   }
   public void deleteBook(int id) {
       bRepo.deleteById(id);
   }
   public void deleteBookUsingId(int id){
         bRepo.deleteById(id);
   }

    public Book getBookUsingId(int id) {
       //if you use only findbyid then it will only say if it exists or not,but
        // when you add get method it will return the object
        return bRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public void addToMyBooks(Book b) {
        MyBooks myb = new MyBooks();


        myb.setName(b.getName());
        myb.setAuthor(b.getAuthor());
        myb.setPrice(b.getPrice());
        mybRepo.save(myb);
    }

    public List<MyBooks> getMyBooks() {
       return mybRepo.findAll();
    }

    public void deleteMyBookUsingId(int id) {
        mybRepo.deleteById(id);
    }

    public Book GetBookById(int id) {
        return bRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }
}
