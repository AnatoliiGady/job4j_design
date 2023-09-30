package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {
    public static Info diff(Set<User> previous, Set<User> current) {
        Info rsl = new Info(0, 0, 0);
        int added = 0;
        int changed = 0;
        int deleted = 0;

        Map<Integer, String> prev = new HashMap<>();
        Map<Integer, String> curr = new HashMap<>();

        for (User user : previous) {
            prev.put(user.getId(), user.getName());
        }
        for (User user : current) {
            curr.put(user.getId(), user.getName());
        }
        for (Map.Entry<Integer, String> elementByCurr : curr.entrySet()) {
            if (!prev.containsKey(elementByCurr.getKey())) {
                added++;
                rsl.setAdded(added);
            }
            if (prev.containsKey(elementByCurr.getKey())
                    && !elementByCurr.getValue().equals(prev.get(elementByCurr.getKey()))) {
                changed++;
                rsl.setChanged(changed);
            }
        }
        for (Map.Entry<Integer, String> elementByPrev : prev.entrySet()) {
            if (!curr.containsKey(elementByPrev.getKey())) {
                deleted++;
                rsl.setDeleted(deleted);
            }
        }
        return rsl;
    }
}
