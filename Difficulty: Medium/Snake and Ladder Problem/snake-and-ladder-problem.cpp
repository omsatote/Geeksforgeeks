#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int minThrows(int n, vector<int>& ladders, vector<int>& snakes) {
        int total = n * n;

        // jump[x] = destination of snake/ladder
        vector<int> jump(total + 1, -1);

        // Ladders
        for (int i = 0; i + 1 < (int)ladders.size(); i += 2) {
            jump[ladders[i]] = ladders[i + 1];
        }

        // Snakes
        for (int i = 0; i + 1 < (int)snakes.size(); i += 2) {
            jump[snakes[i]] = snakes[i + 1];
        }

        // BFS
        vector<int> dist(total + 1, -1);
        queue<int> q;

        q.push(1);
        dist[1] = 0;

        while (!q.empty()) {
            int current = q.front();
            q.pop();

            if (current == total) {
                return dist[current];
            }

            for (int dice = 1; dice <= 6; dice++) {
                int next = current + dice;

                if (next > total)
                    continue;

                // Immediately take snake or ladder
                if (jump[next] != -1) {
                    next = jump[next];
                }

                if (dist[next] == -1) {
                    dist[next] = dist[current] + 1;
                    q.push(next);
                }
            }
        }

        return -1;
    }
};