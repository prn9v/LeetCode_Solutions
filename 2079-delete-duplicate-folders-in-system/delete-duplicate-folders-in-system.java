
public class Solution {
    static class TrieNode {
        String name;
        Map<String, TrieNode> children = new HashMap<>();
        boolean deleted = false;
        
        TrieNode(String name) {
            this.name = name;
        }
    }

    Map<String, List<TrieNode>> serializationMap = new HashMap<>();

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        TrieNode root = new TrieNode("");
        
        // Step 1: Build the Trie
        for (List<String> path : paths) {
            TrieNode current = root;
            for (String folder : path) {
                current.children.putIfAbsent(folder, new TrieNode(folder));
                current = current.children.get(folder);
            }
        }

        // Step 2: Serialize subtrees
        serialize(root);

        // Step 3: Mark duplicates for deletion
        for (List<TrieNode> group : serializationMap.values()) {
            if (group.size() > 1) {
                for (TrieNode node : group) {
                    node.deleted = true;
                }
            }
        }

        // Step 4: DFS to collect valid paths
        List<List<String>> result = new ArrayList<>();
        dfs(root, new ArrayList<>(), result);
        return result;
    }

    private String serialize(TrieNode node) {
        if (node.children.isEmpty()) return "";

        List<String> serials = new ArrayList<>();
        for (TrieNode child : node.children.values()) {
            String serial = serialize(child);
            serials.add(child.name + "(" + serial + ")");
        }
        Collections.sort(serials); // Ensure identical subtrees have the same string
        String subtree = String.join("", serials);

        serializationMap.computeIfAbsent(subtree, k -> new ArrayList<>()).add(node);
        return subtree;
    }

    private void dfs(TrieNode node, List<String> path, List<List<String>> result) {
        for (TrieNode child : node.children.values()) {
            if (child.deleted) continue;
            path.add(child.name);
            result.add(new ArrayList<>(path));
            dfs(child, path, result);
            path.remove(path.size() - 1);
        }
    }
}
