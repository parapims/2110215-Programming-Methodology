package pane;

import item.Book;
import javafx.css.Style;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import utils.Goto;

import java.awt.*;
import java.util.ArrayList;

public class NewBookPane extends GridPane {
    public NewBookPane(){
        setPadding(new Insets(12));
        setVgap(8);
        TextField nameField = input();
        TextField authorField = input();
        TextField ratingField = input();
        TextField imageField = input();
        TextField descriptionField = input();

        ColumnConstraints columnConstraints1 = new ColumnConstraints();
        columnConstraints1.setPercentWidth(25);
        columnConstraints1.setHalignment(HPos.RIGHT);
        ColumnConstraints columnConstraints2 = new ColumnConstraints();
        columnConstraints2.setPercentWidth(75);
        columnConstraints2.setHalignment(HPos.RIGHT);

        Button button = new Button("Add");
        button.setMaxWidth(430);
        button.setPrefHeight(32);
        button.setTextFill(Color.WHITE);
        button.setBackground(Background.fill(Color.DARKCYAN));
        button.setOnMouseClicked(event -> handleClick(nameField.getText(),authorField.getText(),ratingField.getText(),imageField.getText(),descriptionField.getText()));


        getColumnConstraints().addAll(columnConstraints1,columnConstraints2);
        add(label("Title: "), 0 , 0);
        add(label("Author: "), 0 , 1);
        add(label("Rating: "), 0 , 2);
        add(label("Image: "), 0 , 3);
        add(label("Description: "), 0 , 4);

        add(nameField,1,0);
        add(authorField,1,1);
        add(ratingField,1,2);
        add(imageField,1,3);
        add(descriptionField,1,4);
        add(button,0,5,2,1);
    }

    private Text label(String s){
        Text text = new Text(s);
        text.setFont(Font.font(16));
        return text;
    }
    private TextField input(){
        TextField textField = new TextField();
        textField.setBackground(new Background(new BackgroundFill(Color.WHITE,new CornerRadii(16),null)));
        Border border = new Border(
                new BorderStroke(
                        Color.DARKCYAN,
                        BorderStrokeStyle.SOLID,
                        new CornerRadii(16),
                        BorderWidths.DEFAULT
                )
        );
        textField.setBorder(border);
        return textField;
    }
    private void handleClick(String name, String author, String rating, String image, String description){
        if(name.isBlank()||author.isBlank()||rating.isBlank()||image.isBlank()||description.isBlank()) return;
        Book newBook = new Book(name,author,rating,image,description);
        BookListPane.getInstance().getBooks().add(newBook);
        BookListPane.getInstance().setSearchedBooks(BookListPane.getInstance().getBooks());
        Goto.mainPage();
    }
}
