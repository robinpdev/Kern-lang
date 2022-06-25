package com.example.kernlang;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * When a click is registered on a node, a pop-up of this class will appear.
 * It allows the user to draw imports or view the code of the node in the text editor.
 */
public class GraphPopUp extends Stage {
    public GraphPopUp(CursorState cursorState) {
        super();
        VBox layout = new VBox();

        // "new import" button
        Button importButton = new Button("import");
        importButton.setOnAction(e -> {
            cursorState.setStateDraggingEdge();
            this.close();
        });
        layout.getChildren().add(importButton);

        // "view in editor" button
        Button viewButton = new Button("View in Editor");
        viewButton.setOnAction(e -> this.close());
        layout.getChildren().add(viewButton);

        // "new node" button
        Button nodeButton = new Button("new Node");
        nodeButton.setOnAction(e -> {
            cursorState.drawCircle();
            this.close();
        });
        layout.getChildren().add(nodeButton);

        Scene scene = new Scene(layout, 500, 300);
        //scene.getStylesheets().add(String.valueOf(Main.class.getResource(".css")));
        this.setScene(scene);
        this.showAndWait();
    }
}