package com.example.demo.repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class TestRepository {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getList(String description) {
        String sql = "select * from demo \r\n";
        sql += "where description like concat('%', :description, '%') ";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("description", description);
        return jdbcTemplate.queryForList(sql, parameterSource);
    }

    public Integer insert(String description) {
        String sql = "insert into demo (description, entrydate) \r\n";
        sql += "values (:description, :entrydate) ";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("description", description);
        parameterSource.addValue("entrydate", new Date());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int count = jdbcTemplate.update(sql, parameterSource, keyHolder); // row 개수
        int insertedId = keyHolder.getKey().intValue();
        return insertedId;
    }
}
