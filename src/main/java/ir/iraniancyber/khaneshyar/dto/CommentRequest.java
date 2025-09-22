package ir.iraniancyber.khaneshyar.dto;

public class CommentRequest {
    private String content;
    private int postId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}
