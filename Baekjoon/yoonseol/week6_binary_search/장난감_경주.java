package Baekjoon.yoonseol.week6_binary_search;

import java.io.*;
import java.util.StringTokenizer;

public class 장난감_경주 {

    private static int T, N, X, Y;
    private static double myCar;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {
        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(in.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(in.readLine());

            double min = Double.MAX_VALUE;
            int answer = -1;
            for (int i = 0; i < N; i++) {
                int speed = Integer.parseInt(st.nextToken());
                double time = (double) X / speed;
                if (i == N - 1) {
                    myCar = speed;
                    if (time < min) {
                        answer = 0;
                        break;
                    }
                }

                min = Math.min(min, time);
            }

            if (answer == 0) {
                builder.append(answer).append("\n");
                continue;
            }

            answer = binarySearch(min);
            builder.append(answer).append("\n");
        }
    }

    private static int binarySearch(double min) {
        int left = 0, right = Y, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if ((X - mid) / myCar + 1 >= min) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left <= Y ? left : -1;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();
        T = Integer.parseInt(in.readLine());
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }
}
