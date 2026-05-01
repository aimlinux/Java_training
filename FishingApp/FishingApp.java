package FishingApp;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FishingApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("🎣 Java 釣り情報共有アプリ");

        // 入力フィールドの作成
        TextField fishInput = new TextField();
        fishInput.setPromptText("魚種 (例: アジ)");
        
        TextField sizeInput = new TextField();
        sizeInput.setPromptText("サイズ (cm)");

        TextField placeInput = new TextField();
        placeInput.setPromptText("場所 (例: 〇〇堤防)");

        Button addButton = new Button("釣果を報告");

        // 表示用リスト
        ListView<String> listView = new ListView<>();
        ObservableList<String> reports = FXCollections.observableArrayList();
        listView.setItems(reports);

        // ボタンを押した時の動作
        addButton.setOnAction(e -> {
            String fish = fishInput.getText();
            String size = sizeInput.getText();
            String place = placeInput.getText();

            if (!fish.isEmpty()) {
                reports.add(String.format("🐟 %s / %s cm / 📍 %s", fish, size, place));
                // 入力欄をクリア
                fishInput.clear();
                sizeInput.clear();
                placeInput.clear();
            }
        });

        // レイアウト構成
        VBox inputLayout = new VBox(10, 
            new Label("魚種:"), fishInput, 
            new Label("サイズ:"), sizeInput, 
            new Label("場所:"), placeInput, 
            addButton
        );
        inputLayout.setPadding(new Insets(15));

        VBox mainLayout = new VBox(10, inputLayout, new Label("--- 記録一覧 ---"), listView);
        mainLayout.setPadding(new Insets(10));

        Scene scene = new Scene(mainLayout, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
