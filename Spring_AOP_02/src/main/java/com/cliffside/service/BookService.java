package com.cliffside.service;

import com.cliffside.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    /**
     * 结账：传入哪个用户买了哪本书
     *
     * @param username
     * @param id
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void checkout(String username, int id) {
        int price = bookDao.getPrice(id);
        bookDao.updateBalance(username, price);
        bookDao.updateStock(id);
        int j = 1/0;
    }

    /**
     * 修改价格
     * @param id
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void updatePrice(int id) {
        bookDao.updatePrice(id);
        //int j = 1/0;
    }
}

    /*
     * propagation:传播特性：表示不同的事务之间执行的关系
     * isolation:隔离级别：4种隔离级别，会引发不同的数据错乱问题
     * timeout：超时时间,
     * readonly：只读事务:如果配置了只读事务，那么在事务运行期间，不允许对数据进行修改，否则抛出异常
     *
     * 设置哪些异常不会回滚数据
     * noRollBackfor: noRollbackFor = {ArithmeticException.class}
     * noRollbackForClassName:
     *
     * 设置哪些异常回滚
     * rollBackfor:
     * rollbackForClassName
     * */

