package com.ynz.entityautovalidation;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
@RequiredArgsConstructor
public class EntityAutoValidationApplication implements CommandLineRunner {
    private final BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(EntityAutoValidationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Date date = new Date();

        Book book = new Book();
        book.setTitle("my book");
        book.setPublishingDate(date);

        bookRepository.save(book);
    }
}
