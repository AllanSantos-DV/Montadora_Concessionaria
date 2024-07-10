package com.allan.montadora.utils;

import javafx.concurrent.Task;
import javafx.scene.control.ProgressIndicator;

import java.util.function.Consumer;
import java.util.stream.IntStream;

import static java.lang.Thread.sleep;

public class TimeProgressUtil {

    private static Task<Void> taskProgress(ProgressIndicator progress) {
        return new Task<>() {
            @Override
            protected Void call() {
                IntStream.range(0, 100).forEach(i -> {
                    int random = (int) (Math.random() * 100);
                    try {
                        sleep(random);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    progress.setProgress((i + 2) / 100.0);
                });
                return null;
            }
        };
    }

    public static void configPagamento(ProgressIndicator progress, Consumer<Void> chamarTelaCallback) {
        Task<Void> task = taskProgress(progress);
        new Thread(task).start();
        task.setOnSucceeded(e -> {
            try {
                progress.setProgress(1);
                sleep(2000);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            chamarTelaCallback.accept(null);
        });
    }
}
