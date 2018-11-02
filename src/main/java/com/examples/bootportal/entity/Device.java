package com.examples.bootportal.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "device")
@Getter
@Setter
public class Device {
    @Id
    private long id = -1;
    private long accountId = -1;
    private LocalDateTime createDate;
    private String hostname = "";
    private String location = "";
    private String type = "";
    private String device_type = "";
    private String private_ip = "";
    private String public_ip = "";
}
