package com.sa.test.resourceapi.services.impl;

import com.sa.test.resourceapi.controllers.ProjectRestController;
import com.sa.test.resourceapi.entities.Project;
import com.sa.test.resourceapi.entities.ProjectRepository;
import com.sa.test.resourceapi.entities.SdlcSystem;
import com.sa.test.resourceapi.entities.SdlcSystemRepository;
import com.sa.test.resourceapi.services.ProjectService;
import org.junit.jupiter.api.Test;
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
        project.setSdlcSystem(new SdlcSystem());
        //SdlcSystem mockSdlcSystem = Mockito.mock(SdlcSystem.class);
        //doReturn(mockSdlcSystem).when(project).getSdlcSystem();
        doReturn(project).when(this.mockProjectRepository).save(Mockito.any());
        doReturn(mockSdlcSystem).when(mockSdlcSystemRepository).getOne(Mockito.anyLong());
        //ProjectRepository projectRepository = Mockito.mock(ProjectRepository.class);

        Project actualResultProject = this.projectService.createProject(project);
        assertNotNull(actualResultProject.getCreatedDate());
        assertNotNull(actualResultProject.getLastModifiedDate());

        SdlcSystem actualResultSdlcSystem = actualResultProject.getSdlcSystem();
        assertNotNull(actualResultSdlcSystem);
        assertNotNull(actualResultSdlcSystem.getLastModifiedDate());
        assertNotNull(actualResultSdlcSystem.getLastModifiedDate());
    }
}
