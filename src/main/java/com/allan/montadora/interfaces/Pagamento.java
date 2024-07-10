package com.allan.montadora.interfaces;

import com.allan.montadora.models.Carro;
import javafx.scene.control.ProgressIndicator;

import java.util.function.Consumer;

public interface Pagamento extends TelaManager {
    void realizarPagamento(Carro carro, ProgressIndicator progress, Consumer<Void> chamarTelaCallback);
}
