package az.senan.simpleMessage.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import az.senan.simpleMessage.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

	@Query("from message where sender_id=:sender_id and receiver_id=:receiver_id or sender_id=:receiver_id and receiver_id=:sender_id order by id ASC")
	public List<Message>  getMessages(@Param("sender_id") int sender, @Param("receiver_id") int receiver );	
}
