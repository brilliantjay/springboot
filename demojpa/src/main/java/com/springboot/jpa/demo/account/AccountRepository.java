package com.springboot.jpa.demo.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {
    //@Query(nativeQuery=true, value="select * from acount where username='{0}'")
    Optional<Account> findByUsername(String username);
    //Account findByUsername(String username);
}
