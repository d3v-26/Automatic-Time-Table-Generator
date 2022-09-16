package view;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import controller.MainController;
import controller.PaneNavigator;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Class;
import model.Course;
import model.Instructor;
import model.Room;
import model.StudentsGroup;

public class App extends Application {

    private Stage primaryStage;
    private ObservableList<Room> RoomData = FXCollections.observableArrayList();
    private ObservableList<StudentsGroup> GroupData = FXCollections.observableArrayList();
    private ObservableList<Course> CourseData = FXCollections.observableArrayList();
    private ObservableList<Instructor> InstructorData = FXCollections.observableArrayList();
    private ObservableList<Class> ClassData = FXCollections.observableArrayList();
    private HashMap<String,Boolean> workingDays = new HashMap<>();
    private ObservableList<Class> generatedTableData = FXCollections.observableArrayList();
    private int periodsCount = 5;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        initialize();
        primaryStage.setTitle("Time Table Generator");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("file:resources/images/logo.png"));
        primaryStage.setScene(createScene(loadMainPane()));
        primaryStage.show();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void initialize(){
        System.out.println("init");
        Room r4 = new Room("4");
        Room r2 = new Room("2");
        Room r1 = new Room("1");
        Room r3 = new Room("3");
        RoomData.addAll(r4,r2,r1,r3);

        StudentsGroup firstYear = new StudentsGroup("First Year");
        StudentsGroup secondYear = new StudentsGroup("Second Year");
        StudentsGroup thirdYear = new StudentsGroup("Third Year");
        StudentsGroup fourthYear = new StudentsGroup("Fourth Year");
        GroupData.addAll(firstYear,secondYear,thirdYear,fourthYear);

        Course firstPP14 = new Course("Python","PP14");
        Course firstCS111 = new Course("Software Engineering","CS111");
        Course firstCS122 = new Course("Data Analysis and Algorithms","CS122");
        Course firstCS131 = new Course("Discrete Mathemtics","CS131");
        Course firstCAS111 = new Course("Computer Architecture","CAS111");
        Course firstCJ172 = new Course("J2EE","CJ172");
        CourseData.addAll(firstPP14,firstCS111,firstCS122,firstCS131,firstCAS111,firstCJ172);

        Instructor DrMTM  = new Instructor("Dr MTM ");
        Instructor DrSSS = new Instructor("Dr SSS");
        Instructor DrSMM = new Instructor("Dr SMM");
        Instructor DrNJB = new Instructor("Dr NJB");
        Instructor DrBSB = new Instructor("Dr BSB");
        Instructor DrPCC = new Instructor("Dr PCC");
        Instructor DrVND = new Instructor("Dr VND");
        InstructorData.addAll(DrMTM ,DrSSS,DrSMM,DrNJB,DrBSB,DrPCC,DrVND);

        Class digitalLec1 = new Class(firstCS131,"Lec",DrBSB,firstYear,r4);
        Class societyLec = new Class(firstCJ172,"Lec",DrVND,firstYear,r4);
        Class DSLec1 = new Class(firstCS122,"Lec",DrNJB,firstYear,r4);
        Class probLec1 = new Class(firstCS111,"Lec",DrSMM,firstYear,r4);
        Class mathLec1 = new Class(firstPP14,"Lec",DrMTM ,firstYear,r4);
        Class EELec1 = new Class(firstCAS111,"Lec",DrPCC,firstYear,r4);
        Class digitalLec2 = new Class(firstCS131,"Lec",DrBSB,firstYear,r4);
        Class probLec2 = new Class(firstCS111,"Lec",DrSMM,firstYear,r4);
        Class mathLec2 = new Class(firstPP14,"Lec",DrSSS,firstYear,r4);
        Class DSLec2 = new Class(firstCS122,"Lec",DrNJB,firstYear,r4);
        Class EELec2 = new Class(firstCAS111,"Lec",DrPCC,firstYear,r4);

        Class digitalLec11 = new Class(firstCS131,"Lec",DrBSB,secondYear,r2);
        Class societyLec1 = new Class(firstCJ172,"Lec",DrVND,secondYear,r2);
        Class DSLec11 = new Class(firstCS122,"Lec",DrNJB,secondYear,r2);
        Class probLec11 = new Class(firstCS111,"Lec",DrSMM,secondYear,r2);
        Class mathLec11 = new Class(firstPP14,"Lec",DrMTM ,secondYear,r2);
        Class EELec11 = new Class(firstCAS111,"Lec",DrPCC,secondYear,r2);
        Class digitalLec21 = new Class(firstCS131,"Lec",DrBSB,secondYear,r2);
        Class probLec21 = new Class(firstCS111,"Lec",DrSMM,secondYear,r2);
        Class mathLec21 = new Class(firstPP14,"Lec",DrSSS,secondYear,r2);
        Class DSLec21 = new Class(firstCS122,"Lec",DrNJB,secondYear,r2);
        Class EELec21 = new Class(firstCAS111,"Lec",DrPCC,secondYear,r2);

        ClassData.addAll(digitalLec1,societyLec,DSLec1,probLec1,mathLec1,EELec1,digitalLec2,probLec2,
                mathLec2,DSLec2,EELec2,digitalLec11,societyLec1,DSLec11,probLec11,mathLec11,EELec11,
                digitalLec21,probLec21,mathLec21,DSLec21,EELec21);

        
        workingDays.put("monday",true);
        workingDays.put("tuesday",true);
        workingDays.put("wednesday",true);
        workingDays.put("thursday",true);
        workingDays.put("friday",true);
        workingDays.put("saturday",true);
        workingDays.put("sunday",false);
    }

    private Pane loadMainPane() throws IOException {
        FXMLLoader loader = new FXMLLoader(new URL("file:resources/fxml/" + PaneNavigator.MAIN_PANE));
        //loader.setLocation(new URL("file:resources/fxml/" + PaneNavigator.MAIN_PANE));
        //Pane mainPane = loader.load();
        Pane mainPane = loader.load();
        MainController mainController = loader.getController();
        PaneNavigator.setMainApp(this);
        PaneNavigator.setMainController(mainController);
        PaneNavigator.loadPane(PaneNavigator.START_PANE);

        return mainPane;
    }

    private Scene createScene(Pane mainPane) {
        Scene scene = new Scene(mainPane);
        //new URL("file:resources/style/tab.css)
        File f = new File("resources/style/tab.css");
        scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));
        //scene.getStylesheets().add(this.getClass().getResource("/resources/style/tab.css").toExternalForm());
        f = new File("resources/style/style.css");
        scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));
        return scene;
    }


    public static void main(String[] args) {
        launch();
    }

    public ObservableList<Room> getRoomData() {
        return RoomData;
    }

    public ObservableList<StudentsGroup> getGroupData() {
        return GroupData;
    }

    public ObservableList<Course> getCourseData() {
        return CourseData;
    }

    public ObservableList<Instructor> getInstrutorData() {
        return InstructorData;
    }

    public ObservableList<Class> getClassData() {
        return ClassData;
    }

    public HashMap<String,Boolean> getWorkingDays() {
        return workingDays;
    }

    public int getPeriodsCount() {
        return periodsCount;
    }

    public void setPeriodsCount(int periodsCount) {
        this.periodsCount = periodsCount;
    }

    public ObservableList<Class> getGeneratedTableData() {
        return generatedTableData;
    }

    public void setGeneratedTableData(ArrayList<Class> generatedtable){
        generatedTableData.clear();
        generatedTableData.addAll(generatedtable);
    }
}
