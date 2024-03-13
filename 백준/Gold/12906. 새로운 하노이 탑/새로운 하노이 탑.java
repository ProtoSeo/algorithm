import java.io.*;
import java.util.*;

public class Main {

    static Set<String> isVisited = new HashSet<>();

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] initBars = new String[3];
        for (int i = 0; i < 3; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            if (Integer.parseInt(stk.nextToken()) == 0) {
                initBars[i] = "";
                continue;
            }
            initBars[i] = stk.nextToken();
        }

        Deque<Game> q = new ArrayDeque<>();
        Game game = new Game(initBars, 0);
        q.add(game);
        isVisited.add(game.status());

        while (!q.isEmpty()) {
            Game g = q.poll();
            int c = g.move;

            if (g.isClear()) {
                System.out.println(c);
                break;
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j || g.bars[i].isEmpty()) {
                        continue;
                    }
                    Game movedGame = g.move(i, j);
                    String status = movedGame.status();
                    if (isVisited.contains(status)) {
                        continue;
                    }
                    q.add(movedGame);
                    isVisited.add(status);
                }
            }
        }
    }
}

class Game {
    List<Character>[] bars = new List[3];
    int move;

    public Game(String[] bars, int move) {
        for (int i = 0; i < 3; i++) {
            this.bars[i] = new ArrayList<>();
            for (int j = 0; j < bars[i].length(); j++) {
                char c = bars[i].charAt(j);
                if (this.bars[i].isEmpty() && c == 'A' + i) {
                    continue;
                }
                this.bars[i].add(c);
            }
        }
        this.move = move;
    }

    public Game(List<Character>[] bars, int move) {
        this.bars = bars;
        this.move = move;
    }

    public boolean isClear() {
        for (int i = 0; i < 3; i++) {
            List<Character> bar = bars[i];
            for (char c : bar) {
                if (c != 'A' + i) {
                    return false;
                }
            }
        }
        return true;
    }

    public Game move(int s, int e) {
        List<Character>[] movedBars = new List[3];
        for (int i = 0; i < 3; i++) {
            movedBars[i] = new ArrayList<>();
            for (char c : this.bars[i]) {
                movedBars[i].add(c);
            }
        }
        char c = movedBars[s].remove(this.bars[s].size() - 1);
        if (!(movedBars[e].isEmpty() && c == 'A' + e)) {
            movedBars[e].add(c);
        }
        return new Game(movedBars, this.move + 1);
    }

    public String status() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (char c : bars[i]) {
                sb.append(c);
            }
            sb.append(' ');
        }
        return sb.toString();
    }
}
