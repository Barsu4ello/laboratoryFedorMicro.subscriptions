package com.cvetkov.fedor.laboratoryworkmicro.subscriptions.controller;

import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.request.SubscriptionRequest;
import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.response.SubscriptionResponse;
import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.update.SubscriptionUpdate;
import com.cvetkov.fedor.laboratoryworkmicro.subscriptions.service.SubscriptionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/subscription")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @GetMapping
    // @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public Page<SubscriptionResponse> getAllSubscriptions(@PageableDefault(size = 5) Pageable pageable) {
        return subscriptionService.getAllPage(pageable);
    }

    @GetMapping("/all-subscription")
    // @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public List<SubscriptionResponse> getAllSubscriptions() {
        return subscriptionService.getAllList();
    }

    @GetMapping("/{id}")
    // @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public SubscriptionResponse getSubscriptionById(@PathVariable Long id) {
        return subscriptionService.findById(id);
    }

    @PostMapping
    // @PreAuthorize("hasAuthority('ADMIN')")
    public void addSubscription(@Valid @RequestBody SubscriptionRequest subscriptionRequest) {
        subscriptionService.save(subscriptionRequest);
    }

    @PutMapping
    // @PreAuthorize("hasAuthority('ADMIN')")
    public void updateSubscription(@Valid @RequestBody SubscriptionUpdate subscriptionUpdate) {
        subscriptionService.update(subscriptionUpdate);
    }

    @DeleteMapping("/{id}")
    // @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteSubscription(@PathVariable Long id) {
        subscriptionService.deleteById(id);
    }
}
