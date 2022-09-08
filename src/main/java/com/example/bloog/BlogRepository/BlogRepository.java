package com.example.bloog.BlogRepository;

import com.example.bloog.Model.Blogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blogs,Integer> {

}
