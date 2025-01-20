package com.ash.banking.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringFirmbankingRequestRepository extends JpaRepository<FirmbankingRequestJpaEntity, Long> {
}
