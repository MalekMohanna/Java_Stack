package com.malek.project.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.malek.project.models.LoginUser;
import com.malek.project.models.Project;
import com.malek.project.models.User;
import com.malek.project.models.UserProject;
import com.malek.project.repositories.ProjectRepository;
import com.malek.project.repositories.UpRepository;
import com.malek.project.repositories.UserRepository;

@Service
public class AppService {
	
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProjectRepository projectRepo;
    @Autowired
    private UpRepository upRepo;
    
    // shows all
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    // creates one -- register
    public User register(User newU, BindingResult result) {
    	Optional<User> potentialUser = userRepository.findByEmail(newU.getEmail());
    	// check for email in db
    	if (potentialUser.isPresent()) {
    		result.rejectValue("email", "Exists", "This email is taken.");
    	}
    	// check password equals confirm
    	if (!newU.getPassword().equals(newU.getConfirm())) {
    		result.rejectValue("confirm", "Matches", "The Confirm Password must match the Password!");
    	}
    	if (result.hasErrors()) {
    		return null;
    	} else {
    		String hashed = BCrypt.hashpw(newU.getPassword(), BCrypt.gensalt());
    		newU.setPassword(hashed);
    		return userRepository.save(newU);
    	}
    }
    
    // login
    public User login(LoginUser loginUser, BindingResult result) {
    	Optional<User> potentialUser = userRepository.findByEmail(loginUser.getEmail());
    	
    	// check if user exists in db through email
    	if (!potentialUser.isPresent()) {
    		result.rejectValue("email", "Exists", "Please try a different email.");
    	} else {
    		// grab the user with the provided email
    		User userForLoginCheck = potentialUser.get();
    		
    		// check if passwords match
    		if(!BCrypt.checkpw(loginUser.getPassword(), userForLoginCheck.getPassword())) {
    			result.rejectValue("password", "Matches", "Invalid Password!");
    		}
    		
    		if (result.hasErrors()) {
    			return null;
    		} else {
    			return userForLoginCheck;
    		}
    	}
    	return null;
    }

    // retrieves one by id
    public User findUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.isPresent() ? optionalUser.get() : null;
//        if(optionalUser.isPresent()) {
//            return optionalUser.get();
//        } else {
//            return null;
//        }
    }

    // updates one
    public User updateUser(User n) {
       	return userRepository.save(n);
    }
    
    // deletes one
    public void deleteUser(Long id) {
    	userRepository.deleteById(id);
    }
    
    public Project createProject(Project p,User u) {
    	p.setTeamLeader(u);
    	return projectRepo.save(p);
    }
    public void deleteProject(Long id) {
    	projectRepo.deleteById(id);
    }
    public Project findProjectById(Long id) {
    	return this.projectRepo.findById(id).orElse(null);
    }
    public List<Project> allProjects(){
    	return projectRepo.findAll();
    }
    
    public List<Project> availableProjects(User user){
    	return projectRepo.findByUsersNotContains(user);
    }
    public List<Project> userProjects(User user){
    	return projectRepo.findByUsersContains(user);
    }
    public List<Project> leadProjects(User user){
    	return projectRepo.findByTeamLeader(user);
    }
    
    public UserProject joinTeam(Long userId,Long proId) {
    	UserProject x = new UserProject();
    	x.setProject(findProjectById(proId));
    	x.setUser(findUser(userId));
    	return upRepo.save(x);
    }
    public void leaveTeam(Long userId,Long proId) {
    	Project x=findProjectById(proId);
    	User y= findUser(userId);
    	List<User> z=x.getUsers();
    	z.remove(y);
    	x.setUsers(z);
    	projectRepo.save(x);
}
    public void updateProject(Project p,Long proId) {
    	Project old = findProjectById(proId);
    	p.setTeamLeader(old.getTeamLeader());
    	p.setUsers(old.getUsers());
    	projectRepo.save(p);
    }
}