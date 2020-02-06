package cz.sos.jh.controller;

import cz.sos.jh.model.Book;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

;

@RestController
public class BookController {
    JdbcTemplate jdbcTemplate;

    public BookController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/customer/info")
    public Book getBookInfo() {
        List<Book> books = jdbcTemplate.query(
                "SELECT id, autor, vydavatel, jazyk FROM book",
                new BeanPropertyRowMapper<>(Book.class));

        int pocetKnih = books.size();
        List<String> autori = new ArrayList<>();
        List<String> vydavatele = new ArrayList<>();

        for (Book book : books) {
            autori.add(book.getAutor());
            vydavatele.add(book.getVydavatel());
        }

        Book bookInfo = new Book();
        bookInfo.setPocetKnih(pocetKnih);
        bookInfo.setAutor(String.valueOf(autori));
        bookInfo.setVydavatel(String.valueOf(vydavatele));

        return getBookInfo();
    }

    @GetMapping("/customer/{id}")
    public Book getCustomer(@PathVariable Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT id, autor, vydavatel, jazyk FROM book WHERE id = ?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class));
    }

    @PostMapping("/book")
    public ResponseEntity<Book> createCustomer(@RequestBody Book book) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO book (autor, datum_vydani, vydavatel) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, book.getAutor());
            preparedStatement.setString(2, book.getDatum_vydani());
            preparedStatement.setString(3, book.getVydavatel());

            return preparedStatement;
        }, keyHolder);
        
        return new ResponseEntity<>(getBookInfo(),
                HttpStatus.CREATED);
    }

    @PutMapping("/book/{id}")
    public Book updateBook(@PathVariable Long id,
                               @RequestBody Book book) {
        jdbcTemplate.update(
                "UPDATE book SET nazev = ?, autor = ?, jazyk = ? WHERE id = ?",
                book.getNazev(), book.getAutor(), book.getJazyk(), id);

        return getBookInfo();
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity deleteBook(@PathVariable Long id) {
        jdbcTemplate.update("DELETE FROM book WHERE id = ?", id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
