package com.sa.test.resourceapi.services.impl;

import com.sa.test.resourceapi.controllers.ProjectRestController;
import com.sa.test.resourceapi.entities.Project;
import com.sa.test.resourceapi.entities.ProjectRepository;
import com.sa.test.resourceapi.entities.SdlcSystem;
import com.sa.test.resourceapi.entities.SdlcSystemRepository;
import com.sa.test.resourceapi.services.ProjectService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


import static javafx.beans.binding.Bindings.when;
@SpringBootTest
public class ProjectServiceImplTest {
    @Autowired
    private ProjectService projectService;


    @MockBean
    private ProjectRepository mockProjectRepository;

    @MockBean
    private SdlcSystemRepository mockSdlcSystemRepository;

    @Test
    public void TestCreateProject() {
        Project project = new Project();
        SdlcSystem sdlcSystem = new SdlcSystem();
        project.setSdlcSystem(sdlcSystem);
        ArgumentCaptor<SdlcSystem> paramCaptorSdlcSystem = ArgumentCaptor.forClass(SdlcSystem.class);
        ArgumentCaptor<Project> paramCaptorProject = ArgumentCaptor.forClass(Project.class);

        this.projectService.createProject(project);

        verify(this.mockProjectRepository).save(paramCaptorProject.capture());
        verify(mockSdlcSystemRepository).save(paramCaptorSdlcSystem.capture());

        Project actualResultProject = paramCaptorProject.getValue();
        assertNotNull(actualResultProject.getCreatedDate());
        assertNotNull(actualResultProject.getLastModifiedDate());

        SdlcSystem actualResultSdlcSystem = paramCaptorSdlcSystem.getValue();
        assertNotNull(actualResultSdlcSystem);
        assertNotNull(actualResultSdlcSystem.getLastModifiedDate());
        assertNotNull(actualResultSdlcSystem.getLastModifiedDate());
    }
}
