package Ishaan;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;

import java.sql.*;


public class PlayersController {

    @FXML private TableView<Player> tableView;
    @FXML private TableColumn<Player, Integer> colID;
    @FXML private TableColumn<Player, String> colFirst;
    @FXML private TableColumn<Player, String> colLast;
    @FXML private TableColumn<Player, Double> colAvg;

    @FXML private TextField tfPlayerID, tfFirstName, tfMin, tfMax;

    private ObservableList<Player> players = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        colID.setCellValueFactory(cell -> new ReadOnlyObjectWrapper<>(cell.getValue().getPlayerID()));
        colFirst.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().getFirstName()));
        colLast.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().getLastName()));
        colAvg.setCellValueFactory(cell -> new ReadOnlyObjectWrapper<>(cell.getValue().getBattingAverage()));
    }

    @FXML
    private void displayAll() {
        players.clear();
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Players")) {

            while (rs.next()) {
                players.add(new Player(
                    rs.getInt("PlayerID"),
                    rs.getString("FirstName"),
                    rs.getString("LastName"),
                    rs.getDouble("BattingAverage")));
            }

            tableView.setItems(players);
        } catch (SQLException e) {
            showAlert("Database Error: " + e.getMessage());
        }
    }

    @FXML
    private void search() {
        players.clear();
        String idText = tfPlayerID.getText().trim();
        String name = tfFirstName.getText().trim();

        if (idText.isEmpty() && name.isEmpty()) {
            showAlert("Please enter Player ID or First Name");
            return;
        }

        String query = idText.isEmpty()
                ? "SELECT * FROM Players WHERE FirstName = ?"
                : "SELECT * FROM Players WHERE PlayerID = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            if (!idText.isEmpty()) {
                ps.setInt(1, Integer.parseInt(idText));
            } else {
                ps.setString(1, name);
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                players.add(new Player(
                    rs.getInt("PlayerID"),
                    rs.getString("FirstName"),
                    rs.getString("LastName"),
                    rs.getDouble("BattingAverage")));
            }

            tableView.setItems(players);
        } catch (Exception e) {
            showAlert("Search Error: " + e.getMessage());
        }
    }

    @FXML
    private void showMin() {
        if (players.isEmpty()) displayAll();
        players.stream()
            .mapToDouble(Player::getBattingAverage)
            .min()
            .ifPresent(min -> tfMin.setText(String.valueOf(min)));
    }

    @FXML
    private void showMax() {
        if (players.isEmpty()) displayAll();
        players.stream()
            .mapToDouble(Player::getBattingAverage)
            .max()
            .ifPresent(max -> tfMax.setText(String.valueOf(max)));
    }

    @FXML
    private void clear() {
        tfPlayerID.clear();
        tfFirstName.clear();
        tfMin.clear();
        tfMax.clear();
        tableView.getItems().clear();
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
