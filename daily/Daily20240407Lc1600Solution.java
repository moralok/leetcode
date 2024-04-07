package daily;

import java.util.*;

public class Daily20240407Lc1600Solution {

    private static class ThroneInheritance {

        private final String king;
        private final Map<String, List<String>> edges;
        private final Set<String> dead;


        public ThroneInheritance(String kingName) {
            this.king = kingName;
            edges = new HashMap<>();
            edges.putIfAbsent(kingName, new ArrayList<>());
            dead = new HashSet<>();
        }

        public void birth(String parentName, String childName) {
            edges.putIfAbsent(parentName, new ArrayList<>());
            edges.get(parentName).add(childName);
        }

        public void death(String name) {
            dead.add(name);
        }

        public List<String> getInheritanceOrder() {
            List<String> order = new ArrayList<>();
            dfs(king, order);
            return order;
        }

        private void dfs(String parent, List<String> order) {
            if (!dead.contains(parent)) {
                order.add(parent);
            }
            for (String child : edges.getOrDefault(parent, new ArrayList<>())) {
                dfs(child, order);
            }
        }
    }
}
