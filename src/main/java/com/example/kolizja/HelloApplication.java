package com.example.kolizja;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class HelloApplication extends Application {

    private static final int SCENE_WIDTH = 800;
    private static final int SCENE_HEIGHT = 600;
    private static final int BALL_RADIUS = 30;
    private static final double BALL_SPEED = 0.6;

    private double centerX;
    private double centerY;

    private double angle;
    private double deltaX;
    private double deltaY;

    @Override
    public void start(Stage stage) throws IOException {

        Group root = new Group();
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);

        stage.setTitle("Odbijanie kulki!");
        stage.setScene(scene);

        centerX = Math.random() * (SCENE_WIDTH - 2 * BALL_RADIUS) + BALL_RADIUS;
        centerY = Math.random() * (SCENE_HEIGHT - 2 * BALL_RADIUS) + BALL_RADIUS;

        Random random = new Random();
        angle = random.nextDouble() * 2 * Math.PI;
        deltaX = BALL_SPEED * Math.cos(angle);
        deltaY = BALL_SPEED * Math.sin(angle);
        Circle ball = new Circle();
        ball.setRadius(BALL_RADIUS);
        ball.setCenterX(centerX);
        ball.setCenterY(centerY);
        ball.setFill(Color.BLACK);

        root.getChildren().addAll(ball);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                centerX += deltaX;
                centerY += deltaY;

                if (centerX + BALL_RADIUS >= SCENE_WIDTH || centerX - BALL_RADIUS <= 0){
                    deltaX *= -1;
                    ball.setCenterX(SCENE_WIDTH-BALL_RADIUS);
                }
                if (centerY + BALL_RADIUS >= SCENE_HEIGHT || centerY - BALL_RADIUS <= 0){
                    deltaY *= -1;
                    ball.setCenterX(SCENE_WIDTH-BALL_RADIUS);
                }

                ball.setCenterX(centerX);
                ball.setCenterY(centerY);

            }
        };

        timer.start();





        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}