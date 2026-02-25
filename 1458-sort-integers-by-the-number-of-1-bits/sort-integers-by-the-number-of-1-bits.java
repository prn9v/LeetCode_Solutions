class Solution {
    public int[] sortByBits(int[] arr) {

        Integer[] boxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(boxed, (a, b) -> {
            int bitA = Integer.bitCount(a);
            int bitB = Integer.bitCount(b);

            if (bitA == bitB) return a - b;
            return bitA - bitB;
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = boxed[i];
        }

        return arr;
    }
}