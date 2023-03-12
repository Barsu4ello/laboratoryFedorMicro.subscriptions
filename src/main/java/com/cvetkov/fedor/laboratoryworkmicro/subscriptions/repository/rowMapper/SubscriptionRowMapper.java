package com.cvetkov.fedor.laboratoryworkmicro.subscriptions.repository.rowMapper;

import com.cvetkov.fedor.laboratoryworkmicro.entities.model.Subscription;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class SubscriptionRowMapper implements RowMapper<Subscription> {

    @Override
    public Subscription mapRow(ResultSet rs, int rowNum) throws SQLException {
        Subscription subscription = new Subscription();

        subscription.setId(rs.getLong("id"));
        subscription.setName(rs.getString("name"));
        subscription.setPrice(rs.getInt("price"));
        subscription.setDescription(rs.getString("description"));

        return subscription;
    }
}
