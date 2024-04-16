package SAMSUNG;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SamsungQ1 {

    static int[][] board, visited;
    static int R,C,K,center, row;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static Queue<Coord> queue = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        K = sc.nextInt();
        board = new int[R+3][C+1];
        visited = new int[R+3][C+1];
        int sum = 0;
        for (int i = 0; i < K; i++) {
            int r = sc.nextInt();
            int exit = sc.nextInt();
            boolean init = move(r, exit);
            for(int k=0; k<R+3; k++){
                for(int j=1; j<=C; j++){
                    visited[k][j] = 0;
                }
            }
            if(init) {
                for(int k=0; k<R+3; k++){
                    for(int j=1; j<=C; j++){
                        board[k][j] = 0;
                    }
                }
            }
            else{
                queue.offer(new Coord(center, row, board[center][row]));
                visited[center][row] = 1;
                int max = BFS();
                queue.clear();
                sum += max;
            }
        }
        System.out.println(sum);
    }

    public static boolean move(int r, int exit){
        row = r;
        center = 1;
        for(int i=0; i<3; i++){
            for(int j=row-1; j<=row+1; j++){
                if(i==0 && j == row) board[i][j] = 1;
                if(i==1 && j == row-1) board[i][j] = 1;
                if(i==1 && j== row) board[i][j] = 3;
                if(i==1 && j == row+1) board[i][j] =1;
                if(i==2 && j == row) board[i][j] = 1;
            }
        }

        if(exit == 0) board[0][row] = 2;
        if(exit == 1) board[1][row+1] = 2;
        if(exit == 2) board[2][row] = 2;
        if(exit == 3) board[1][row-1] = 2;

        boolean stop = false;

        while(!stop){
            boolean priority1, priority2 = false, priority3 = false;
            priority1 = down();
            if(!priority1){
                boolean step1 = left();
                if(step1) {
                    boolean step2 = down();
                    if(step2 == false) right();
                    if(step2) priority2 = true;
                }
            }
            if(!priority1 && !priority2){
                boolean step1 = right();
                if(step1){
                    if(step1) {
                        boolean step2 = down();
                        if(step2 == false) left();
                        if(step2) priority3 = true;
                    }
                }
            }
            if(!priority1 && !priority2 && !priority3) stop = true;
        }

        for(int i=0; i<3; i++){
            for(int j=1; j<=C; j++){
                if(board[i][j] > 0) return true;
            }
        }
        return false;
    }

    public static boolean down(){
        if(center+2 < R+3){
            if(board[center+2][row] == 0 && board[center+1][row-1] == 0 && board[center+1][row+1] == 0){
                board[center+2][row] = board[center+1][row];
                board[center+1][row] = board[center][row];
                board[center][row] = board[center-1][row];
                board[center+1][row-1] = board[center][row-1];
                board[center+1][row+1] = board[center][row+1];
                board[center-1][row] =0;
                board[center][row-1] = 0;
                board[center][row+1] =0;
                center++;
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean left(){
        if(row-2 >= 1){
            if(board[center+1][row-1] == 0 && board[center][row-2] ==0 && board[center-1][row-1] == 0){
                board[center+1][row-1] = board[center][row-1];
                board[center][row-1] = board[center][row];
                board[center-1][row-1] = board[center][row+1];
                board[center][row-2] = board[center-1][row];
                board[center][row] = board[center+1][row];
                board[center+1][row] = 0;
                board[center][row+1] = 0;
                board[center-1][row] = 0;
                row--;
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean right(){
        if(row+2 <= C){
            if(board[center+1][row+1] == 0 && board[center][row+2]==0 && board[center-1][row+1] == 0){
                board[center+1][row+1] = board[center][row+1];
                board[center][row+1] = board[center][row];
                board[center-1][row+1] = board[center][row-1];
                board[center][row+2] = board[center-1][row];
                board[center][row] = board[center+1][row];
                board[center+1][row] = 0;
                board[center][row-1] = 0;
                board[center-1][row] = 0;
                row++;
                return true;
            }
            return false;
        }
        return false;
    }


    public static int BFS(){
        int max = Integer.MIN_VALUE;

        while(!queue.isEmpty()){
            Coord poll = queue.poll();
            max = Math.max(max, poll.y-2);
            if(max == R) break;
            for(int i=0; i<4; i++){
                int ny = poll.y + dy[i];
                int nx = poll.x + dx[i];
                if (ny > 2 && ny < R + 3 && nx > 0 && nx <= C && board[ny][nx] > 0 && visited[ny][nx] == 0) {
                    visited[poll.y][poll.x] =1;
                    if(board[poll.y][poll.x] == 1){
                        if(poll.prior == 2){
                            if(board[ny][nx] == 3) queue.offer(new Coord(ny,nx, board[poll.y][poll.x]));
                        }
                    }
                    else queue.offer(new Coord(ny,nx, board[poll.y][poll.x]));
                }
            }

        }
        return max;
    }
}

class Coord{
    int x;
    int y;
    int prior;

    public Coord(int y, int x, int prior) {
        this.x = x;
        this.y = y;
        this.prior = prior;
    }
}
