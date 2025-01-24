package com.ash.money.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringJpaMemberMoneyRepository extends JpaRepository<MemberMoneyJpaEntity, Long> {
    Optional<MemberMoneyJpaEntity> findByMembershipId(String value);

}
