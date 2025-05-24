package com.bookStore.bookStore.Repository;

import com.bookStore.bookStore.Entity.MyBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBooksRepository extends JpaRepository<MyBooks, Integer> {
    // Custom query methods can be defined here if needed
}
