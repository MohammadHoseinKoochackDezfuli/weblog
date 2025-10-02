package ir.iraniancyber.khaneshyar.dto.comment;

import java.time.LocalDateTime;

public class CommentAdmin {
    private final int id;
    private final String content;
    private final String authorName;
    private final String authorEmail;
    private final Boolean approved;
    private final LocalDateTime createdAt;
    private final String PostSlug;

    public CommentAdmin(int id, String content, String authorName, String authorEmail, Boolean approved, LocalDateTime createdAt, String postSlug) {
        this.id = id;
        this.content = content;
        this.authorName = authorName;
        this.authorEmail = authorEmail;
        this.approved = approved;
        this.createdAt = createdAt;
        PostSlug = postSlug;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public Boolean getApproved() {
        return approved;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getPostSlug() {
        return PostSlug;
    }
}
