package com.leo.springbootssm.web;

import com.leo.springbootssm.entity.Book;
import com.leo.springbootssm.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by hisen on 17-4-24.
 */
@Controller
@RequestMapping("/book")
public class BookController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;

    @RequestMapping()
    public String index(){
        return  "index";
    }

    @RequestMapping(value = "/findbook", method = RequestMethod.GET)
    @ResponseBody
    private Book findbook(Model model) {
        Book book = bookService.getList(0, 1000).get(0);
        return book;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private String list(Model model) {
        List<Book> list = bookService.getList(0, 1000);
        model.addAttribute("list", list);
        // WEB-INF/jsp/"list".jsp 返回的list映射到此目录下的jsp文件
        return "list";
    }

    @RequestMapping(value = "/detail/{bookId}", method = RequestMethod.GET)
    private String detail(@PathVariable("bookId") Long bookId, Model model) {
        Book book = bookService.getById(bookId);
        model.addAttribute("book", book);
        return "detail";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    private String add(Book book) {
        logger.info("add req: " + book.toString());
        Book hasBook = bookService.getById(book.getBookId());
        int i = -2;
        if (hasBook == null) {
            i = bookService.addBook(book);
        }
        String res = i > 0 ? "success" : "error";
        logger.info("add res: " + res);
        return res;
    }

    @RequestMapping(value = "/del/{bookId}", method = RequestMethod.GET)
    @ResponseBody
    private String deleteBookById(@PathVariable("bookId") Long id) {
        int i = bookService.deleteBookById(id);
        return i > 0 ? "success" : "error";
    }
}
