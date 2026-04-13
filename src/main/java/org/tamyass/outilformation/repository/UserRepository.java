package org.tamyass.outilformation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tamyass.outilformation.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
