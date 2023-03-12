package com.cvetkov.fedor.laboratoryworkmicro.subscriptions.repository;

import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.request.UserSubscriptionRequest;
import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.response.UserSubscriptionResponse;
import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.update.UserSubscriptionUpdate;
import com.cvetkov.fedor.laboratoryworkmicro.entities.model.Subscription;
import com.cvetkov.fedor.laboratoryworkmicro.entities.model.UserSubscription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
//public interface UserSubscriptionRepository extends JpaRepository<UserSubscription, Long> {

public interface UserSubscriptionRepository {
    Page<UserSubscriptionResponse> findAll(Pageable pageable);

    List<UserSubscriptionResponse> findAll();

    UserSubscriptionResponse findById(Long id);

    void save(UserSubscriptionRequest subscription);

    void update(UserSubscriptionUpdate subscription);

    void deleteById(Long id);
}
