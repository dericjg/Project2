package Project2;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.shape.*;
import javafx.scene.shape.Rectangle;



public class Main extends Application
{
//constants to control the size of various controls and windows
static final int POPUP_WIDTH = 300;
static final int POPUP_HEIGHT = 300;
static final int WINDOW_WIDTH = 1000;
static final int WINDOW_HEIGHT = 1000;
static final int VISUALIZATION_WIDTH = 800;
static final int VISUALIZATION_HEIGHT = 600;
static final int TREEVIEW_WIDTH = 150;

enum Mode {
VISIT,
SCAN
}

Mode mode;

private Shape drone = new Rectangle(TREEVIEW_WIDTH, 0, 50, 50);

public void drawDrone(Pane canvas, int x, int y)
{
int actualX = TREEVIEW_WIDTH + x;
drone.setFill(Color.WHITE);
drone.setStroke(Color.RED);
drone.setStrokeWidth(1);
draw(canvas, actualX, y, 50, 50);
canvas.getChildren().add(drone);
}

public void draw(Pane canvas, int x, int y, int width, int height){
//draw the rectangle
int actualX = TREEVIEW_WIDTH + x;
Rectangle rect = new Rectangle(actualX, y, width, height);
rect.setFill(Color.WHITE);
rect.setStroke(Color.BLACK);
rect.setStrokeWidth(1);
canvas.getChildren().add(rect);
};
//update the visualization
public void update(TreeView tree, Pane canvas){
canvas.getChildren().clear();
drawDrone(canvas, (int) drone.getLayoutX(), (int) drone.getLayoutY());
ModTreeItem root = (ModTreeItem) tree.getRoot();
redraw(root, canvas);
};

public void redraw (ModTreeItem node, Pane canvas){
for(Object child : node.getChildren()){
ModTreeItem newChild = (ModTreeItem) child;

//Only draws parents with children, but not the children themselves.
if(newChild.getChildren().isEmpty()){
int x = newChild.getX();
int y = newChild.getY();
int width = newChild.getWidth();
int height = newChild.getHeight();
draw(canvas, x, y, width, height);
} else {
int x = newChild.getX();
int y = newChild.getY();
int width = newChild.getWidth();
int height = newChild.getHeight();
draw(canvas, x, y, width, height);
redraw(newChild, canvas);
}
}
};
public void scan (Pane canvas, Shape rect)
{

//Sequence Steps
//Moves drone to start (if it had been moved to an Item)
TranslateTransition StartSeq = new TranslateTransition();
StartSeq.setNode(rect);
//StartSeq.setFromX(drone.getLayoutX());
StartSeq.setToX(0);
//StartSeq.setFromY(drone.getLayoutY());
StartSeq.setToY(0);
StartSeq.setDuration(Duration.millis(1000));
StartSeq.setCycleCount(1);
StartSeq.setAutoReverse(false);


//Each row# and col# pair accounts for one x movement (across screen) and one y movement (down 100)
TranslateTransition row1 = new TranslateTransition();
row1.setNode(rect);
row1.setFromX(0);
row1.setToX(600);
row1.setDuration(Duration.millis(1000));
row1.setCycleCount(1);
row1.setAutoReverse(false);

TranslateTransition col1 = new TranslateTransition();
col1.setNode(rect);
col1.setFromY(0);
col1.setToY(100);
col1.setDuration(Duration.millis(1000));
col1.setCycleCount(1);
col1.setAutoReverse(false);


TranslateTransition row2 = new TranslateTransition();
row2.setNode(rect);
row2.setFromX(600);
row2.setToX(0);
row2.setDuration(Duration.millis(1000));
row2.setCycleCount(1);
row2.setAutoReverse(false);

TranslateTransition col2 = new TranslateTransition();
col2.setNode(rect);
col2.setFromY(100);
col2.setToY(200);
col2.setDuration(Duration.millis(1000));
col2.setCycleCount(1);
col2.setAutoReverse(false);


TranslateTransition row3 = new TranslateTransition();
row3.setNode(rect);
row3.setFromX(0);
row3.setToX(600);
row3.setDuration(Duration.millis(1000));
row3.setCycleCount(1);
row3.setAutoReverse(false);

TranslateTransition col3 = new TranslateTransition();
col3.setNode(rect);
col3.setFromY(200);
col3.setToY(300);
col3.setDuration(Duration.millis(1000));
col3.setCycleCount(1);
col3.setAutoReverse(false);


TranslateTransition row4 = new TranslateTransition();
row4.setNode(rect);
row4.setFromX(600);
row4.setToX(0);
row4.setDuration(Duration.millis(1000));
row4.setCycleCount(1);
row4.setAutoReverse(false);

TranslateTransition col4 = new TranslateTransition();
col4.setNode(rect);
col4.setFromY(300);
col4.setToY(400);
col4.setDuration(Duration.millis(1000));
col4.setCycleCount(1);
col4.setAutoReverse(false);


TranslateTransition row5 = new TranslateTransition();
row5.setNode(rect);
row5.setFromX(0);
row5.setToX(600);
row5.setDuration(Duration.millis(1000));
row5.setCycleCount(1);
row5.setAutoReverse(false);

TranslateTransition col5 = new TranslateTransition();
col5.setNode(rect);
col5.setFromY(400);
col5.setToY(500);
col5.setDuration(Duration.millis(1000));
col5.setCycleCount(1);
col5.setAutoReverse(false);


TranslateTransition row6 = new TranslateTransition();
row6.setNode(rect);
row6.setFromX(600);
row6.setToX(0);
row6.setDuration(Duration.millis(1000));
row6.setCycleCount(1);
row6.setAutoReverse(false);

TranslateTransition col6 = new TranslateTransition();
col6.setNode(rect);
col6.setFromY(500);
col6.setToY(600);
col6.setDuration(Duration.millis(1000));
col6.setCycleCount(1);
col6.setAutoReverse(false);


TranslateTransition row7 = new TranslateTransition();
row7.setNode(rect);
row7.setFromX(0);
row7.setToX(600);
row7.setDuration(Duration.millis(1000));
row7.setCycleCount(1);
row7.setAutoReverse(false);

TranslateTransition col7 = new TranslateTransition();
col7.setNode(rect);
col7.setFromY(600);
col7.setToY(700);
col7.setDuration(Duration.millis(1000));
col7.setCycleCount(1);
col7.setAutoReverse(false);


TranslateTransition row8 = new TranslateTransition();
row8.setNode(rect);
row8.setFromX(600);
row8.setToX(0);
row8.setDuration(Duration.millis(1000));
row8.setCycleCount(1);
row8.setAutoReverse(false);

TranslateTransition col8 = new TranslateTransition();
col8.setNode(rect);
col8.setFromY(700);
col8.setToY(800);
col8.setDuration(Duration.millis(1000));
col8.setCycleCount(1);
col8.setAutoReverse(false);


TranslateTransition row9 = new TranslateTransition();
row9.setNode(rect);
row9.setFromX(0);
row9.setToX(600);
row9.setDuration(Duration.millis(1000));
row9.setCycleCount(1);
row9.setAutoReverse(false);

TranslateTransition col9 = new TranslateTransition();
col9.setNode(rect);
col9.setFromY(800);
col9.setToY(900);
col9.setDuration(Duration.millis(1000));
col9.setCycleCount(1);
col9.setAutoReverse(false);


TranslateTransition row10 = new TranslateTransition();
row10.setNode(rect);
row10.setFromX(600);
row10.setToX(0);
row10.setDuration(Duration.millis(1000));
row10.setCycleCount(1);
row10.setAutoReverse(false);


//Returns drone to start
TranslateTransition returnToStart = new TranslateTransition();
returnToStart.setNode(rect);
returnToStart.setToX(0);
returnToStart.setToY(0);
returnToStart.setDuration(Duration.millis(1000));
returnToStart.setCycleCount(1);
returnToStart.setAutoReverse(false);

//Combining the steps into a full sequence
SequentialTransition scanPattern = new SequentialTransition();
scanPattern.getChildren().addAll(StartSeq, row1, col1, row2, col2, row3, col3, row4, col4, row5, col5, row6, col6, row7, col7, row8, col8, row9, col9, row10, returnToStart);
scanPattern.setCycleCount(1);
scanPattern.setAutoReverse(true);

scanPattern.play();
}

public void moveTo (int xLoc, int yLoc, Pane canvas, Shape rect)
{
//Translates drone to (xLoc, yLoc)
TranslateTransition tt = new TranslateTransition();
tt.setToX(xLoc);
tt.setToY(yLoc);
tt.setDuration(Duration.millis(1000));
tt.setCycleCount(1);
tt.setAutoReverse(false);
tt.setNode(rect);
//Copy of the last thing, which lets the drone 'hover' for the duration
TranslateTransition hover = new TranslateTransition();
hover.setToX(xLoc);
hover.setToY(yLoc);
hover.setDuration(Duration.millis(1000));
hover.setCycleCount(1);
hover.setAutoReverse(false);
hover.setNode(rect);

//Has the drone return to (0,0)
TranslateTransition th = new TranslateTransition();
th.setToX(0);
th.setToY(0);
th.setDuration(Duration.millis(1000));
th.setCycleCount(1);
th.setAutoReverse(false);
th.setNode(rect);

//Combining the steps into a full sequence
SequentialTransition moveToPattern = new SequentialTransition();
moveToPattern.getChildren().addAll(tt, hover, th);
moveToPattern.setCycleCount(1);
moveToPattern.setAutoReverse(false);

moveToPattern.play();
}

@Override
public void start(Stage primaryStage) {

////set up main UI controls
//create treeview
TreeView tree = new TreeView();
ModTreeItem root = new ModTreeItem("Root", 0, 0, 0, 50, 50);
//create some test data and insert it into the tree view
ModTreeItem testNode = new ModTreeItem("test", 1, 1, 1, 1, 1);
root.getChildren().add(testNode);
tree.setRoot(root);
Scene scene;
Stage popupStage = new Stage(); //popup window for editing the tree
HBox mainContainer = new HBox(); //root container for the UI
VBox leftContainer = new VBox();//holds left pane controls
//
Pane canvas = new Pane();//holds the visualization
canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
@Override
public void handle(MouseEvent e){
//move drone to wherever mouse was clicked
if (mode == Mode.VISIT){
	moveTo((int) e.getX() + TREEVIEW_WIDTH, (int) e.getY(), canvas, drone);
}
}
});
//

