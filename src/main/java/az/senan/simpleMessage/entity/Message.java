package az.senan.simpleMessage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity(name="message")
@Table(name="message_details")
public class Message {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="message_id")
	private int id;
	
	@Column(name="message_content",length=300, nullable=false)
	@NotEmpty
	private String content;
	
	@Column(name="receiver_id", nullable=false)
	private int receiver;
	
	@OneToOne
	@JoinColumn(name="sender_id", nullable=false)
	private User sender;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReceiver() {
		return receiver;
	}

	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public Message(@NotEmpty String content, int receiver, User sender) {
		this.content = content;
		this.receiver = receiver;
		this.sender = sender;
	}
	
	public Message() {
		
	}
	
	
	
	
	
	
	
}
