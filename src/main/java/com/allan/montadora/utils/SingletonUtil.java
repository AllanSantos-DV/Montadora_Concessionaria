package com.allan.montadora.utils;

import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.Map;

@Log4j2
public class SingletonUtil {

    private static final Map<Class<?>, Object> instances = new HashMap<>();

    @SuppressWarnings("unchecked")
    public static <T> T getInstance(Class<T> clazz) {
        synchronized (instances) {
            if (!instances.containsKey(clazz)) {
                try {
                    var constructor = clazz.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    instances.put(clazz, constructor.newInstance());
                } catch (Exception e) {
                    log.error("Erro ao criar instância singleton para {}", clazz, e);
                    throw new RuntimeException("Erro ao criar instância singleton para " + clazz, e);
                }
            }
            return (T) instances.get(clazz);
        }
    }
}