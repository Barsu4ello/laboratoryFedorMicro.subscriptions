package com.cvetkov.fedor.laboratoryworkmicro.subscriptions.repository.impl;

import com.cvetkov.fedor.laboratoryworkmicro.entities.model.Subscription;
import com.cvetkov.fedor.laboratoryworkmicro.subscriptions.repository.SubscriptionRepository;
import com.cvetkov.fedor.laboratoryworkmicro.subscriptions.repository.rowMapper.SubscriptionRowMapper;
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
public class SubscriptionRepositoryImpl implements SubscriptionRepository {

    private final JdbcTemplate jdbcTemplate;
    @Override
    public Page<Subscription> findAll(Pageable pageable) {
        String query = "SELECT * FROM subscriptions.subscriptions" +
                " LIMIT " + pageable.getPageSize() +
                " OFFSET " + pageable.getOffset();

        List<Subscription> subscriptions = jdbcTemplate.query(query, new SubscriptionRowMapper());

        return new PageImpl<>(subscriptions);
    }

    @Override
    public List<Subscription> findAll() {
        String query = "SELECT * FROM subscriptions.subscriptions";

        return jdbcTemplate.query(query, new SubscriptionRowMapper());
    }

    @Override
    public Subscription findById(Long id) {
        String query = "SELECT * FROM subscriptions.subscriptions" +
                " WHERE id = ?";
        Object[] param = new Object[] {id};

        return jdbcTemplate.query(query, param, new SubscriptionRowMapper()).stream()
                .findFirst().orElseThrow(() -> new ObjectNotFoundException("Subscription with id " + id + " not found"));
    }

    @Override
    public void save(Subscription subscription) {
        String query = "INSERT INTO subscriptions.subscriptions(name, price, description)" +
                " VALUES (?,?,?)";
        Object[] params = new Object[] {subscription.getName(),  subscription.getPrice(), subscription.getDescription()};

        jdbcTemplate.update(query, params);
    }

    @Override
    public void update(Subscription subscription) {
        String query = "UPDATE subscriptions.subscriptions" +
                " SET name = ?, price = ?, description = ?" +
                " WHERE id = ?";
        Object[] params = new Object[] {subscription.getName(),  subscription.getPrice(),
                subscription.getDescription(), subscription.getId()};

        jdbcTemplate.update(query, params);
    }

    @Override
    public void deleteById(Long id) {
        String query = "DELETE FROM subscriptions.subscriptions" +
                " WHERE id = ?";
        Object[] param = new Object[] {id};

        jdbcTemplate.update(query, param);
    }
}
