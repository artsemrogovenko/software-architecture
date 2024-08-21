package ru.geekbrains.lesson4.task2;

/**
 * Дилер
 */
public class DealerProvider {

    private Factory factoryProvider;

    public DealerProvider(Factory factoryProvider) {
        this.factoryProvider = factoryProvider;
    }

    public ComponentInfo getComponent(int id) throws Exception {
        /*if (id < 0 || String.valueOf(id).length() < 6)
            throw new RuntimeException("Некорректный номер детали.");*/

        try {
            return factoryProvider.getComponentInfo(id);
        }
        catch (RuntimeException e){
            throw new Exception("Ошибка при попытке получить информацию о детали.", e.fillInStackTrace());
        }

    }

}
