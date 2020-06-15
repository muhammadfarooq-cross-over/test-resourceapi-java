package com.sa.test.resourceapi.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SdlcSystemRepository extends JpaRepository<SdlcSystem, Long>{

}
