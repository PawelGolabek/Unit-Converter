module pl.polsl.przelicznikjednostekg {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens pl.polsl.przelicznikjednostekg to javafx.fxml;
    exports pl.polsl.przelicznikjednostekg;
}
