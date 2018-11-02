package com.examples.bootportal.repository;

import com.examples.bootportal.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Long> {
    public Device findDeviceByHostname(String hostname);
    public List<Device> getAllByAccountId(Long accountId);
}
