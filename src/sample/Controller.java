package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import sample.bots.ErrorLabirintBot;
import sample.bots.PassiveLabirintBot;
import sample.bots.VolkLabirintBot;
import sample.logic.Game;

public class Controller {

    LabirintPlayer yourBot = new ErrorLabirintBot();
    LabirintPlayer testBot = new VolkLabirintBot();

    @FXML
    private Pane mainPane;

    @FXML
    private Label team1Label;

    @FXML
    private Label team2Label;

    @FXML
    private Button startButton;

    @FXML
    private Label team1ScoreLabel;

    @FXML
    private Label team2ScoreLabel;

    @FXML
    private Label tickToEndLabel;

    @FXML
    private TextField ticksToEndTextField;

    @FXML
    private GridPane mainGridPane;

    private Game game = null;
    private boolean endFlagUI = false;

    @FXML
    void onMouseClickedStartButton(ActionEvent event) {
        game = new Game(yourBot, testBot, Integer.parseInt(ticksToEndTextField.getText()));
        team1Label.setText(game.getTeam1().getTeamName());
        team2Label.setText(game.getTeam2().getTeamName());
        startButton.setDisable(true);
        Thread refreshThread = new Thread(() -> {
            while (!game.isEnded()) {
                try {
                    if (!endFlagUI) {
                        game.tick();
                    }
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                } catch (RuntimeException e) {
                    Platform.runLater(() -> {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(e.getClass().getSimpleName());
                        alert.setContentText(e.getMessage());
                        endFlagUI = true;
                        alert.showAndWait();
                        System.exit(-1);
                    });
                }
                refreshUI();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Platform.runLater(() -> {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("И перед нами победителЬ");
                alert.setContentText(game.getGameState().getTeam1Score() > game.getGameState().getTeam2Score() ?
                        game.getTeam1().getTeamName() : game.getTeam2().getTeamName());
                alert.showAndWait();
                System.exit(-1);
            });
        });
        refreshThread.start();

    }

    public void refreshUI() {
        Platform.runLater(() -> {

            int[][] myMap = game.getGameState().getMap();
            mainGridPane.getChildren().clear();

            mainGridPane.setGridLinesVisible(true);
            for (int i = 0; i < game.getGameState().getHEIGHT(); ++i) {
                for (int j = 0; j < game.getGameState().getWIDTH(); ++j) {
                    StackPane pane = new StackPane();
                    String style = "-fx-background-radius: 10em 10em;";
                    if (myMap[i][j] == -1) {
                        style += "-fx-background-color: #479cf0;";

                    }
                    if (myMap[i][j] == -2) {
                        style += "-fx-background-color: #f04747;";
                    }
                    if (myMap[i][j] >= 0) {
                        style += "-fx-background-color: #efe534;";
                        String opacity = String.valueOf(((double) myMap[i][j] + 1) / 10);
                        style += "-fx-opacity: " + opacity;
                    }

                    pane.setStyle(style);
                    pane.getChildren().add(new Label(String.valueOf(myMap[i][j])));
                    mainGridPane.add(pane, j, i);
                }
            }
            mainGridPane.setGridLinesVisible(true);
            tickToEndLabel.setText(String.valueOf(game.getGameState().getTimeToEnd()));
            team1ScoreLabel.setText(String.valueOf(game.getSum1()));
            team2ScoreLabel.setText(String.valueOf(game.getSum2()));
        });

    }

}
