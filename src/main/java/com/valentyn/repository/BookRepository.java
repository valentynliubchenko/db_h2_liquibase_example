package com.valentyn.repository;

import com.valentyn.dto.BookDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookDTO, Long> {
}