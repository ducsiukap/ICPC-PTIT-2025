#include <bits/stdc++.h>

using namespace std;

int main()
{
    int T;
    cin >> T;
    while (T--)
    {
        int m, n;
        cin >> m >> n;

        int area[m + 1][n + 1];
        for (int i = 1; i <= m; ++i)
        {
            for (int j = 1; j <= n; ++j)
                cin >> area[i][j];
        }

        for (int i = 0; i <= m; ++i)
            area[i][0] = 0;
        for (int i = 0; i <= n; ++i)
            area[0][i] = 0;

        long long s = 0;
        for (int i = 1; i <= m; ++i)
        {
            for (int j = 1; j <= n; ++j)
            {
                if (area[i][j] == 0)
                    continue;
                s += 4 * area[i][j] + 2;
                cout << s << " ";
                // s -= 2 * (area[i][j] < area[i - 1][j] ? area[i][j] : area[i - 1][j]);
                cout << s << " ";
                // s -= 2 * (area[i][j] < area[i][j - 1] ? area[i][j] : area[i][j - 1]);
                cout << s << " \n";
            }
        }

        cout << "asn = " << s << '\n';
    }
    return 0;
}