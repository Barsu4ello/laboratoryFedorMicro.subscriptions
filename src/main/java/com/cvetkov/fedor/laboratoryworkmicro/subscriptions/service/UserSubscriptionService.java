package com.cvetkov.fedor.laboratoryworkmicro.subscriptions.service;

import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.request.UserSubscriptionRequest;
import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.response.UserSubscriptionResponse;
import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.update.UserSubscriptionUpdate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserSubscriptionService {
    Page<UserSubscriptionResponse> getAllPage(Pageable pageable);

    List<UserSubscriptionResponse> getAllList();

    UserSubscriptionResponse findById(Long id);

    void save(UserSubscriptionRequest userSubscriptionRequest);

    void update(UserSubscriptionUpdate userSubscriptionUpdate);

    void deleteById(Long id);
}