//set up radio button functionality
VBox buttons = new VBox();
RadioButton visitButton = new RadioButton("Visit");
visitButton.setOnAction(new EventHandler<ActionEvent>(){
public void handle(ActionEvent e){
//set mode to visit if button is checked
	mode = Mode.VISIT;
	//ModTreeItem selectedItem = (ModTreeItem) tree.getSelectionModel().getSelectedItem();
	//moveTo(selectedItem.getX(), selectedItem.getY(), canvas, drone);
}
});
RadioButton scanButton = new RadioButton("Scan");
scanButton.setOnAction(new EventHandler<ActionEvent>(){
public void handle(ActionEvent e){
//set mode to scan if button is checked
mode = Mode.SCAN;
scan(canvas, drone);
}
});
ToggleGroup toggleGroup = new ToggleGroup();

//
//setup pop up fields and buttons
Label nameLabel = new Label("Name: ");
TextField nameField = new TextField();
Label priceLabel = new Label("Price: ");
TextField priceField = new TextField();
Label xLabel = new Label("X: ");
TextField xField = new TextField();
Label yLabel = new Label("Y: ");
TextField yField = new TextField();
Label widthLabel = new Label("Width: ");
TextField widthField = new TextField();
Label heightLabel = new Label("Height: ");
TextField heightField = new TextField();
Button submit = new Button("Submit");
//
ContextMenu contextMenu = new ContextMenu();

