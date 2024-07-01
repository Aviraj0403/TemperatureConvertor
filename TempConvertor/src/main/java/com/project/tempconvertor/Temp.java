package com.project.tempconvertor;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class Temp extends Application{

    public static void main(String[] args) {
        // launch apps
        System.out.println("main");
        launch(args);
    }

    // it is the instance of application
    @Override
    public void init() throws Exception {
        System.out.println("init");
        super.init();
    }
    // start the apps, in scene under the visualise of display
    @Override
    public void start(Stage primaryStage) throws Exception {

        System.out.println("Start");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Temp_layout.fxml"));
        VBox rootNode = loader.load();
        MenuBar menuBar=createMenu();
        rootNode.getChildren().add(0,menuBar);

        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Calculator");
//        primaryStage.setResizable(false);
        primaryStage.show();
    }
    //create method to define menu
    private MenuBar createMenu()
    {
        //for creating menu option
        Menu fileMenu=new Menu("File");
        // for create the option of given menu
        MenuItem newMenuItem= new MenuItem(" New");
        //lambda expression
        //response after the click
        newMenuItem.setOnAction(actionEvent -> System.out.println("New Menu item is clicked"));
        //same option provide under menulist
        MenuItem quitMenuItem= new MenuItem(" Quit");
        quitMenuItem.setOnAction(actionEvent -> {
            System.out.println("Quit App");
            Platform.exit(); // Application get shutdown
//                System.exit(0);
        });
        //seperator betn two option
        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
        //add all items in given option layout
        fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);

        Menu helpMenu=new Menu("Help");

        MenuItem aboutApp= new MenuItem("about");
        aboutApp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                aboutApp();
            }

            //Creating dialog box
            public static void aboutApp() {
                Alert alertDialog=new Alert(Alert.AlertType.INFORMATION);
                alertDialog.setTitle("My first DeskTop  App");
                alertDialog.setHeaderText("Learning Javafx" );
                alertDialog.setContentText(" I am learning Java Development");
                //Creating Button on Dilaog box mannually
//                ButtonBar btnm=new ButtonBar("1");
                ButtonType yesBtn=new ButtonType("Yes");
                ButtonType noBtn= new ButtonType("No");

                alertDialog.getButtonTypes().setAll(yesBtn,noBtn);
                Optional<ButtonType> clickBtn= alertDialog.showAndWait();
                if(clickBtn.isPresent() && clickBtn.get()==yesBtn)
                {
                    System.out.println("Yes Button is clicked");

                }
                if(clickBtn.isPresent()&& clickBtn.get()==noBtn)
                {
                    System.out.println("No Button is clicked");
                }

                System.out.println("Dialog is displayed ");

            }
        });
//        aboutApp.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                aboutApp();
//            }
//
//            private void aboutApp() {
//                //do it
//            }
//        });
        helpMenu.getItems().addAll(aboutApp);
        //Add menu list
        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;
    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop");
        super.stop();
    }
}
