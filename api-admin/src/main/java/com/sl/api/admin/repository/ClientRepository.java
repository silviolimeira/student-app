package com.sl.api.admin.repository;

import com.sl.api.admin.entity.Client;
import com.sl.api.admin.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
