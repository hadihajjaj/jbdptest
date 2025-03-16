package com.objectia.JBD_HandsOnLearning.togglz;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.togglz.core.Feature;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.manager.FeatureManagerBuilder;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.repository.jdbc.JDBCStateRepository;
import org.togglz.core.user.FeatureUser;
import org.togglz.core.user.SimpleFeatureUser;
import org.togglz.core.user.UserProvider;

import javax.sql.DataSource;

@Component
public class TogglzConfig implements org.togglz.core.manager.TogglzConfig {
    private final DataSource dataSource;

    public TogglzConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public Class<? extends Feature> getFeatureClass() {
        return Features.class;
    }

    @Override
    public StateRepository getStateRepository() {
        return new JDBCStateRepository.Builder(dataSource).tableName("feature_status").build();
    }

    @Override
    public UserProvider getUserProvider() {
        return new UserProvider() {
            @Override
            public FeatureUser getCurrentUser() {
                return new SimpleFeatureUser("admin",true);
            }
        };
    }

    @Bean
    public FeatureManager featureManager(){
        return new FeatureManagerBuilder().featureEnum(Features.class)
                .stateRepository(getStateRepository())
                .userProvider(getUserProvider())
                .build();
    }
}
