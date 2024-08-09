package ru.geekbrains.lesson2.factorymethod;

import ru.geekbrains.lesson2.templatemethod.LogEntry;
import ru.geekbrains.lesson2.templatemethod.LogReader;

public class DatabaseReader extends LogReader {
    @Override
    public Object getDataSource() {
        return null;
    }

    @Override
    public void setDataSource(Object data) {

    }

    @Override
    protected Iterable<String> readEntries(int position) {
        return null;
    }

    @Override
    protected LogEntry parseLogEntry(String stringEntry) {
        return null;
    }
}
