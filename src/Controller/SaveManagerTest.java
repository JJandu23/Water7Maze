package Controller;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SaveManagerTest {

    @Test
    void getSaveGame() throws IOException, ClassNotFoundException {
        // Arrange
        StringWriter stringWriter = new StringWriter();
        List<String> expected = List.of("save.ser");

        // Act
        SaveManager.getSaveGame();

        // Assert
        assertEquals(expected, stringWriter.toString());
    }

    @Test
    void getLoadGame() throws IOException, ClassNotFoundException {
        StringWriter stringWriter = new StringWriter();
        List<String> expected = List.of("save.ser");

        // Act
        SaveManager.getLoadGame();

        // Assert
        assertEquals(expected, stringWriter.toString());
    }
}