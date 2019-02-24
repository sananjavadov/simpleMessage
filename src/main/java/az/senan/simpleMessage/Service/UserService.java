package az.senan.simpleMessage.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import az.senan.simpleMessage.Repository.UserRepository;
import az.senan.simpleMessage.entity.User;

@Service
@Transactional
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	public User getById(int id) {
		return userRepository.findById(id);
	}
	
	public User getByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public List<User> getAll(){
		return userRepository.findAll();
	}
	
	
}
