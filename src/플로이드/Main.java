package 플로이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX = 999999999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n, m;
        int[][] ary;
        int a, b, c;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        ary = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ary[i][j] = (i == j) ? 0 : MAX;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            ary[a - 1][b - 1] = Math.min(ary[a - 1][b - 1], c);
        }

        for (int t = 0; t < n; t++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    ary[i][j] = Math.min(ary[i][j], ary[i][t] + ary[t][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ary[i][j] == MAX) {
                    System.out.print("0 ");
                } else {
                    System.out.print(ary[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
