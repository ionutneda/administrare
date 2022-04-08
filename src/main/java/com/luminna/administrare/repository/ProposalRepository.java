package com.luminna.administrare.repository;

import com.luminna.administrare.entity.ProposalItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProposalRepository extends JpaRepository<ProposalItem, Long> {


}
