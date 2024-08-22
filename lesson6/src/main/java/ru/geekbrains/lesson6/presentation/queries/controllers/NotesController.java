package ru.geekbrains.lesson6.presentation.queries.controllers;


import ru.geekbrains.lesson6.application.interfaces.NoteEditor;
import ru.geekbrains.lesson6.domain.Note;

public class NotesController extends Controller {

    private final NoteEditor noteEditor;

    public NotesController(NoteEditor noteEditor) {
        this.noteEditor = noteEditor;
    }

    public void routeAddNote(Note note){
        this.noteEditor.add(note);
    }
    public void routeRemoveNote(Note note){
        this.noteEditor.remove(note);
    }
    //TODO: \notes\all
    public void routeGetAll(){
        noteEditor.printAll();
    }

}
