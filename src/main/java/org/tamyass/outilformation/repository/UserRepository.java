package org.tamyass.outilformation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tamyass.outilformation.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
