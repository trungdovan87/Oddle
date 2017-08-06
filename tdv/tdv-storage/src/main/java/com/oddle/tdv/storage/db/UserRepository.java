package com.oddle.tdv.storage.db;

import com.oddle.tdv.sql.model.OddUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<OddUser, Long> {
}
