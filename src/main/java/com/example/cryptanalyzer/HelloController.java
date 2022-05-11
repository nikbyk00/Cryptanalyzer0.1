package com.example.cryptanalyzer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class HelloController {

    @FXML
    protected Button encryption;
    @FXML
    protected Button decryption;
    @FXML
    protected Button bruteForce;

    @FXML
    void actionEncryption(){
        encryption.setOnAction(event -> {
            Encryption.encryptText();
        });
    }
    @FXML
    void actionDecryption(){
        decryption.setOnAction(event -> {
            Decryption.decryptionOfTheText();
        });
    }
    @FXML
    void actionBruteForce(){
        bruteForce.setOnAction(event -> {
            BruteForce.decodingBruteForce();
        });
    }
}