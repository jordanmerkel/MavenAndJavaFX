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
import java.sql.*;

/**
 * main class for the program
 */
public class Main extends Application
{
    //--------------------------------------INSTANCE VARIABLES------------------------------------------------------
    private TextField name = new TextField("");
    private TextField code = new TextField("");
    private TextField state = new TextField("");
    private Label languages = new Label("");
    private Label cities = new Label("");
    private String sql = "";
    private int selection = 1;
    //--------------------------------------------------------------------------------------------------------------

    /**
     * this method sets the SQL command that will be performed based on what the user does.
     */
    public void setSQL()
    {
        if(selection == 1)
        {
            sql = "SELECT Country.Name, Country.Code, Country.HeadOfState, CountryLanguage.Language, City.Name " +
                    "FROM Country " +
                    "INNER JOIN CountryLanguage ON Country.Code = CountryLanguage.CountryCode " +
                    "INNER JOIN City ON Country.Code = City.CountryCode " +
                    "WHERE Country.Code = ?";
        }
        else if(selection == 2)
        {
            sql = "SELECT Country.Name, Country.Code, Country.HeadOfState, CountryLanguage.Language, City.Name " +
                    "FROM Country " +
                    "INNER JOIN CountryLanguage ON Country.Code = CountryLanguage.CountryCode " +
                    "INNER JOIN City ON Country.Code = City.CountryCode " +
                    "WHERE Country.Name LIKE ?";
        }
        else
        {

        }
    }

    /**
     * this method performs the SQL code
     * @param insert
     */
    public void trycatch(String insert)
    {
        try
        {
            String url = "jdbc:sqlite:C:\\Users\\jjjme\\IdeaProjects\\Homework13\\src\\main\\resources\\World";
            Connection connection = DriverManager.getConnection(url);

            PreparedStatement statement = connection.prepareStatement(sql);

            if (selection ==2)
            { // this is needed so the user can type "United" and get "United States"
                statement.setString(1, insert + "%");
            }
            else
            {
                statement.setString(1, insert);
            }

            ResultSet rSet = statement.executeQuery();

            while (rSet.next())
            {
                name.setText(rSet.getString("Name"));
                code.setText(rSet.getString("Code"));
                state.setText(rSet.getString("HeadOFState"));
                languages.setText(rSet.getString("Language"));
                cities.setText(rSet.getString(5));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * this starts the stage and scene on the JavaFX application
     * @param primaryStage
     * @throws Exception
     */
    public void start(Stage primaryStage) throws Exception
    {
        //--------------------BUTTONS--------------------------------------
        Button prevBtn = new Button("Previous");
        prevBtn.setOnAction(new prevBtnHandler());
        Button nextBtn = new Button("Next");
        nextBtn.setOnAction(new nextBtnHandler());
        Button searchBtn = new Button("Search");
        searchBtn.setOnAction(new searchBtnHandler());
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
        HBox hBox2 = new HBox(10,codeLabel,code,searchBtn);
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

    private class searchBtnHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            String tempName = name.getText();
            String tempCode = code.getText();

            if(tempName.isEmpty() == false & tempCode.isEmpty() == false)
            {
                selection = 1;
                setSQL();
                trycatch(tempCode);
            }
            else if(tempName.isEmpty() == true & tempCode.isEmpty() == false)
            {
                selection = 1;
                setSQL();
                trycatch(tempCode);
            }
            else if (tempName.isEmpty() == false & tempCode.isEmpty() == true)
            {
                selection = 2;
                setSQL();
                trycatch(tempName);
            }
            else
            {

            }
        }
    }
}//end of Main
