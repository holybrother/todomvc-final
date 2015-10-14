package model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface NoteRepository extends JpaRepository<Note, Long> {
    Collection<Note> findById(Long id);


}
