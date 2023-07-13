package com.aem.cts.core.models;

import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, adapters = ProjectTeam.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ProjectTeamImpl implements ProjectTeam {

    @Inject
    String groupname;
    @Inject
    String name;

    @ValueMapValue
    String projectname;

    @ValueMapValue
    String projectsite;

    @ChildResource
    private List<ProjectTeamImpl> teamname;

    public List<ProjectTeamImpl> getTeamName() {
        return teamname;

    }

    @ChildResource
    private List<ProjectTeamImpl> teammembers;

    public List<ProjectTeamImpl> getTeamMembersName() {
        return teammembers;

    }

    @Override
    public String getProjectName() {
        return projectname;
    }

    @Override
    public String getProjectPath() {
        return projectsite;
    }

    @Override
    public String getGroupName() {
        return groupname;
    }

    @Override
    public String getEmployeeName() {
        return name;
    }

}
