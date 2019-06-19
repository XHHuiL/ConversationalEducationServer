package com.fudan.service;

import com.fudan.dao.ContentDao;
import com.fudan.dao.NoteDao;
import com.fudan.entity.Note;
import com.fudan.response.NoteResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class NoteService {

    private final NoteDao noteDao;
    private final ContentDao contentDao;


    public NoteService(NoteDao noteDao, ContentDao contentDao) {
        this.noteDao = noteDao;
        this.contentDao = contentDao;
    }

    public List<NoteResponse> getNotesByStudentId(String id) {
        List<Note> notes = noteDao.selectByStudentId(id);
        List<NoteResponse> responses = new ArrayList<>();
        for (Note note : notes
                ) {
            String contentText = contentDao.selectByPrimaryKey(note.getContentId()).getText();
            responses.add(
                    new NoteResponse(note.getId(), note.getStudentId(), note.getContentId(), note.getText(), contentText));
        }
        return responses;
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void create(Note note) {
        noteDao.insert(note);
    }

    public Note getNoteById(Integer id) {
        return noteDao.selectByPrimaryKey(id);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void update(Note note) {
        noteDao.updateByPrimaryKeySelective(note);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void delete(int id) {
        noteDao.deleteByPrimaryKey(id);
    }
}