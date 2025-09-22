package ir.iraniancyber.khaneshyar.dto;

import java.time.LocalDateTime;

public class CommentDto {
    private String content;
    private String authorName;
    private LocalDateTime createdAt;

    public CommentDto(String content, String authorName, LocalDateTime createdAt) {
        this.content = content;
        this.authorName = authorName;
        this.createdAt = createdAt;
    }

    public String getContent() {
        return content;
    }

    public String getAuthorName() {
        return authorName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
