package ru.geekbrains.lesson4.task2;

public interface Factory {


    /**
     * Получить информацию о детали по идентификатору
     * @param id идентификатор детали
     * @return информация о детали
     * @throws RuntimeException Некорректный номер делали/Деталь не найдена/Деталь устарела
     */
    ComponentInfo getComponentInfo(int id);

}
