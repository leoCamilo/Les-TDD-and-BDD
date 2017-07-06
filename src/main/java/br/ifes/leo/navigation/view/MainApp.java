package br.ifes.leo.navigation.view;

import br.ifes.leo.navigation.control.City;
import br.ifes.leo.navigation.model.AbstractDirectionalAppraiser;

public class MainApp {
    public static void main(String[] args) {
        String testStr = "Leste Paris Amsterdam Barcelona Porto";
        City out = AbstractDirectionalAppraiser.process(testStr);
        out.answer();
    }
}