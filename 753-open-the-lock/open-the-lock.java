class Solution {
    public int openLock(String[] deadends, String target) {
        String start = "0000";
        Set<String> deadendSet = new HashSet<>();
        for (String d : deadends) {
            deadendSet.add(d);
        }

        Queue<Pair<String, Integer>> queue = new ArrayDeque<>();
        queue.add(new Pair(start, 0));
        Set<String> visited = new HashSet<>();
        visited.add(start);

        if (deadendSet.contains(start)) {
            return -1;
        }

        while (!queue.isEmpty()) {
            Pair<String, Integer> curr = queue.poll();
            String combination = curr.getKey();
            int turns = curr.getValue();
            char[] wheels = combination.toCharArray();

            if (combination.equals(target)) {
                return turns;
            }

            for (int i = 0; i < 4; i++) {
                char original = wheels[i];
                wheels[i] = turnUp(original);
                String next1 = new String(wheels);
                if (!visited.contains(next1) && !deadendSet.contains(next1)) {
                    visited.add(next1);
                    queue.add(new Pair(next1, turns + 1));
                }
                wheels[i] = turnDown(original);
                String next2 = new String(wheels);
                if (!visited.contains(next2) && !deadendSet.contains(next2)) {
                    visited.add(next2);
                    queue.add(new Pair(next2, turns + 1));
                }
                wheels[i] = original;
            }
        }
        return -1;
    }

    private char turnUp(char curr) {
        if (curr == '9') {
            return '0';
        }
        curr++;
        return curr;
    }

    private char turnDown(char curr) {
        if (curr == '0') {
            return '9';
        }
        curr--;
        return curr;
    }
}
