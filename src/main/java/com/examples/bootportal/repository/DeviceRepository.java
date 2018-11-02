package com.examples.bootportal.repository;

import com.examples.bootportal.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
    public Device findDeviceByHostname(String hostname);
}
