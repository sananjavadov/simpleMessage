package az.senan.simpleMessage.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import az.senan.simpleMessage.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findById(int id);
	
	public User findByUsername(String username);
}
