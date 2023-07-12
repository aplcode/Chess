import java.util.Scanner;

public class Main {
    public static boolean result = false;

    static void upCheck(int i, int j, char[][] arr) {
        int count = 0;
        while (i >= 0) {
            if (arr[i][j] != '_' && arr[i][j] != 'K') {
                count++;
                if ((arr[i][j] == 'R' || arr[i][j] == 'Q') && count == 1) {
                    result = true;
                    break;
                }
            }
            i--;
        }
    }

    static void downCheck(int i, int j, char[][] arr) {
        int count = 0;
        while (i < 4) {
            if (arr[i][j] != '_' && arr[i][j] != 'K') {
                count++;
                if ((arr[i][j] == 'R' || arr[i][j] == 'Q') && count == 1) {
                    result = true;
                    break;
                }
            }
            i++;
        }
    }

    static void leftCheck(int i, int j, char[][] arr) {
        int count = 0;
        while (j >= 0) {
            if (arr[i][j] != '_' && arr[i][j] != 'K') {
                count++;
                if ((arr[i][j] == 'R' || arr[i][j] == 'Q') && count == 1) {
                    result = true;
                    break;
                }
            }
            j--;
        }
    }

    static void rightCheck(int i, int j, char[][] arr) {
        int count = 0;
        while (j < 4) {
            if (arr[i][j] != '_' && arr[i][j] != 'K') {
                count++;
                if ((arr[i][j] == 'R' || arr[i][j] == 'Q') && count == 1) {
                    result = true;
                    break;
                }
            }
            j++;
        }
    }

    static void leftUpDiagCheck(int i, int j, char[][] arr) {
        int count = 0;
        while (j >= 0 && i >= 0) {
            if (arr[i][j] != '_' && arr[i][j] != 'K') {
                count++;
                if ((arr[i][j] == 'B' || arr[i][j] == 'Q') && count == 1) {
                    result = true;
                    break;
                }
            }
            j--;
            i--;
        }
    }

    static void leftDownDiagCheck(int i, int j, char[][] arr) {
        int count = 0;
        while (j >= 0 && i < 4) {
            if (arr[i][j] != '_' && arr[i][j] != 'K') {
                count++;
                if ((arr[i][j] == 'B' || arr[i][j] == 'Q') && count == 1) {
                    result = true;
                    break;
                }
            }
            j--;
            i++;
        }
    }

    static void rightUpDiagCheck(int i, int j, char[][] arr) {
        int count = 0;
        while (j < 4 && i >= 0) {
            if (arr[i][j] != '_' && arr[i][j] != 'K') {
                count++;
                if ((arr[i][j] == 'B' || arr[i][j] == 'Q') && count == 1) {
                    result = true;
                    break;
                }
            }
            j++;
            i--;
        }
    }

    static void rightDownDiagCheck(int i, int j, char[][] arr) {
        int count = 0;
        while (j < 4 && i < 4) {
            if (arr[i][j] != '_' && arr[i][j] != 'K') {
                count++;
                if ((arr[i][j] == 'B' || arr[i][j] == 'Q') && count == 1) {
                    result = true;
                    break;
                }
            }
            j++;
            i++;
        }
    }

    static void knightCheck(int i, int j, char[][] arr) {
        if (i - 2 >= 0) {
            if (j - 1 >= 0 && arr[i - 2][j - 1] == 'K') {
                result = true;
            }
            if (j + 1 < 4 && arr[i - 2][j + 1] == 'K') {
                result = true;
            }
        }
        if (i - 1 >= 0) {
            if (j - 2 >= 0 && arr[i - 1][j - 2] == 'K') {
                result = true;
            }
            if (j + 2 < 4 && arr[i - 1][j + 2] == 'K') {
                result = true;
            }
        }
        if (i + 1 < 4) {
            if (j - 2 >= 0 && arr[i + 1][j - 2] == 'K') {
                result = true;
            }
            if (j + 2 < 4 && arr[i + 1][j + 2] == 'K') {
                result = true;
            }
        }
        if (i + 2 < 4) {
            if (j - 1 >= 0 && arr[i + 2][j - 1] == 'K') {
                result = true;
            }
            if (j + 1 < 4 && arr[i + 2][j + 1] == 'K') {
                result = true;
            }
        }
    }

    static void pawnCheck(int i, int j, char[][] arr) {
        if (i + 1 < 4 && j - 1 >= 0) {
            if (arr[i + 1][j - 1] == 'P') {
                result = true;
            }
        }

        if (i + 1 < 4 && j + 1 < 4) {
            if (arr[i + 1][j + 1] == 'P') {
                result = true;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[][] field = new char[4][4];
        int k = 0, king_i = 0, king_j = 0, knight_i = 0, knight_j = 0;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = str.charAt(k);
                if (field[i][j] == 'K') {
                    king_j = j;
                    king_i = i;
                }
                if (field[i][j] == 'N') {
                    knight_j = j;
                    knight_i = i;
                }
                k++;
            }
        }

        for (char[] chars : field) {
            for (char aChar : chars) {
                System.out.print(aChar + "\t");
            }
            System.out.println();
        }

        upCheck(king_i, king_j, field);
        downCheck(king_i, king_j, field);
        leftCheck(king_i, king_j, field);
        rightCheck(king_i, king_j, field);
        leftDownDiagCheck(king_i, king_j, field);
        rightDownDiagCheck(king_i, king_j, field);
        leftUpDiagCheck(king_i, king_j, field);
        rightUpDiagCheck(king_i, king_j, field);
        pawnCheck(king_i, king_j, field);
        knightCheck(knight_i, knight_j, field);

        System.out.println(result);
    }
}