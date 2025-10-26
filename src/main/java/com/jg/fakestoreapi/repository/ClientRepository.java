
package com.jg.fakestoreapi.repository;

import com.jg.fakestoreapi.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
