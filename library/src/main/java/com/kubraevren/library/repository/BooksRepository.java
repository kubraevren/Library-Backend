package com.kubraevren.library.repository;

import com.kubraevren.library.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<BookEntity,Long> {


}
