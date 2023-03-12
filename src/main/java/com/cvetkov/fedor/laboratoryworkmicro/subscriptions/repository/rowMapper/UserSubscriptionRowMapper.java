package com.cvetkov.fedor.laboratoryworkmicro.subscriptions.repository.rowMapper;

import com.cvetkov.fedor.laboratoryworkmicro.entities.dto.response.UserSubscriptionResponse;
import com.cvetkov.fedor.laboratoryworkmicro.entities.model.UserSubscription;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSubscriptionRowMapper  implements RowMapper<UserSubscriptionResponse> {
    @Override
    public UserSubscriptionResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserSubscriptionResponse userSubscription = new UserSubscriptionResponse();

        userSubscription.setId(rs.getLong("id"));
        userSubscription.setValid(rs.getBoolean("is_valid"));
        userSubscription.setSubscription(rs.getLong("subscription_id"));
        userSubscription.setUser(rs.getLong("host_user_id"));

        return userSubscription;
    }
}
