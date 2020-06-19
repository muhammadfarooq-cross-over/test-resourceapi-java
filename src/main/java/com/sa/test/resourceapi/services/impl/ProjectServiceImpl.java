package com.sa.test.resourceapi.services.impl;

import com.sa.test.resourceapi.entities.Project;
import com.sa.test.resourceapi.entities.SdlcSystem;
import com.sa.test.resourceapi.entities.SdlcSystemRepository;
import com.sa.test.resourceapi.exceptions.NotFoundException;
import com.sa.test.resourceapi.entities.ProjectRepository;
import com.sa.test.resourceapi.services.ProjectService;
import com.sa.test.resourceapi.services.SdlcSystemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

	private final ProjectRepository projectRepository;
	private final SdlcSystemService sdlcSystemService;

	public Project getProject(long id) throws NotFoundException {
		return projectRepository.findById(id).orElseThrow(() -> new NotFoundException(Project.class, id));
	}

	public Project createProject(Project project) {
		project.setCreatedDate(Instant.now());
		project.setLastModifiedDate(Instant.now());
		SdlcSystem sdlcSystem = sdlcSystemService.getOrCreateSdlcSystem(project.getSdlcSystem());
		project.setSdlcSystem(sdlcSystem);
		return projectRepository.save(project);
	}

	public Project updateProject(long projectId, Project project) throws NotFoundException {
		Project projectFromDB = this.getProject(projectId);
		if (project.getSdlcSystem() != null) {
			projectFromDB.setSdlcSystem(sdlcSystemService.getOrCreateSdlcSystem(project.getSdlcSystem()));
		}
		if (project.getExternalId() != null) {
			projectFromDB.setExternalId(project.getExternalId());
		}
		if (project.getName() != null) {
			projectFromDB.setName(project.getName());
		}
		projectFromDB.setLastModifiedDate(Instant.now());
		projectRepository.save(projectFromDB);
		return projectFromDB;
	}
}
