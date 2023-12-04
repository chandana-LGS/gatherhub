package com.ram.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ram.entity.Meeting;
import com.ram.entity.UserMeeting;
import com.ram.entity.UserMeetingKey;

@Repository
public interface UserMeetingRepository extends JpaRepository<UserMeeting, UserMeetingKey> {
	List<UserMeeting> findByMeetingStatus( int meetingStatus );
	List<UserMeeting> findByMeeting(Meeting meeting );
}
