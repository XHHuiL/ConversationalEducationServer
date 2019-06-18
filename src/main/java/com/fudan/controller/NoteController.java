package com.fudan.controller;

import com.fudan.entity.Note;
import com.fudan.response.NoteResponse;
import com.fudan.service.NoteService;
import com.fudan.util.MapFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }


    @GetMapping(value = "/notes/{studentId}")
    public List<NoteResponse> allNotes(@PathVariable String studentId) {
        return noteService.getNotesByStudentId(studentId);
    }

    @PostMapping(value = "/note")
    public Map addNote(@RequestBody Note note) {
        if (note.getStudentId() == null || note.getContentId() == null) {
            return MapFactory.nullFieldMap();
        }
        noteService.create(note);
        return MapFactory.successMap(MapFactory.CREATE);
    }

    @PutMapping(value = "/note/{id}")
    public Map updateNote(@PathVariable int id, @RequestBody Note note) {
        if (id != note.getId()) {
            return MapFactory.idMismatchMap();
        }
        if (noteService.getNoteById(id) == null) {
            return MapFactory.idNotExitMap();
        }
        noteService.update(note);
        return MapFactory.successMap(MapFactory.UPDATE);
    }

    @DeleteMapping(value = "/note/{id}")
    public Map deleteNote(@PathVariable int id) {
        if (noteService.getNoteById(id) == null) {
            return MapFactory.idNotExitMap();
        }
        noteService.delete(id);
        return MapFactory.successMap(MapFactory.DELETE);
    }

}