package sample;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class Main extends Application {
    //Main Layout Manager, has top, bottom, center and bottom
    BorderPane root;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            //the Layout for the Center of the BorderPane. The place where the questions will go
            AnchorPane anchorPane = new AnchorPane();
            anchorPane.setPrefSize(600, 700);
            anchorPane.getChildren().add(thread());

            //Adding items to the Borderpane
            root = new BorderPane();
            root.setTop(Home());
            root.setLeft(Tree());
            //The center pane will change with the questions.
            root.setCenter(anchorPane);

            //Adding a wrong question counter to the bottom
            HBox bottom = new HBox();
            Label text2 = new Label("Thank you for trying our Program:");
            bottom.getChildren().add(text2);
            root.setBottom(bottom);


            Scene scene = new Scene(root,500,400);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.sizeToScene();
            primaryStage.show();
        }   catch(Exception e) {
            e.printStackTrace();
        }

    }
    //The Layout for the topBar of the BorderLayout The Menu
    public MenuBar Home()
    {
        MenuBar menuB = new MenuBar();
        menuB.setStyle("-fx-background-color: #add8e6");


        //Menu items for File
        MenuItem new1= new MenuItem("_New...");
        MenuItem restart= new MenuItem("_Restart...");

        //Menu Items for Edit
        MenuItem copy= new MenuItem("_Copy...");
        MenuItem paste= new MenuItem("_Paste...");
        MenuItem options= new MenuItem("_Options...");

        //Adding Items to the Various menu's
        Menu file = new Menu("_File");
        file.getItems().addAll(new1, restart);
        Menu edit = new Menu("_Edit");
        edit.getItems().addAll(copy, paste, options);
        menuB.getMenus().addAll(file, edit);

        return menuB;
    }
    //Layout for the Middle area
    public VBox thread()
    {

        VBox threadL = new VBox();
        Scenes quest1= new Scenes();
        Label TitleText = new Label();

        //on Button click the center layout will change to a new one.
        Button Begin = new Button("Begin");
        Begin.setOnAction(e-> root.setCenter(quest1.Question1()));

        try{

            TitleText.getStyleClass().add("label-big");
            //Bad Attempt at having a delayed message
            //TitleText.wait(3000, 3000);
            TitleText.setText("Welcome to Maths the Greatest \n Subject you Will ever Learn");
            //Thread.sleep(3000);
            Label text2 = new Label("This is line 2");
        }
        catch(Exception e)
        {}
        //CSS styles for items in the method. label-big is a custom method
        TitleText.getStyleClass().add("label-big");
        TitleText.setText("Welcome to Maths the Greatest \n Subject you Will ever Learn");

        Label text2 = new Label("This is line 2");
        threadL.getChildren().addAll(TitleText, text2, Begin);

        //threadL.setPadding(Insets(10, 10, 10, 10));
        threadL.setSpacing(30);

        return threadL;
    }

    //Layout for the TreeView on the Left
    private VBox Tree()
    {
        TreeView<String> tree;
        TreeItem<String> root;
        //Root items, Seperate Branches for the trees.
        root = new TreeItem<>("Questions");
        root.setExpanded(true);
        //Adding Leaves to the root Branch
        TreeItem<String> quest1 = new TreeItem<>("Question 1");
        TreeItem<String> quest2 = new TreeItem<>("Question 2");
        root.getChildren().addAll(quest1, quest2);

        //adding root as a branch
        tree = new TreeView<>(root);
        tree.getStyleClass().add("tree-myTree");

        //adding listener
        /*String test = tree.getSelectionModel().SelectedItemProperty().add
        System.out.println(test);
        */


        //Layout for the left side
        VBox layout = new VBox();
        layout.getChildren().add(tree);
        layout.setPrefWidth(100);
        layout.setId("vbox-tree");
        return layout;
    }


    //Separate method just in case the Changing layouts did not work. Unfinished
	/*private VBox change() {
		Scenes quest1= new Scenes();
		VBox thread1 = new VBox();
		VBox thread1 = quest1.Question1();
		return null;
	}*/
}
