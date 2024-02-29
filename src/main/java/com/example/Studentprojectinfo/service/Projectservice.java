package com.example.Studentprojectinfo.service;
import com.example.Studentprojectinfo.dto.Projectrequest;
import com.example.Studentprojectinfo.model.Project;
import com.example.Studentprojectinfo.repository.projectrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class Projectservice
{
    @Autowired
    public projectrepo repo;
    public Project saveproject(Projectrequest projectrequest) {
        Project project = new Project();
        project.setRollno(projectrequest.getRollno());
        project.setName(projectrequest.getName());
        project.setBatch(projectrequest.getBatch());
        project.setEmail(projectrequest.getEmail());
        project.setPhone(projectrequest.getPhone());
        project.setDepartment(projectrequest.getDepartment());
        project.setSemester(projectrequest.getSemester());
        project.setProjectname(projectrequest.getProjectname());
        project.setDescription(projectrequest.getDescription());
        project.setStatus(projectrequest.getStatus());
        project.setSupervisor(projectrequest.getSupervisor());
        project.setHodname(projectrequest.getHodname());
        project.setDate(projectrequest.getDate());
        project.setTopic(projectrequest.getTopic());
        project.setGithublink(projectrequest.getGithublink());
        project.setProjectlink(projectrequest.getProjectlink());
        return repo.save(project);
    }
    public List<Project> getproject()
    {
        return repo.findAll();
    }

    public Project getprojectById(int id)
    {
        return repo.findById(id).orElse(null);
    }

    public void deleteprojectById(int id)
    {
        repo.deleteById(id);
    }

    public List<Project> saveprojects(List<Project> projects)
    {
        return repo.saveAll(projects);
    }

}
