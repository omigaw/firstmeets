package com.firstmeetschool.school.repository;

import com.firstmeetschool.school.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
}
