package LeetCode_200;

import java.util.*;

public class D13_ladderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
//        Set<String> visited = new HashSet<>();
        boolean[] visited = new boolean[wordList.size()];
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
//        visited.add(beginWord);
        if(wordList.contains(beginWord)){
            visited[wordList.indexOf(beginWord)] = true;
        }
        int count = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                String start = queue.poll();
//                for (String s : wordList) {
//                    if(!visited[wordList.indexOf(s)] && Convertable(start, s)){
//                        if(s.equals(endWord)){
//                            return ++count;
//                        }
////                        visited.add(s);
//                        visited[wordList.indexOf(s)] = true;
//                        queue.offer(s);
//                    }
//                }
                for (int j = 0; j < wordList.size(); j++) {
                    String s = wordList.get(j);
                    if(!visited[j] && Convertable(start, s)){
                        if(s.equals(endWord)){
                            return ++count;
                        }
                        visited[j] = true;
                        queue.offer(s);
                    }
                }
            }
        }
        return 0;
    }

    private boolean Convertable(String s1, String s2) {
        int change = 0;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)){
                change++;
            }
            if(change > 1){
                return false;
            }
        }
        return true;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        Set<String> visited = new HashSet<>(wordList.size());
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int count = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                String start = queue.poll();
                for (String s : wordList) {
                    if(!visited.contains(s) && Convertable(start, s)){
                        if(s.equals(endWord)){
                            return ++count;
                        }
                        visited.add(s);
                        queue.offer(s);
                    }
                }
            }
        }
        return 0;
    }
}
