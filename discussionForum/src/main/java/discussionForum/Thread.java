package discussionForum;

import static discussionForum.DatabaseController.db;

import java.util.ArrayList;
import java.util.Collection;

public class Thread extends Post {

    private Collection<DiscussionPost> discussionPosts = new ArrayList<>();
    private Collection<Tag> tags = new ArrayList<>();
    private String title ;

    public Thread(int postID, String title, String content, User author, boolean postType, Collection<DiscussionPost> discussionPosts) {
        super(postID, content, author, postType);
        this.discussionPosts = discussionPosts;
        this.title = title;
    }

    public void addDiscussionPost(DiscussionPost discussionPost) {
        if (!this.discussionPosts.contains(discussionPost)) {
            this.discussionPosts.add(discussionPost);
        }
    }

    public void deleteDiscussionPost(DiscussionPost discussionPost) {
        if (this.discussionPosts.contains(discussionPost)) {
            this.discussionPosts.remove(discussionPost);
        }
    }

    public void addTag(Tag tag) {
        if (!this.tags.contains(tag)) {
            this.tags.add(tag);
        }
    }

    public void deleteTag(Tag tag) {
        if (this.tags.contains(tag)) {
            this.tags.remove(tag);
        }
    }

    public void postThread(String title, String content, User author, Folder folder) {
        db.postThread(title, content, author, this.getPostedTime(), folder);
    }

    public static Collection<Integer> search(String searchWord) {
        return db.search(searchWord);
    }

}