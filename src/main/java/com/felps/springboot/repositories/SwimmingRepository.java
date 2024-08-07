package com.felps.springboot.repositories;

import com.felps.springboot.models.SwimmingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SwimmingRepository extends JpaRepository<SwimmingModel, UUID> {
}
