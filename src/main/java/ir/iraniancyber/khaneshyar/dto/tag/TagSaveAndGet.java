package ir.iraniancyber.khaneshyar.dto.tag;

public class TagSaveAndGet {
    private final int id;
    private final String name;
    private final String slug;
    private final int postId;

    public TagSaveAndGet(int id, String name, String slug, int postId) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.postId = postId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public int getPostId() {
        return postId;
    }
}
