package com.validation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.validation.Model.BookClass;

public interface BookRepository extends JpaRepository<BookClass, Integer> {

}
