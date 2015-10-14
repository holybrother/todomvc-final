package main;

import model.Note;
import model.NoteRepository;
import model.NoteS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/")
public class NotesController {
    @Autowired
    NoteRepository noteRepository;

    @RequestMapping
    Collection<Note> readNotes(@PathVariable Long id) {
        return noteRepository.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addNote(@PathVariable Long id, @Valid @RequestBody Note note) {
        NoteS notes = (NoteS) noteRepository.findById(id);
        note.setId(id);
        noteRepository.save((Iterable<Note>) note);


    }
}



