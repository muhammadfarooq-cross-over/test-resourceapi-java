package com.sa.test.resourceapi.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    Optional<Project> findBySdlcSystemIdAndId(long sdlcSystemId, long projectId);
}
