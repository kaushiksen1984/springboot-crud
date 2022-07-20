package com.crud.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Employee")
public class Employee implements Serializable {
    @Id
    private int employeeId;
    private String name;
    private String departmentName;
    private long salary;
}
