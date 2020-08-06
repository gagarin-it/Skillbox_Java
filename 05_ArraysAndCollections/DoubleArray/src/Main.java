public class Main {

  public static void main(String[] args) {
    final int HEIGHT_ARRAY = 7;
    final int WIDTH_ARRAY = 7;

    String[][] cross = new String[WIDTH_ARRAY][HEIGHT_ARRAY];
    for (int i = 0; i < cross.length; i++) {
      for (int j = 0; j < cross[i].length; j++) {
        if ((j + i) % (cross[i].length - 1) == 0 || (j - i) % (cross[i].length - 1) == 0) {
          cross[i][j] = "X";
        } else {
          cross[i][j] = " ";
        }
      }
    }
    for (int i = 0; i < cross.length; i++) {
      for (int j = 0; j < cross[i].length; j++) {
        System.out.print(cross[i][j]);
      }
      System.out.println();
    }
  }
}