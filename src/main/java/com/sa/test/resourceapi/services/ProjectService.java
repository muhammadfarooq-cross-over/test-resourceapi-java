package com.sa.test.resourceapi.services;

import com.sa.test.resourceapi.entities.Project;
import com.sa.test.resourceapi.exceptions.NotFoundException;

public interface ProjectService {

    Project getProject(long id) throws NotFoundException;
    Project createProject(Project project);
}
