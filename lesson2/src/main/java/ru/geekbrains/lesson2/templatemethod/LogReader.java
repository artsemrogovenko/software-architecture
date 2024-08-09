package ru.geekbrains.lesson2.templatemethod;

import java.util.ArrayList;
import java.util.List;

public abstract class LogReader {
    protected int currentPosition = 0;

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Iterable<LogEntry> readLogEntry(){
        List<LogEntry> logList = new ArrayList<>();
        for (String str: readEntries(currentPosition)) {
            logList.add(parseLogEntry(str));
        }
        return logList;
    }


    public abstract Object getDataSource();

    public abstract void setDataSource(Object data);

    protected abstract Iterable<String> readEntries(int position);

    protected abstract LogEntry parseLogEntry(String stringEntry);


}