//create drone
drawDrone(canvas, (int) drone.getLayoutX(), (int) drone.getLayoutY());


//create context menu items
MenuItem addItem = new MenuItem("Add Item");
//add click handler for menu item
addItem.setOnAction(new EventHandler<ActionEvent>() {
public void handle(ActionEvent e) {
VBox fieldContainer = new VBox();
fieldContainer.getChildren().clear();//clear any content in the container
fieldContainer.getChildren().addAll(nameLabel, nameField, priceLabel, priceField, xLabel, xField, yLabel, yField, widthLabel, widthField, heightLabel, heightField, submit);
//create a new scene to hold the content in the popup
Scene addItemScene = new Scene(fieldContainer, POPUP_WIDTH, POPUP_HEIGHT);
popupStage.setScene(addItemScene); //add the scene to the popup window
popupStage.show(); //show the popup window
//handle the click of the submit button
submit.setOnAction(new EventHandler<ActionEvent>() {
@Override
public void handle(ActionEvent e) {
//get the selected tree item from the tree view
TreeItem selectedItem = (TreeItem) tree.getSelectionModel().getSelectedItem();
//create new tree item and add it to the tree view
ModTreeItem newItem = new ModTreeItem(nameField.getText(), Integer.parseInt(priceField.getText()), Integer.parseInt(xField.getText()), Integer.parseInt(yField.getText()), Integer.parseInt(widthField.getText()), Integer.parseInt(heightField.getText()));
selectedItem.getChildren().add(newItem);
popupStage.hide(); //close the popup
draw(canvas, newItem.getX(), newItem.getY(), newItem.getWidth(), newItem.getHeight());
}


});

}
});
MenuItem changePrice = new MenuItem("Change Price");
changePrice.setOnAction(new EventHandler<ActionEvent>() {
public void handle(ActionEvent e) {
VBox fieldContainer = new VBox();
submit.setOnAction(new EventHandler<ActionEvent>() {
@Override
public void handle(ActionEvent e){
ModTreeItem selectedItem = (ModTreeItem) tree.getSelectionModel().getSelectedItem();
selectedItem.setPrice(Integer.parseInt(priceField.getText()));
scan(canvas, drone);
popupStage.hide();
}
});
fieldContainer.getChildren().clear();
fieldContainer.getChildren().addAll(priceLabel, priceField, submit);
Scene priceScene = new Scene(fieldContainer, POPUP_WIDTH, POPUP_HEIGHT);
popupStage.setScene(priceScene);
popupStage.show();
}
});

