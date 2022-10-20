package com.indocyber.penjualan.repository;

import com.indocyber.penjualan.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersRepository extends JpaRepository<Users,String> {

    @Query("""
            SELECT COUNT(*)
            FROM Users us
            WHERE us.username = :user
            """)
    public Long count (@Param("user") String username);
}
