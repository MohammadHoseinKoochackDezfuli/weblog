package ir.iraniancyber.khaneshyar.service;

public class SlugUtil {
    public static String toSlug(String input) {
        return input
                .toLowerCase()
                .replaceAll("[^a-z0-9]+", "-")
                .replaceAll("^-|-$", "");
    }
}