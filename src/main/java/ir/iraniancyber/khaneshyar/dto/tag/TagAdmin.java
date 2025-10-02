package ir.iraniancyber.khaneshyar.dto.tag;

public class TagAdmin {
    private int id;
    private String name;
    private String slug;
    private int postId;

    public TagAdmin(int id, String name, String slug,int postId) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.postId=postId;
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
