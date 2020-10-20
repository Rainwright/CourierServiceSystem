package org.aaaa.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.aaaa.CurrentUser;
import org.aaaa.Enums.GUIPath;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class DashboardController implements Initializable {
    @FXML
    AnchorPane mainPane;
    @FXML
    AnchorPane contentPane;
    @FXML
    AnchorPane ui_pane_large_tall;
    @FXML
    AnchorPane ui_pane_small_two;
    @FXML
    GridPane dashboardPane;
    @FXML
    Label mainTitle;
    @FXML
    Button sidebarButtonOne;
    @FXML
    Button sidebarButtonTwo;
    @FXML
    Button sidebarButtonThree;
    @FXML
    Button sidebarButtonFour;
    @FXML
    Button sidebarButtonFive;

    private String title;
    private Node reportMain;
    private Node previousPage;
    private FXMLLoader orderMain;
    private FXMLLoader deliveryMain;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        this.setTitle(GUIPath.Dashboard.toString());

        try{
            if(reportMain == null) {
                reportMain = (Node)FXMLLoader.load(getClass().getResource(GUIPath.ReportMain.getName()));
            }
        } catch (Exception eButton) {
            eButton.printStackTrace();
        }

        // load content
        this.loadDashboardContent();

        if (CurrentUser.getStaff().getRole().equals("managing")) {
            // load managing
            this.loadManagingContent();
        } else if (CurrentUser.getStaff().getRole().equals("delivery")) {
            // load delivery
            this.loadDeliveryContent();
        }        
    }

    // load common content
    private void loadDashboardContent() {
        try{
            // recent login
            FXMLLoader recentLogin = new FXMLLoader(getClass().getResource(GUIPath.ListViewer.getName()));
            // set custom controller to recent login
            RecentLoginListViewerController recentLoginController= new RecentLoginListViewerController();
            recentLogin.setController(recentLoginController);
            // add to dashboard pane
            ui_pane_small_two.getChildren().clear();
            ui_pane_small_two.getChildren().add((Node) recentLogin.load());

            recentLoginController.setTitle("Recent Login(s)");
            recentLoginController.setTitleButtonVisibility(false);
            
            // Sidebar Buttons
            sidebarButtonOne.setOnMouseClicked(e -> {
                this.setTitle(GUIPath.Dashboard.toString());
                this.overridePage(dashboardPane);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // load managing content and buttons
    public void loadManagingContent() {
        try{
            // order list
            FXMLLoader orderList = new FXMLLoader(getClass().getResource(GUIPath.ListViewer.getName()));
            // set custom controller to order
            OrderListViewerController orderListController = new OrderListViewerController("short");
            orderListController.setDashboardController(this);
            orderList.setController(orderListController);
            // add to dashboard pane
            ui_pane_large_tall.getChildren().clear();
            ui_pane_large_tall.getChildren().add((Node) orderList.load());
            orderListController.setTitle("Recent Orders");

            // set delay to loadables using scroll pane to avoid error
            Platform.runLater(() -> {
                orderListController.populateOrders("");
            });

            this.sidebarButtonThree.setText("Order");
            sidebarButtonThree.setOnMouseClicked(e -> {
                this.setTitle(this.sidebarButtonThree.getText());
                try{
                    orderMain = new FXMLLoader(getClass().getResource(GUIPath.OrderMain.getName()));
                    // set custom controller to order
                    OrderMainController orderMainController = new OrderMainController();
                    orderMainController.setDashboardController(this);
                    orderMain.setController(orderMainController);
                    this.overridePage((Node) orderMain.load());
                } catch (Exception err) {
                    err.printStackTrace();
                }
            });
    
            this.sidebarButtonFive.setText("Report");
            sidebarButtonFive.setOnMouseClicked(e -> {
                this.setTitle(this.sidebarButtonFive.getText());
                this.overridePage(reportMain);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // load delivery content and buttons
    public void loadDeliveryContent() {
        try{
            // delivery list
            FXMLLoader deliveryList = new FXMLLoader(getClass().getResource(GUIPath.ListViewer.getName()));
            // set custom controller to delivery
            DeliveryListViewerController deliveryListController = new DeliveryListViewerController();
            deliveryList.setController(deliveryListController);

            // add to dashboard pane
            ui_pane_large_tall.getChildren().clear();
            ui_pane_large_tall.getChildren().add((Node) deliveryList.load());

            deliveryListController.setTitle("Deliveries");
            deliveryListController.setTitleButtonVisibility(false);

            this.sidebarButtonThree.setText("Delivery");
            sidebarButtonThree.setOnMouseClicked(e -> {
                this.setTitle(this.sidebarButtonThree.getText());
                try{
                    deliveryMain = new FXMLLoader(getClass().getResource(GUIPath.DeliveryMain.getName()));
                    // set custom controller to order
                    DeliveryMainController deliveryMainController = new DeliveryMainController();
                    deliveryMainController.setDashboardController(this);
                    deliveryMain.setController(deliveryMainController);
                    this.overridePage((Node) deliveryMain.load());
                } catch (Exception err) {
                    err.printStackTrace();
                }
            });
            
            this.sidebarButtonFive.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void overridePage(Node value) {
        if(!contentPane.getChildren().contains(value)) {
            this.previousPage = contentPane.getChildren().get(0);
            this.loadDashboardContent();
            
            contentPane.getChildren().remove(0);
            contentPane.getChildren().add(value);
        }
    }

    public void loadPreviousPage() {
        this.overridePage(previousPage);
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        mainTitle.setText(this.title);
    }
}
