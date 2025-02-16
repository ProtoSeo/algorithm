class ProductOfNumbers {

    List<Integer> totalProduct;
    int size = 0;

    public ProductOfNumbers() {
        this.totalProduct = new ArrayList<>();
        this.totalProduct.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            totalProduct = new ArrayList<>();
            totalProduct.add(1);
            size = 0;
            return;
        }
        totalProduct.add(totalProduct.get(size) * num);
        size++;
    }

    public int getProduct(int k) {
        if (size < k) {
            return 0;
        }
        return totalProduct.get(size) / totalProduct.get(size - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
