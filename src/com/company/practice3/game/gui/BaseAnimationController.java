package com.company.practice3.game.gui;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class BaseAnimationController implements Runnable {

    private final Label label;

    private final ReentrantLock lock;

    public BaseAnimationController(Label label, ReentrantLock lock){
        this.label = label;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true){
            for (String art: ASCIIart.baseAnimation) {
                if (!lock.isLocked())
                    Platform.runLater(() -> label.setText(art));
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
