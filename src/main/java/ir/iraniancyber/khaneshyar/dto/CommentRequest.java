package ir.iraniancyber.khaneshyar.dto;

public class CommentRequest {
    private String content;
    private String postSlug;

    public CommentRequest(String content, String postSlug) {
        this.content = content;
        this.postSlug = postSlug;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPostSlug() {
        return postSlug;
    }

    public void setPostSlug(String postSlug) {
        this.postSlug = postSlug;
    }
}
