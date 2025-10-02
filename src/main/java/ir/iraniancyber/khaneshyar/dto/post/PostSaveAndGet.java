package ir.iraniancyber.khaneshyar.dto.post;

public class PostSaveAndGet {
    private final int id;
    private final String title;
    private final String slug;
    private final String excerpt;
    private final String content;
    private final int categoryId;

    public int getCategoryId() {
        return categoryId;
    }

    public PostSaveAndGet(int id, String title, String slug, String excerpt, String content, int categoryId) {
        this.id = id;
        this.title = title;
        this.slug = slug;
        this.excerpt = excerpt;
        this.content = content;
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

    public String getContent() {
        return content;
    }
}
