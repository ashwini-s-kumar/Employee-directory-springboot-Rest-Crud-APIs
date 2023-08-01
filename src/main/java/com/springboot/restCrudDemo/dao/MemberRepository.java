package com.springboot.restCrudDemo.dao;

import com.springboot.restCrudDemo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUserName(String username);
}