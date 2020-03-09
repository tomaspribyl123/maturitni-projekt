package cz.sos.jh.controller;

import cz.sos.jh.model.Book;

import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
class EmployeeController {

    private final BookRepository repository;

    EmployeeController(BookRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/books")
    List<Book> all() {
        return repository.findAll();
    }

    @PostMapping("/book")
    Book newBook(@RequestBody Book newBook) {
        return repository.save(newBook);
    }

    @PutMapping("/book/{id}")
    Book replaceBook(@RequestBody Book newBook, @PathVariable Long id) {

        return repository.findById(id)
                .map(book -> {
                    book.setNazev(newBook.getNazev());
                    book.setAutor(newBook.getAutor());
                    return repository.save(book);
                })
                .orElseGet(() -> {
                    newBook.setId(id);
                    return repository.save(newBook);
                });
    }

    @DeleteMapping("/book/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}