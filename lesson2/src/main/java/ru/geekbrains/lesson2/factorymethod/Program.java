package ru.geekbrains.lesson2.factorymethod;

import ru.geekbrains.lesson2.templatemethod.LogEntry;
import ru.geekbrains.lesson2.templatemethod.LogReader;

import java.io.FileReader;

public class Program {

    public static String data = """
У лукоморья дуб зелёный;
Златая цепь на дубе том:
И днём и ночью кот учёный
Всё ходит по цепи кругом;
Идёт направо — песнь заводит,
Налево — сказку говорит.""";

    public static void main(String[] args) {

        Sample sample = Sample.create("aaa");

//        LogReader logReader = new ConcreteReaderCreator().createLogReader(LogType.Poem, data);
//        for (LogEntry log: logReader.readLogEntry()) {
//            System.out.println(log.getText());
//        }

//        LogReader events = new ConcreteReaderCreator().createLogReader(LogType.System,data,10);
//
//        for (LogEntry log: events.readLogEntry()) {
//            System.out.println(log.getText());
//        }

        LogReader text = new ConcreteReaderCreator().createLogReader(LogType.Text,".gitignore",20);

        for (LogEntry log: text.readLogEntry()) {
            System.out.println(log.getText());
        }
    }

}
