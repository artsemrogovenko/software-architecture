package ru.geekbrains.lesson2.factorymethod;

import ru.geekbrains.lesson2.templatemethod.LogReader;

public abstract class BaseLogReaderCreator {

    public LogReader createLogReader(LogType logType, Object data, int position) {
        LogReader logReader = createLogReaderInstance(logType);
        //TODO: Выполнение подготовительных действий над объектом
        logReader.setDataSource(data);
        logReader.setCurrentPosition((position > 0) ? position : 1);
        return logReader;
    }

    /**
     * Фабричный метод
     *
     * @param logType тип лог-ридера
     * @return конкретный объект лог-ридера
     */
    protected abstract LogReader createLogReaderInstance(LogType logType);

}
