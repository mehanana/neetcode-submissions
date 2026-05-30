class CountSquares {
    HashMap<String, Integer> pointCount;
    List<int[]> pointsList;

    public CountSquares() {
        pointCount = new HashMap<>();
        pointsList = new ArrayList<>();
    }

    public void add(int[] point) {
        String key = point[0] + "," + point[1];
        if (!pointCount.containsKey(key)) {
            pointsList.add(point);
        }
        pointCount.put(key, pointCount.getOrDefault(key, 0) + 1);
    }

    public int count(int[] point) {
        int px = point[0], py = point[1];
        int total = 0;

        for (int[] p2 : pointsList) {
            int qx = p2[0], qy = p2[1];
            if (qy != py || qx == px) continue;

            int side = Math.abs(qx - px);
            int p2cnt = getCount(qx, qy);
            total += p2cnt * getCount(px, py + side) * getCount(qx, qy + side);
            total += p2cnt * getCount(px, py - side) * getCount(qx, qy - side);
        }

        return total;
    }

    private int getCount(int x, int y) {
        return pointCount.getOrDefault(x + "," + y, 0);
    }
}