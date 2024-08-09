package ru.geekbrains.lesson2.factorymethod;

import ru.geekbrains.lesson2.templatemethod.LogEntry;
import ru.geekbrains.lesson2.templatemethod.LogReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TextFileReader extends LogReader {
    private String file = "";

    @Override
    public Object getDataSource() {
        return file;
    }

    @Override
    public void setDataSource(Object data) {
        this.file = data.toString();
    }

    @Override
    protected Iterable<String> readEntries(int position) {
        List<String> textList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            int count=0;
            while ((line = bufferedReader.readLine()) != null) {
                // обработка строки
                if (position <= count) {
                    textList.add(line);
                }
                count++;
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException fn) {
            fn.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textList;
    }

    @Override
    protected LogEntry parseLogEntry(String stringEntry) {
        return new LogEntry(stringEntry);
    }
}
