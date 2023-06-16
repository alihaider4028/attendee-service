package com.event.attendeeservice.Repository;

import com.event.attendeeservice.entity.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark,Integer> {
}
