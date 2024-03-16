package yaejoon.week1_sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class K번째수 {

        public void solution() throws Exception {


            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int[] array = new int[n];

            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(br.readLine());
            }
            int m = Integer.parseInt(br.readLine());
            int[][] commands = new int[m][3];

            for (int i = 0; i < m; i++) {
                for (int l = 0; l < 3; l++) {
                    commands[i][l] = Integer.parseInt(br.readLine());
                }

            }

            int[] answer = new int[commands.length];

            for(int l =0 ;l<commands.length;l++){

                int[] reArray = new int[commands[l][1]-commands[l][0]+1];

                for(int i= commands[l][0]-1;i<commands[l][1];i++){
                    reArray[i-commands[l][0]+1] =array[i];
                }

                Arrays.sort(reArray);
                answer[l] =reArray[commands[l][2]-1];
            }

            for(int i=0;i<answer.length;i++){
                System.out.println(answer[i]);
            }
        }

        public static void main(String[] args) throws Exception {
            new K번째수().solution();
        }
    }
