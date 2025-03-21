class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Deque<String> addedSupplies = new ArrayDeque<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < recipes.length; i++) {
            List<String> ingredient = ingredients.get(i);
            for (String supply : supplies) {
                ingredient.remove(supply);
                if (ingredient.isEmpty()) {
                    addedSupplies.add(recipes[i]);
                    result.add(recipes[i]);
                    break;
                }
            }
        }
        while (!addedSupplies.isEmpty()) {
            String supply = addedSupplies.poll();
            for (int i = 0; i < recipes.length; i++) {
                List<String> ingredient = ingredients.get(i);
                if (ingredient.isEmpty()) {
                    continue;
                }
                ingredient.remove(supply);
                if (ingredient.isEmpty()) {
                    addedSupplies.add(recipes[i]);
                    result.add(recipes[i]);
                }
            }
        }
        return result;
    }
}
