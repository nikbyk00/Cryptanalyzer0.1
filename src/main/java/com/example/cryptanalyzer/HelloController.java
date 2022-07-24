package com.example.cryptanalyzer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;
import java.util.ArrayList;


public class HelloController {

    @FXML
    protected Button encryption;
    @FXML
    protected Button decryption;
    @FXML
    protected Button bruteForce;

    private ArrayList<String> list = new ArrayList<>();
    private Encryption encrypt = new Encryption(Alphabet.fillingWithSymbols(list));


    @FXML
    void actionEncryption() {
        encryption.setOnAction(event -> {
            try {
                encrypt.encryptText();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @FXML
    void actionDecryption() {
        decryption.setOnAction(event -> {
            try {
                encrypt.decryptionOfTheText();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @FXML
    void actionBruteForce() {
        bruteForce.setOnAction(event -> {
            BruteForce.decodingBruteForce();
        });
    }
}