MenuItem changeX = new MenuItem("Change X-cord");
changeX.setOnAction(new EventHandler<ActionEvent>() {
public void handle(ActionEvent e) {
VBox fieldContainer = new VBox();
submit.setOnAction(new EventHandler<ActionEvent>() {
@Override
public void handle(ActionEvent e){
ModTreeItem selectedItem = (ModTreeItem) tree.getSelectionModel().getSelectedItem();
selectedItem.setX(Integer.parseInt(xField.getText()));
update(tree, canvas);
moveTo(selectedItem.getX(), selectedItem.getY(), canvas, drone);
popupStage.hide();
}
});
fieldContainer.getChildren().clear();
fieldContainer.getChildren().addAll(xLabel, xField, submit);
Scene changeXScene = new Scene(fieldContainer, POPUP_WIDTH, POPUP_HEIGHT);
popupStage.setScene(changeXScene);
popupStage.show();
}

});

MenuItem changeY = new MenuItem("Change Y-cord");
changeY.setOnAction(new EventHandler<ActionEvent>() {
public void handle(ActionEvent e) {
VBox fieldContainer = new VBox();
submit.setOnAction(new EventHandler<ActionEvent>() {
@Override
public void handle(ActionEvent e){
ModTreeItem selectedItem = (ModTreeItem) tree.getSelectionModel().getSelectedItem();
System.out.println(selectedItem);
selectedItem.setY(Integer.parseInt(yField.getText()));
update(tree, canvas);
popupStage.close();
System.out.println(selectedItem);
}
});
fieldContainer.getChildren().clear();
fieldContainer.getChildren().addAll(yLabel, yField, submit);
Scene changeYScene = new Scene(fieldContainer, POPUP_WIDTH, POPUP_HEIGHT);
popupStage.setScene(changeYScene);
popupStage.show();
}

});

