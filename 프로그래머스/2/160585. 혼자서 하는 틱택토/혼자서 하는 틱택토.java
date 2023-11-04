import java.util.*;

class Solution {
    List<Node> firstTurn = new ArrayList<>();
    List<Node> secondTurn = new ArrayList<>();
    char[][] target = new char[3][3];
    int answer = 0;
    
    public int solution(String[] board) {
        char[][] newBoard = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                newBoard[i][j] = '.';
                target[i][j] = board[i].charAt(j);
                if (target[i][j] == 'O') {
                    firstTurn.add(new Node(j, i));
                } else if (target[i][j] == 'X') {
                    secondTurn.add(new Node(j, i));
                }
            }
        }
        
        // if ((secondTurn.size() > firstTurn.size()) || firstTurn.size() >= secondTurn.size() + 2) {
        //     return 0;
        // }
        find(true, 0, 0, new boolean[firstTurn.size()], new boolean[secondTurn.size()], newBoard);
        
        return answer;
    }
    
    private void find(boolean turn, int fIdx, int sIdx, boolean[] fVisited, boolean[] sVisited, char[][] board) {
        
        if (fIdx == firstTurn.size() && sIdx == secondTurn.size() && isTarget(board)) {
        
            answer = 1;
        }
        if (isEnded(board)) {
            return;
        }
        
        if (turn) {
            for (int i = 0; i < firstTurn.size(); i++) {
                if (fVisited[i]) {
                    continue;
                }
                Node node = firstTurn.get(i);
                fVisited[i] = true;
                board[node.y][node.x] = 'O';
                find(false, fIdx + 1, sIdx, fVisited, sVisited, board);
                board[node.y][node.x] = '.';
                fVisited[i] = false;
            }
        } else {
            for (int i = 0; i < secondTurn.size(); i++) {
                if (sVisited[i]) {
                    continue;
                }
                Node node = secondTurn.get(i);
                sVisited[i] = true;
                board[node.y][node.x] = 'X';
                find(true, fIdx, sIdx + 1, fVisited, sVisited, board);
                board[node.y][node.x] = '.';
                sVisited[i] = false;
            }
        }
    }
    
    private boolean isEnded(char[][] board) {
        if (board[0][0] != '.' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[2][0] != '.' && board[2][0] == board[1][1] && board[1][1] == board[0][2]) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '.' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
            if (board[0][i] != '.' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isTarget(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

class Node {
    int x;
    int y;
    
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}