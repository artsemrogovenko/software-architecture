package ru.geekbrains.lesson2.templatemethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PoemReader extends LogReader{

    private String data;

    @Override
    public Object getDataSource() {
        return data;
    }

    @Override
    public void setDataSource(Object data) {
        this.data = data.toString();
    }

    public PoemReader(){

    }

    public PoemReader(String data) {
        this.data = data;
    }

    @Override
    protected Iterable<String> readEntries(int position) {
        Scanner scanner = new Scanner(data);
        List<String> logList = new ArrayList<>();
        int count = 0;
        while (scanner.hasNextLine()){
            count++;
            if (count >= position){
                currentPosition = count;
                String line = scanner.nextLine();
                logList.add(line);
            }
            else {
                scanner.nextLine();
            }
        }
        return logList;
    }

    @Override
    protected LogEntry parseLogEntry(String stringEntry) {
        return new LogEntry(stringEntry);
    }
}
