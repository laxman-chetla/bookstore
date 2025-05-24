package com.bookStore.bookStore.Controller;

import com.bookStore.bookStore.Entity.Book;
import com.bookStore.bookStore.Entity.MyBooks;
import com.bookStore.bookStore.Service.BookService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService serv;
@GetMapping("/")
   public String home(){
    return "home";
}
@GetMapping("/book_register")
    public String bookRegister(){
    return "bookRegister";
}
@GetMapping("/available_books")
public ModelAndView availableBooks() {
    List<Book> list= serv.getAllBooks();
    return new ModelAndView("availableBooks", "list", list);
    }

@GetMapping("/available_Books/addtomybooks/{id}")
    public String addToMyBooks(@PathVariable int id){
        Book myb=serv.getBookUsingId(id);
        serv.addToMyBooks(myb);
        return "redirect:/available_books";
    }
    @GetMapping("my_books")
public ModelAndView getmyBooks() {
    List<MyBooks> list= serv.getMyBooks();
    return new ModelAndView("myBooks","list",list);
}
@PostMapping("/save")
      public String saveBook(@ModelAttribute Book b){
      serv.save(b);
      return "redirect:/available_books";

  }
  //Note:for deletion also use @getmapping
  @GetMapping("/available_Books/delete/{id}")
    public String deleteBook(@PathVariable int id){
        serv.deleteBookUsingId(id);
        return "redirect:/available_books";
    }
@GetMapping("/My_Books/delete/{id}")
    public String deleteMyBook(@PathVariable int id){
        serv.deleteMyBookUsingId(id);
        return "redirect:/my_books";
    }
@GetMapping("/available_Books/update/{id}")
  public ModelAndView availableBookUpdate(@PathVariable int id){
    Book b=serv.GetBookById(id);

    return new ModelAndView("updateBook","book",b);


}// for updation take id from user then pass it as parameter to endpoint and then find the object using service and bring here and save in a new object and pass that to the view(html page of updation),there you first you have to keep id as hidden type,then for writing attributes you have two choices
//1)in each input tag you can directly write th:value="${modelname.datamember} in this way but remember dont use object u sent i.e b here model name means "book"
//2) you can use th:object="${modelname}" in the form tag and then use th:field="*{directly membervar name}" in each input tag



//always remember that when writing hyperlinks to endpoints(@get,put,post)from html pages,in html pages we should use th:href="@{"
//for showing data from table to html page we should use th:each="@{list}" and for showing data from each object to html page we should use th:text="${}"
    //for updating things when you send an object from endppint to the html page use th:object="${received object}" in heading of form and use th:value="${}"
}



//passing an object to html page from controllers is can be like "list",list or"classname",object
// u can send like in the above manner like modelandview(3param) or another way is create an object of book then do like did in old project