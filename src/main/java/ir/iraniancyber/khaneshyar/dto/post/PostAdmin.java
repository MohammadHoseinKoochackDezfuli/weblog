package ir.iraniancyber.khaneshyar.dto.post;

import ir.iraniancyber.khaneshyar.model.Status;

import java.time.LocalDateTime;

public class PostAdmin {
    private final int id;
    private final String title;
    private final String slug;
    private final String excerpt;
    private final Status status;
    private final int userId;
    private final LocalDateTime createdAt;
    private final LocalDateTime updateAt;
    private final LocalDateTime publishAt;
    private final int views;
    private final int categoryId;

    public PostAdmin(int id, String title, String slug, String excerpt, Status status, int userId, LocalDateTime createdAt, LocalDateTime updateAt, LocalDateTime publishAt, int views, int categoryId) {
        this.id = id;
        this.title = title;
        this.slug = slug;
        this.excerpt = excerpt;
        this.status = status;
        this.userId = userId;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.publishAt = publishAt;
        this.views = views;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSlug() {
        return slug;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public Status getStatus() {
        return status;
    }

    public int getUserId() {
        return userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public LocalDateTime getPublishAt() {
        return publishAt;
    }

    public int getViews() {
        return views;
    }

    public int getCategoryId() {
        return categoryId;
    }
}
