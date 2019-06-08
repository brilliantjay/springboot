package com.springboot.jpa.demo;

import com.springboot.jpa.demo.account.Account;
import com.springboot.jpa.demo.account.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
//@SpringBootTest
public class AccountRepositoryTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void di() throws SQLException {
       /* try(Connection connection = dataSource.getConnection()){
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getURL());
            System.out.println(metaData.getDriverName());
            System.out.println(metaData.getUserName());
        }*/

       Account account = new Account();
       account.setUsername("nayun");
       account.setPassword("1234");

       Account newAccount = accountRepository.save(account);

       assertThat(newAccount).isNotNull();
      // Account existingAccount = accountRepository.findByUsername(newAccount.getUsername());
        Optional<Account> existingAccount = accountRepository.findByUsername(newAccount.getUsername());
       assertThat(existingAccount).isNotEmpty();

        Optional<Account> nonExistingAccount = accountRepository.findByUsername(newAccount.getUsername());
        assertThat(nonExistingAccount).isNotEmpty();
    }
}