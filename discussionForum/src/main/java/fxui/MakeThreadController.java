package fxui;

import discussionForum.Folder;
import discussionForum.Thread;
import discussionForum.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.time.LocalDateTime;

public class MakeThreadController extends AbstractController{

    @FXML
    TextField content;

    @FXML
    Button post;

    @FXML
    Button back;

    @FXML
    TextField title;


    protected void onSceneSwitch() {
        super.onSceneSwitch();
        back.setOnAction(event -> {
            switchScene(AvailableSceneName.THREADS_IN_FOLDER);
        });
        post.setOnAction(event -> {
            String content1 = content.getText();
            String title1 = title.getText();
            Folder folder = getForum().getCurrentFolder();
            User user = getForum().getCurrentUser();
            folder.postThread(title1, content1, user);
            switchScene(AvailableSceneName.THREADS_IN_FOLDER);
        });
    }


}
