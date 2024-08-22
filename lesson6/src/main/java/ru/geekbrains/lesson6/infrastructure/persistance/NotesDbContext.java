package ru.geekbrains.lesson6.infrastructure.persistance;

import ru.geekbrains.lesson6.application.interfaces.NotesDatabaseContext;
import ru.geekbrains.lesson6.database.NotesDatabase;
import ru.geekbrains.lesson6.database.NotesRecord;
import ru.geekbrains.lesson6.domain.Note;
import ru.geekbrains.lesson6.infrastructure.persistance.entityconfiguration.NoteConfiguration;

import java.util.ArrayList;
import java.util.Collection;

public class NotesDbContext extends DbContext implements NotesDatabaseContext {

    @Override
    public Collection<Note> getAll() {
        Collection<Note> noteslist=new ArrayList<>();
        //TODO: Этого кастинга быть не должно, тут должен работать внутренний механизм фреймворка
        for (NotesRecord record: ((NotesDatabase)database).getNotesTable().getRecords()) {
            noteslist.add(new Note(
                    record.getId(),
                    record.getUserId(),
                    record.getTitle(),
                    record.getDetails(),
                    record.getCreationDate()
                    ));
        }
        return noteslist;
    }

    public NotesDbContext(Database database) {
        super(database);
    }

    @Override
    protected void onModelCreating(ModelBuilder builder) {
        builder.applyConfiguration(new NoteConfiguration());
    }


}
