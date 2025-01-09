import java.util.*;

class RandomizedSet {

    private Set<Integer> set;
    private Random rand;

    public RandomizedSet() {
        this.set = new TreeSet<>();
        this.rand = new Random();
    }

    public boolean insert(int val) {
        return set.add(val);
    }

    public boolean remove(int val) {
        return set.remove(val);
    }

    public int getRandom() {
        int idx = rand.nextInt(set.size());
        return set.stream().mapToInt(i -> i).toArray()[idx];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
