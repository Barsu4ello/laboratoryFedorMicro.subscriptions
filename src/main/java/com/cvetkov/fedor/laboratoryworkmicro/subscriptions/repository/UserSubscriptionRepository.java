package com.cvetkov.fedor.laboratoryworkmicro.subscriptions.repository;

import com.cvetkov.fedor.laboratoryworkmicro.entities.model.UserSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSubscriptionRepository extends JpaRepository<UserSubscription, Long> {
}
