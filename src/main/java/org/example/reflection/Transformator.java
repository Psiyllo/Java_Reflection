package org.example.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Transformator {

    //Por exemplo, você pode ter um objeto e querer chamar um método dele,
    // mas você só sabe o nome do método em forma de texto (uma String).
    // Suponha que temos um objeto obj e o nome do método que queremos chamar é meuMetodo.
    // Com reflection, você pode fazer o seguinte:

    //Method metodo = obj.getClass().getMethod("meuMetodo");
    //metodo.invoke(obj);

    //Use reflexão apenas quando necessário:
    // se for possível, prefira realizar a tarefa sem reflection,
    // pois o acesso direto é sempre mais rápido.

    //Cache de métodos e campos:
    // se for necessário usar reflexão várias vezes,
    // faça a busca uma vez e guarde (cache)
    // o método ou campo para usar depois e não ser preciso buscar as informações todas as vezes.

    public <I, O> O transform(I input) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class <?> source = input.getClass();
        Class <?> target = Class.forName(source + "DTO");

        O targetClass = (O) target.getDeclaredConstructor().newInstance();

        Field[] sourceFields = source.getDeclaredFields();
        Field[] targetFields = target.getDeclaredFields();

        return targetClass;
    }
}
