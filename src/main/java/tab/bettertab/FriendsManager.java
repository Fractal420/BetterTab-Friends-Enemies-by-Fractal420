package tab.bettertab;

import com.google.gson.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class FriendsManager {

    // Path to Minecraft config folder
    private static final Path FRIENDS_FILE = Paths.get(System.getProperty("user.home"),
            ".minecraft", "config", "friends.json");
    private static final Set<String> friends = new HashSet<>();

    static {
        loadFriends(); // Load friends on startup
    }

    /** Check if a player is in the friends list */
    public static boolean isFriend(String name) {
        return friends.contains(name.toLowerCase());
    }

    /** Load or create the friends JSON file */
    public static void loadFriends() {
        friends.clear();
        try {
            // If file does not exist, create it with empty array
            if (!Files.exists(FRIENDS_FILE)) {
                Files.createDirectories(FRIENDS_FILE.getParent());
                JsonObject obj = new JsonObject();
                obj.add("friends", new JsonArray());
                Files.writeString(FRIENDS_FILE, new GsonBuilder().setPrettyPrinting().create().toJson(obj));
                System.out.println("[BetterTab] Created new friends.json at " + FRIENDS_FILE.toAbsolutePath());
            }

            // Read the file
            String json = Files.readString(FRIENDS_FILE);
            JsonObject obj = JsonParser.parseString(json).getAsJsonObject();
            JsonArray arr = obj.getAsJsonArray("friends");

            for (JsonElement el : arr) {
                friends.add(el.getAsString().toLowerCase());
            }

            System.out.println("[BetterTab] Loaded " + friends.size() + " friends from JSON.");
        } catch (Exception e) {
            System.err.println("[BetterTab] Failed to load friends.json: " + e.getMessage());
        }
    }

    /** Return a Text object colored green if player is a friend */
    public static Text colorizeIfFriend(String name) {
        if (isFriend(name)) {
            return Text.literal(name).formatted(Formatting.GREEN);
        }
        return Text.literal(name);
    }
}
