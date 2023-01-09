class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (sr > image.length && sc > image[0].length) return image;
        if(color != image[sr][sc]) flood(image, sr, sc, image[sr][sc],color);
        return image;
    }
  
    public void flood(int[][] image, int sr, int sc, int prevcolor, int color){
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) return;
        if (image[sr][sc] != prevcolor) return;
        image[sr][sc] = color;
        flood(image, sr+1, sc, prevcolor, color);
        flood(image, sr-1, sc, prevcolor, color);
        flood(image, sr, sc+1, prevcolor, color);
        flood(image, sr, sc-1, prevcolor, color);
    }
}