MenuItem changeWidth = new MenuItem("Change Width");
changeWidth.setOnAction(new EventHandler<ActionEvent>() {
VBox fieldContainer = new VBox();
public void handle(ActionEvent e) {
submit.setOnAction(new EventHandler<ActionEvent>() {
@Override
public void handle(ActionEvent e){
ModTreeItem selectedItem = (ModTreeItem) tree.getSelectionModel().getSelectedItem();
selectedItem.setWidth(Integer.parseInt(widthField.getText()));
update(tree, canvas);
popupStage.hide();
}
});
fieldContainer.getChildren().clear();
fieldContainer.getChildren().addAll(widthLabel, widthField, submit);
Scene changeWidthScene = new Scene(fieldContainer, POPUP_WIDTH, POPUP_HEIGHT);
popupStage.setScene(changeWidthScene);
popupStage.show();
}
});

MenuItem changeHeight = new MenuItem("Change Height");
changeHeight.setOnAction(new EventHandler<ActionEvent>() {
public void handle(ActionEvent e) {
VBox fieldContainer = new VBox();
submit.setOnAction(new EventHandler<ActionEvent>() {
@Override
public void handle(ActionEvent e){
ModTreeItem selectedItem = (ModTreeItem) tree.getSelectionModel().getSelectedItem();
selectedItem.setHeight(Integer.parseInt(heightField.getText()));
update(tree, canvas);
popupStage.hide();
}
});
fieldContainer.getChildren().clear();
fieldContainer.getChildren().addAll(heightLabel, heightField, submit);
Scene changeHeightScene = new Scene(fieldContainer, POPUP_WIDTH, POPUP_HEIGHT);
popupStage.setScene(changeHeightScene);
popupStage.show();
}

});

//add all of the menu items to the context menu
contextMenu.getItems().addAll(addItem, changePrice, changeX, changeY, changeWidth, changeHeight);
//hook the context menu to the treeview
tree.setContextMenu(contextMenu);

//set up layout of the main window
tree.setPrefWidth(TREEVIEW_WIDTH);
canvas.setPrefWidth(VISUALIZATION_WIDTH);
canvas.setPrefHeight(VISUALIZATION_HEIGHT);
canvas.setBorder(new Border(new BorderStroke(Color.BLACK,
BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
leftContainer.setPrefWidth(200);
visitButton.setToggleGroup(toggleGroup);
scanButton.setToggleGroup(toggleGroup);
buttons.getChildren().addAll(visitButton, scanButton);
leftContainer.getChildren().addAll(tree, buttons);
mainContainer.getChildren().addAll(leftContainer, canvas);


//add the GUI controls to the main scene
scene = new Scene(mainContainer, WINDOW_WIDTH, WINDOW_HEIGHT);

//add the main scene to the primary stage and show it
primaryStage.setTitle("Drone Visualization");
primaryStage.setScene(scene);
primaryStage.show();

}
//main routine
public static void main(String[] args) {
launch(args);
}

//create the draw function

}