package com.lecotec.mixi.repository;

import com.lecotec.mixi.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Transactional
    @Modifying
    @Query("update Comment t set t.isShow = :isShow where t.id = :id")
    int changeActiveStatus(@Param("id") long id, @Param("isShow") boolean isShow);
}
