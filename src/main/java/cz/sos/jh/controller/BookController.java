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


@RestController
public class BookController {
    JdbcTemplate jdbcTemplate;

    public BookController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/book/info")
    public Book getBookInfo() {
        List<Book> books = jdbcTemplate.query(
                "SELECT id, nazev, autor, zanr,rok_vydani,jazyk,vydavatel FROM knihy",
                new BeanPropertyRowMapper<>(Book.class));


        List<String> autori = new ArrayList<>();
        List<String> vydavatele = new ArrayList<>();

        for (Book book : books) {
            autori.add(book.getAutor());
            vydavatele.add(book.getVydavatel());
        }

        Book bookInfo = new Book();
        bookInfo.setAutor(String.valueOf(autori));
        bookInfo.setVydavatel(String.valueOf(vydavatele));

        return getBookInfo();
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT id, nazev, autor, zanr FROM knihy WHERE id = ?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class));
    }
    @PutMapping("/book/{id}")
    public ResponseEntity updateBook(@PathVariable Long id,
                                     @RequestBody Book book) {
        jdbcTemplate.update(
                "UPDATE book SET nazev = ?, autor = ?, zanr= ?, rok_vydani=?, jazyk = ?, vydavatel = ? WHERE id = ?",
                book.getNazev(), book.getAutor(),book.getZanr(),book.getRok_vydani(), book.getJazyk(),book.getVydavatel(), id);

        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
    @PostMapping("/book")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO knihy (nazev, autor, zanr, rok_vydani, jazyk, vydavatel) VALUES (?, ?, ? , ? , ? , ?)",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, book.getNazev());
            preparedStatement.setString(2, book.getAutor());
            preparedStatement.setString(3, book.getZanr());
            preparedStatement.setString(4, book.getRok_vydani());
            preparedStatement.setString(5, book.getJazyk());
            preparedStatement.setString(6, book.getVydavatel());

            return preparedStatement;
        }, keyHolder);

        return new ResponseEntity<>(getBookInfo(),
                HttpStatus.CREATED);
    }


    @DeleteMapping("/book/{id}")
    public ResponseEntity deleteBook(@PathVariable Long id) {
        jdbcTemplate.update("DELETE FROM knihy WHERE id = ?", id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
