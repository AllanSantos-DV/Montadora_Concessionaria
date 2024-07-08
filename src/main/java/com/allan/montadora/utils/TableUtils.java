package com.allan.montadora.utils;

import com.allan.montadora.models.Carro;
import javafx.beans.binding.Bindings;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;

import java.util.function.Function;

public class TableUtils {

    public static <S, T> void configurarColuna(TableColumn<S, T> coluna, Function<S, T> valor) {
        coluna.setCellValueFactory(new PropertyValueFactory<>(coluna.getText()));
        coluna.setCellValueFactory(cellData -> {
            S rowData = cellData.getValue();
            T cellValue = valor.apply(rowData);
            return Bindings.createObjectBinding(() -> cellValue);
        });
    }

    public static void setCorTableColumn(TableColumn<Carro, Color> corCarro) {
        corCarro.setCellFactory(column -> new TableCell<>() {
            @Override
            protected void updateItem(Color item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(item.toString());
                    setStyle("-fx-background-color: " + item.toString().replace("0x", "#") + ";");
                }
            }
        });
    }
}
