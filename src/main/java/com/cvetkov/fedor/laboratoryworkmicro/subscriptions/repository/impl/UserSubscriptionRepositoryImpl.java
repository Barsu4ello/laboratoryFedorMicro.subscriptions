package com.cvetkov.fedor.laboratoryworkmicro.subscriptions.repository.impl;

import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.request.UserSubscriptionRequest;
import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.response.UserSubscriptionResponse;
import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.update.UserSubscriptionUpdate;
import com.cvetkov.fedor.laboratoryworkmicro.entities.model.UserSubscription;
import com.cvetkov.fedor.laboratoryworkmicro.subscriptions.repository.UserSubscriptionRepository;
import com.cvetkov.fedor.laboratoryworkmicro.subscriptions.repository.rowMapper.SubscriptionRowMapper;
import com.cvetkov.fedor.laboratoryworkmicro.subscriptions.repository.rowMapper.UserSubscriptionRowMapper;
import com.cvetkov.fedor.laboratoryworkmicro.utils.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserSubscriptionRepositoryImpl implements UserSubscriptionRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Page<UserSubscriptionResponse> findAll(Pageable pageable) {
        String query = "SELECT * FROM subscriptions.user_subscriptions" +
                " LIMIT " + pageable.getPageSize() +
                " OFFSET " + pageable.getOffset();

        List<UserSubscriptionResponse> subscriptions = jdbcTemplate.query(query, new UserSubscriptionRowMapper());

        return new PageImpl<>(subscriptions);
    }

    @Override
    public List<UserSubscriptionResponse> findAll() {
        String query = "SELECT * FROM subscriptions.user_subscriptions";

        return jdbcTemplate.query(query, new UserSubscriptionRowMapper());
    }

    @Override
    public UserSubscriptionResponse findById(Long id) {
        String query = "SELECT * FROM subscriptions.user_subscriptions" +
                " WHERE id = ?";
        Object[] param = new Object[] {id};

        return jdbcTemplate.query(query, param, new UserSubscriptionRowMapper()).stream()
                .findFirst().orElseThrow(() -> new ObjectNotFoundException("Subscription with id " + id + " not found"));
    }

    @Override
    public void save(UserSubscriptionRequest subscription) {
        String query = "INSERT INTO subscriptions.user_subscriptions(is_valid, host_user_id, subscription_id)" +
                " VALUES (?,?,?)";
        Object[] params = new Object[] {subscription.isValid(),  subscription.getHostUserId(), subscription.getSubscriptionId()};

        jdbcTemplate.update(query, params);
    }

    @Override
    public void update(UserSubscriptionUpdate subscription) {
        String query = "UPDATE subscriptions.user_subscriptions" +
                " SET is_valid = ?, host_user_id = ?, subscription_id = ?" +
                " WHERE id = ?";
        Object[] params = new Object[] {subscription.isValid(),  subscription.getHostUserId(),
                subscription.getSubscriptionId(), subscription.getId()};

        jdbcTemplate.update(query, params);
    }

    @Override
    public void deleteById(Long id) {
        String query = "DELETE FROM subscriptions.user_subscriptions" +
                " WHERE id = ?";
        Object[] param = new Object[] {id};

        jdbcTemplate.update(query, param);
    }
}
