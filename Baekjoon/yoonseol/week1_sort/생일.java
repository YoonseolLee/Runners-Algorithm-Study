package Baekjoon.yoonseol.week1_sort;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class 생일 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
        Map<String, String> birthInfo = new HashMap<>();

        int repetition = Integer.parseInt(br.readLine()); // 반복 횟수 입력 받음
        for (int i = 0; i < repetition; i++) {
            String line = br.readLine();
            String[] parts = line.split(" ", 2);

            String name = parts[0];
            if (parts.length > 1) {
                birthInfo.put(name, parts[1]);
            } else {
                throw new IllegalArgumentException("입력이 잘못되었습니다.");
            }
        }

        List<Map.Entry<String, String>> entries = new ArrayList<>(birthInfo.entrySet());

        // 날짜 순으로 정렬
        Collections.sort(entries, (o1, o2) -> {
            try {
                return sdf.parse(o1.getValue()).compareTo(sdf.parse(o2.getValue()));
            } catch (ParseException e) {
                e.printStackTrace();
                return 0;
            }
        });

        String oldest = entries.get(0).getKey();
        String youngest = entries.get(entries.size() - 1).getKey();

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(youngest + "\n");
            bw.write(oldest + "\n");
            bw.flush();
        }

        br.close();
    }
}
