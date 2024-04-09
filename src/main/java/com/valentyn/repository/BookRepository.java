package com.valentyn.repository;

import com.valentyn.dto.BookDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookDTO, Long> {

    List<BookDTO> findByAuthorName(String authorName);
    BookDTO getByAuthorName(String authorName);

    @Query("SELECT b FROM BookDTO b WHERE b.author.name LIKE CONCAT(:firstLetter, '%') AND b.author.name LIKE CONCAT('%', :lastLetter)")
    List<BookDTO> findBooksByAuthorNameFirstAndLastLetter(@Param("firstLetter") String firstLetter, @Param("lastLetter") String lastLetter);
}