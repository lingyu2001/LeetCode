class Solution {
    Map<String, Set<String>> map = new HashMap<>();
    Map<String, String> emails = new HashMap<>();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        for (List<String> list : accounts) {
            String name = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                emails.put(list.get(i), name);
                if (!map.containsKey(list.get(i))) map.put(list.get(i), new HashSet<>());
                if (i == 1) continue;
                map.get(list.get(i)).add(list.get(i - 1));
                map.get(list.get(i - 1)).add(list.get(i));
            }
        }

        Set<String> visited = new HashSet<>();
        List<List<String>> res = new ArrayList<>();

        for (String e : emails.keySet()) {
            List<String> list = new ArrayList<>();
            if (visited.add(e)) {
                dfs(e, visited, list);
                Collections.sort(list);
                list.add(0, emails.get(e));
                res.add(list);
            }
        }
        return res;
    }

    public void dfs(String email, Set<String> visited, List<String> list) {
        list.add(email);
        for (String n : map.get(email)) {
            if (visited.add(n)) {
                dfs(n, visited, list);
            }
        }
    }
}