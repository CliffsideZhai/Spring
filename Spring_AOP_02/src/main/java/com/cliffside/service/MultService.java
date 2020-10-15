package com.cliffside.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MultService {
    @Autowired
    BookService bookService;

    @Transactional
    public void mult(){
        try {
            bookService.checkout("lisi", 1);
        }catch (Exception e){
            e.printStackTrace();
        }
        bookService.updatePrice(3);
        //int i = 1/0;
    }
}
