package com.sa.test.resourceapi.controllers;

import com.sa.test.resourceapi.entities.Project;
import com.sa.test.resourceapi.exceptions.NotFoundException;
import com.sa.test.resourceapi.services.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(com.sa.test.resourceapi.controllers.ProjectRestController.ENDPOINT)
@Api(produces = MediaType.APPLICATION_JSON_VALUE, tags = "Project")
public class ProjectRestController {

	public static final String ENDPOINT = "/api/v2/projects";
	public static final String ENDPOINT_ID = "/{id}";
	public static final String PATH_VARIABLE_ID = "id";

	private static final String API_PARAM_ID = "ID";

	@Autowired
	private ProjectService projectService;

	@ApiOperation("Get a Project")
	@GetMapping(ENDPOINT_ID)
	public Project getProject(
			@ApiParam(name = API_PARAM_ID, required = true)
			@PathVariable(PATH_VARIABLE_ID)
			final long projectId
	) throws NotFoundException {
		return projectService.getProject(projectId);
	}

	@ApiOperation("Create a Project")
	@PostMapping()
	public Project createProject(
			@RequestBody Project project
	) {
		return projectService.createProject(project);
	}

	@ApiOperation("Update a Project")
	@PatchMapping(ENDPOINT_ID)
	public Project updateProject(@ApiParam(name = API_PARAM_ID, required = true)
									 @PathVariable(PATH_VARIABLE_ID)
									 final long projectId,
			@RequestBody Project project
	) throws NotFoundException {
		return projectService.updateProject(projectId, project);
	}
}
