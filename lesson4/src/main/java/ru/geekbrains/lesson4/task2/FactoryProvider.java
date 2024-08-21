package ru.geekbrains.lesson4.task2;

import java.util.ArrayList;

/**
 * Завод по производству деталей
 */
public class FactoryProvider implements Factory {

    private ArrayList<ComponentInfo> components = new ArrayList<>();

    {
        for (int i = 0; i < 10; i++){
            components.add(new ComponentInfo(900000 + i, String.format("component description %d", 900000 + i)));
        }
        for (int i = 0; i < 5; i++){
            components.add(new ComponentInfo(1000 + i, String.format("component description %d", 1000 + i)));
        }
    }



    /**
     * Получить информацию о детали по идентификатору
     * @param id идентификатор детали
     * @return информация о детали
     * @throws RuntimeException Некорректный номер делали/Деталь не найдена/Деталь устарела
     */
    public ComponentInfo getComponentInfo(int id) throws RuntimeException{

        // Предусловие
        if (id < 0)
        {
            throw new RuntimeException("Некорректный номер детали.");
        }

        if (String.valueOf(id).length() < 6){
            throw new RuntimeException("Некорректный номер детали. Деталь существует, но устарела и более не выпускается.");
        }

        // Выполнение подпрограммы
        ComponentInfo componentInfo = null;
        for (ComponentInfo component : components) {
            if (component.getId() == id){
                componentInfo = component;
            }
        }

        // Инвариант #1 ..
        validateComponent(componentInfo);

        // Выполнение подпрограммы
        double price = PriceProvider.getPrice(componentInfo.getId());
        componentInfo.setPrice(price);

        // Инвариант #2 ..
        validateComponentPrice(componentInfo);


        // Постусловие
        if (componentInfo == null){
            throw new RuntimeException("Деталь не найдена.");
        }

        return componentInfo;
    }

    private void validateComponent(ComponentInfo componentInfo){
        if (componentInfo == null){
            throw new RuntimeException("Деталь не найдена.");
        }
    }

    private void validateComponentPrice(ComponentInfo componentInfo){
        if (componentInfo.getPrice() <= 0){
            throw new RuntimeException("Стоимость детали указана некорректно.");
        }
    }

}
