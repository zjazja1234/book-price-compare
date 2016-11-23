package com.bookcompare.controllers;

import com.bookcompare.entities.Book;
import com.bookcompare.services.BookComparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Raymond on 18/11/2016.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
//        model.addAttribute("message", "Hello, Robot.");
        return "home/index";
    }
    @RequestMapping(value = "/search/{keyword}", method = RequestMethod.POST)
    public @ResponseBody List<Book> search(@PathVariable("keyword") String keyword) {
        if(keyword != null && keyword.trim() != "") {
            return new BookComparator(keyword.trim()).getComparableBooks();
        } else {
            return new ArrayList<Book>();
        }

    }
}
