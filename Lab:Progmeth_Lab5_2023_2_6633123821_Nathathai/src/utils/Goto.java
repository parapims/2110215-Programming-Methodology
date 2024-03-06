package utils;

import item.Book;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import pane.BookListPane;
import pane.NewBookPane;
import pane.RootPane;
import pane.SearchPane;

import static javafx.geometry.Pos.*;

public class Goto {
    private static RootPane rootPane;

    public static void setRootPane(RootPane rootPane) {
        Goto.rootPane = rootPane;
    }
    public static void clear(){
        if(rootPane.getChildren().size() > 1){
            rootPane.getChildren().remove(1,rootPane.getChildren().size());
        }
    }
    public static void mainPage(){
        clear();
        ScrollPane scrollPane = new ScrollPane(BookListPane.getInstance());
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        rootPane.getChildren().add(new SearchPane());
        rootPane.getChildren().add(scrollPane);
    }
    public static Button backToMainPageButton(){
        Button newButton = new Button("Back");
        newButton.setBackground(Background.fill(Color.WHITE));
        newButton.setTextFill(Color.DARKCYAN);
        newButton.setPrefWidth(300);
        Border border = new Border(
                new BorderStroke(
                        Color.DARKCYAN,
                        BorderStrokeStyle.SOLID,
                        null,
                        new BorderWidths(2)
                )
        );
        newButton.setBorder(border);
        newButton.setOnAction(event -> {
            Goto.mainPage();
        });
        return newButton;
    }
    public static void bookPage(Book book){
        clear();
        Text bookName = GetDisplay.name(book,28,336,TextAlignment.CENTER);
        Text bookAuthor = GetDisplay.author(book,24,336,TextAlignment.CENTER);
        bookAuthor.setText("By "+book.getAuthor());
        ImageView bookImage = GetDisplay.image(book,320);
        Text bookStar = GetDisplay.stars(book, 24);
        Text bookDescription = GetDisplay.Description(book,16,336);

        Button button = new Button("Back to Main Page");
        rootPane.getChildren().add(backToMainPageButton());
        rootPane.getChildren().addAll(bookName,bookAuthor,bookImage,bookStar,bookDescription);
    }
    public static void addNewBookPage(){
        clear();
        rootPane.getChildren().add(backToMainPageButton());
        rootPane.getChildren().add(new NewBookPane());
    }
}
