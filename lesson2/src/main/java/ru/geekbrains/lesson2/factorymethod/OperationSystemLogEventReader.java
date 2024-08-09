package ru.geekbrains.lesson2.factorymethod;

import ru.geekbrains.lesson2.templatemethod.LogEntry;
import ru.geekbrains.lesson2.templatemethod.LogReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OperationSystemLogEventReader extends LogReader {

    private String events;

    @Override
    public Object getDataSource() {
        return events;
    }

    @Override
    public void setDataSource(Object data) {
            // Формируем команду как массив строк
            String[] command = new String[] {
                    "wevtutil",
                    "qe",
                    "System",
                    "/f:text",
                    "/c:10" // последние 10 событий
            };
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.redirectErrorStream(true); // Объединяем стандартный вывод и поток ошибок

            Process process = processBuilder.start(); // Запускаем процесс

            // Читаем вывод команды
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(),"windows-1251"));
            StringBuilder output = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n"); // добавляем строку к выходу
            }
            events = output.toString();

            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Содержимое системного журнала событий:\n" + output.toString());
            } else {
                System.out.println("Ошибка при выполнении команды. Код ошибки: " + exitCode);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Iterable<String> readEntries(int position) {
        Scanner scanner = new Scanner(events);
        List<String> eventList = new ArrayList<>();
        while (scanner.hasNextLine()) {
//            for (int count = 0; count < position; count++) {
//                currentPosition = count;
                String line = scanner.nextLine();
                eventList.add(line);
//            }
//            else {
//                scanner.nextLine();
//            }
        }
        return eventList;
    }

    @Override
    protected LogEntry parseLogEntry(String stringEntry) {
        return new LogEntry(stringEntry);
    }
}
