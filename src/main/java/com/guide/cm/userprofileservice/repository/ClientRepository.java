package com.guide.cm.userprofileservice.repository;

import com.guide.cm.userprofileservice.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

    Client findByGstNo(String gstNo);
}
