package com.concon.accountservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories
public class CassandraConfiguration  extends AbstractCassandraConfiguration {
    @Value("${spcloud.cassandra.keyspace.name}")
    private String keySpaceName;
    @Value("${spcloud.cassandra.contact.point}")
    private String contactPoint;
    @Value("${spcloud.cassandra.contact.port}")
    private int contactPort;

    @Override
    protected String getKeyspaceName() {
        return keySpaceName;
    }

    @Override
    protected int getPort() {
        return contactPort;
    }

    @Override
    protected String getContactPoints() {
        return contactPoint;
    }
}
