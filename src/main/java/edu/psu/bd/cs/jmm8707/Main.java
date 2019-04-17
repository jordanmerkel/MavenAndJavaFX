package edu.psu.bd.cs.jmm8707;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application
{
    //--------------------------------------INSTANCE VARIABLES------------------------------------------------------
    private TextField name = new TextField("");
    private TextField code = new TextField("");
    private TextField state = new TextField("");
    private Label languages = new Label("");
    private Label cities = new Label("");
    //--------------------------------------------------------------------------------------------------------------



    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set. The primary stage will be embedded in
     *                     the browser if the application was launched as an applet.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages and will not be embedded in the browser.
     */
    public void start(Stage primaryStage) throws Exception
    {
        //--------------------BUTTONS--------------------------------------
        Button prevBtn = new Button("Previous");
        prevBtn.setOnAction(new prevBtnHandler());
        Button nextBtn = new Button("Next");
        nextBtn.setOnAction(new nextBtnHandler());
        //-----------------------------------------------------------------

        //--------------------LABELS----------------------------------------
        Label label = new Label("Search for a country by name or 3 letter code then hit 'Search'");
        Label nameLabel = new Label("Country Name:");
        Label codeLabel = new Label("Country Code:");
        Label stateLabel = new Label("Head of State:");
        Label languagesLabel = new Label("List of Languages Spoken:");
        Label citiesLabel = new Label("Cities in the country:");
        //------------------------------------------------------------------

        //------------------CONTAINERS--------------------------------------
        HBox topHBox = new HBox(30,label);
        topHBox.setMinWidth(400);
        topHBox.setAlignment(Pos.CENTER);
        HBox hBox1 = new HBox(10,nameLabel,name);
        HBox hBox2 = new HBox(10,codeLabel,code);
        HBox hBox3 = new HBox(10,stateLabel,state);
        HBox hBox4 = new HBox(10,languagesLabel,languages);
        HBox hBox5 = new HBox(10,citiesLabel,cities);
        VBox middleVBox = new VBox(40,hBox1,hBox2,hBox3,hBox4,hBox5);
        middleVBox.setAlignment(Pos.CENTER);
        HBox bottomHBox = new HBox(30,prevBtn,nextBtn);
        bottomHBox.setAlignment(Pos.CENTER);
        VBox mainVBox = new VBox(20,topHBox,middleVBox,bottomHBox);
        //------------------------------------------------------------------


        //------------------STAGE AND SCENE---------------------------------
        Scene scene = new Scene(mainVBox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Country Database");
        primaryStage.show();
        //------------------------------------------------------------------
    }

    public static void main(String[] args)
    {
        launch(args);
    }

    private class prevBtnHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {

        }
    }

    private class nextBtnHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {

        }
    }
}
