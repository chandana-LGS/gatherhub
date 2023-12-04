package com.ram.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ram.entity.Meeting;

public interface MeetingRepository extends JpaRepository<Meeting, Long>{

}
