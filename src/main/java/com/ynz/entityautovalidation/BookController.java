package com.ynz.entityautovalidation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;

    @GetMapping("{id}")
    public Book getBookById(@PathVariable("id") Long id) {
        return bookRepository.findById(id).orElseGet(null);
    }

    /**
     *  Spring @Validated: applied on the method argument and method level
     *  Java  @Valid: applied on the method argument and method level.
     *
     *  difference: Spring @Validate can be used to validate constrain groups.
     *  A constrain group is validated before B constrain group.
     */
    @PostMapping("")
    @Valid
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }
}
