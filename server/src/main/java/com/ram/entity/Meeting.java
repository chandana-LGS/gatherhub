package com.ram.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Meeting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String title;
	
	//@Column(nullable=false)
	private Date time;
	
	private String description;
	
//	@ManyToMany
//	private List<User> attendingUsers;
	
	@OneToMany(mappedBy = "meeting")
    List <UserMeeting> userMeetingStatus;
	
//	private int status;

	public Meeting() {

	}

	public Meeting(Long id, String title, Date time, String description, List<UserMeeting> userMeetingStatus) {
		super();
		this.id = id;
		this.title = title;
		this.time = time;
		this.description = description;
		this.userMeetingStatus = userMeetingStatus;
//		this.attendingUsers = attendingUsers;
//		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<UserMeeting> getUserMeetingStatus() {
		return userMeetingStatus;
	}

	public void setUserMeetingStatus(List<UserMeeting> userMeetingStatus) {
		this.userMeetingStatus = userMeetingStatus;
	}
	
//	public List<User> getAttendingUsers(){
//		return this.attendingUsers;
//	}
//	
//	public void setAttendingUsers( List <User> attendingUsers ) {
//		this.attendingUsers = attendingUsers;
//	}

//	public int getStatus() {
//		return status;
//	}
//
//	public void setStatus(int status) {
//		this.status = status;
//	}
//	
	
	
}
