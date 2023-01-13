package com.cvetkov.fedor.laboratoryworkmicro.subscriptions.repository;

import com.cvetkov.fedor.laboratoryworkmicro.entities.model.Subscription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

//@Repository
//public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
//}

//@Repository
public interface SubscriptionRepository{

    Page<Subscription> findAll(Pageable pageable);
    List<Subscription> findAll();
    Optional<Subscription> findById(Long id);
    void save(Subscription subscription);
    void deleteById(Long id);

}
