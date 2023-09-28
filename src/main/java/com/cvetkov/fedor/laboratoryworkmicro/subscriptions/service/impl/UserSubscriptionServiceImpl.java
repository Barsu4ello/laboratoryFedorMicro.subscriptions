package com.cvetkov.fedor.laboratoryworkmicro.subscriptions.service.impl;

import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.request.UserSubscriptionRequest;
import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.response.UserSubscriptionResponse;
import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.update.UserSubscriptionUpdate;
import com.cvetkov.fedor.laboratoryworkmicro.entities.mapper.UserSubscriptionMapper;
import com.cvetkov.fedor.laboratoryworkmicro.subscriptions.feign.UserFeignClient;
import com.cvetkov.fedor.laboratoryworkmicro.subscriptions.repository.UserSubscriptionRepository;
import com.cvetkov.fedor.laboratoryworkmicro.subscriptions.service.UserSubscriptionService;
import com.cvetkov.fedor.laboratoryworkmicro.utils.exception.ExceptionResponseStatusChecker;
import com.cvetkov.fedor.laboratoryworkmicro.utils.exception.ObjectNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserSubscriptionServiceImpl implements UserSubscriptionService {
    private final UserSubscriptionRepository userSubscriptionRepository;
    private final UserSubscriptionMapper userSubscriptionMapper;
//    private final UserFeignClient userFeignClient;

    @Override
    public Page<UserSubscriptionResponse> getAllPage(Pageable pageable) {
        return userSubscriptionRepository.findAll(pageable);
    }

    @Override
    public List<UserSubscriptionResponse> getAllList() {
        return userSubscriptionRepository.findAll();
    }

    @Override
    public UserSubscriptionResponse findById(Long id) {
        return userSubscriptionRepository.findById(id);
    }

    @Override
    public void save(UserSubscriptionRequest userSubscriptionRequest) {
        // Проверим есть такой пользователь в микросервисе users, иначе будет FeignException  //(c KeyCloak это не надо)
//        Long userId = userSubscriptionRequest.getHostUserId();
//        userFeignClient.getUserById(userId);

        userSubscriptionRepository.save(userSubscriptionRequest);
    }

    @Override
    public void update(UserSubscriptionUpdate userSubscriptionUpdate) {
        // Проверим есть такой пользователь в микросервисе users, иначе будет FeignException  //(c KeyCloak это не надо)
//        Long userId = userSubscriptionUpdate.getHostUserId();
//        userFeignClient.getUserById(userId);

        userSubscriptionRepository.update(userSubscriptionUpdate);
    }

    @Override
    public void deleteById(Long id) {
        userSubscriptionRepository.deleteById(id);
    }
}
