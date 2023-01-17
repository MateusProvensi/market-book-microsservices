package com.provensi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.provensi.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
	
	@Query("SELECT b FROM Book b WHERE b.id = :id")
	Book getByIdBook(@Param("id") Long id);
}
