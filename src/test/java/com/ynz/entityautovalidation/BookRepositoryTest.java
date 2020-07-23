package com.ynz.entityautovalidation;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

@DataJpaTest(showSql = false)
@Slf4j
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void whenMissingPublishingDate_EntityValidationThrowException() {
        Book book = new Book();

        book.setPublishingDate(new Date());
        //book.setTitle("my book");



        bookRepository.save(book);
    }

}