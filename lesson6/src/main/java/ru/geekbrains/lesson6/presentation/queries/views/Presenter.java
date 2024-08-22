package ru.geekbrains.lesson6.presentation.queries.views;

import ru.geekbrains.lesson6.domain.Note;

import java.util.Collection;

public interface Presenter {
    void printAll(Collection<Note> notes);
}
