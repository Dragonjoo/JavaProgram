package sample;

/**
 * Created by Philadelphia on 5/22/2016.
 */
        import javafx.scene.*;

        import java.awt.List;
        import java.awt.event.*;
        import java.awt.event.ItemListener;

        import javafx.beans.binding.*;
        import javafx.beans.value.ObservableValue;
        import javafx.collections.ObservableList;
        import javafx.fxml.Initializable;
        import javafx.scene.control.*;
        import javafx.scene.layout.*;
        import javafx.beans.value.ChangeListener;



public class Scenes extends Main {
    Scene scene1;
    Scene scene2;
    Scene scene3;
    ToggleGroup ques1;
    RadioButton ans2;
    static int attempts;

    //Since I am only changing the Center part of A BorderPane its type Layout
    public VBox Question1()
    {
        Button Submit = new Button("Submit");
        Label Question1 = new Label("What Lies at the farthest reaches of the universe?");

        //Radio Buttons
        RadioButton ans1 = new RadioButton("Stars");
        RadioButton ans2 = new RadioButton("Last Exile");
        RadioButton ans3 = new RadioButton("The Sun");
        //ToggleButton adds a button with Text, as part of the togglegroup only one can be selected
        ToggleButton ans4 = new ToggleButton("This is Toggle");

        //Adding Items to toggleGroup
        ToggleGroup ques1= new ToggleGroup();
        ans1.setToggleGroup(ques1);
        ans2.setToggleGroup(ques1);
        ans3.setToggleGroup(ques1);
        ans4.setToggleGroup(ques1);


        VBox layout = new VBox();
        //Adding the Radio Buttons Vertically
        VBox Radio = new VBox();
        Radio.getChildren().addAll(ans1, ans2, ans3, ans4);
        Radio.setSpacing(5);



        //New Listener NOT WORKINH
       /* ques1.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
		      public void changed(ObservableValue<? extends Toggle> ov,
		          Toggle old_toggle, Toggle new_toggle) {
		        if (ques1.getSelectedToggle() == ans2)
		        {layout =  Question2();};}}
		        */


        //ADDING ALL ITEMS TO THE LAYOUT
        layout.getChildren().addAll(Question1, Radio, Submit);
        layout.setSpacing(15);

        //Action for submit Button
        //Need to add a Submit button checker!!
        Submit.setOnAction(e-> {
            layout.getChildren().removeAll(Question1, Radio, Submit);
            layout.getChildren().add(Question2());});


        //scene1 = new Scene(layout);
        return layout;
    }

    public VBox Question2()
    {
        Button Submit = new Button("Submit");
        Label Question1 = new Label("Choose all the Mammals in the group");
        //Check Boxes
        CheckBox dog1 = new CheckBox("Dog");
        CheckBox spider1 = new CheckBox("Spider");
        CheckBox whale1 = new CheckBox("Whale");
        CheckBox snake1 = new CheckBox("Snake");

        //Adding the Radio Buttons Vertically
        VBox layout = new VBox();
        layout.getChildren().addAll(Question1, dog1, spider1, whale1, snake1, Submit);

        layout.setSpacing(15);
        scene1 = new Scene(layout);
        return layout;
    }

    //Method for the Submit button
    // NOT WORKIG
    /* private VBox clicked(ToggleGroup ques1)
    {
        VBox quest2 = new VBox();
        List list = new List();
        for(int x = 0; x<3; x++)
        {Toggle item = ques1.selectedToggleProperty().getValue();
            String item2 = item.toString();
            list.add(item2);
        }
        System.out.println(list);

        return quest2;
    }*/

     /*class handler implements ItemListener
    {
        public void itemStateChanged(ItemEvent event)
        {
            if(ItemEvent.SELECTED == "Last Exile")
            {System.out.println("it works");}
        }
    }*/
}
