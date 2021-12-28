public class MaxAreaOfTriangle{
    static int maxn=1009;
    static int maxc=3;
    static int[] l=new int[maxc];
    static int[] rgt=new int[maxc];
    static int[][] top=new int[maxc][maxn];
    static int[][] bottom=new int[maxc][maxn];
    static int mapcolor(char c)
    {
        if (c == 'r')
            return 0;
        else if (c == 'g')
            return 1;
        return 2;
    }
    static double findarea(int r,int c)
    {
        double ans = (double)0;
        // for each column
        for (int i = 0; i < c; i++)
            // for each top vertex
            for (int x = 0; x < 3; x++)
            // for each bottom vertex
                for (int y = 0; y < 3; y++)
                {
                    // finding the third color of
                    // vertex either on rgt or l.
                    int z = 3 - x - y;
                    // finding area of triangle on l side of column.
                    if (x != y && top[x][i] != 1000000 && bottom[y][i] != -1 && l[z] != 1000000)
                    {
                        ans=Math.max(ans,((double)1/(double)2)*(bottom[y][i]-top[x][i]+1)*(i - l[z] + 1));
                    }
                    // finding area of triangle on rgt side of column.
                    if (x != y && top[x][i] != 1000000 && bottom[y][i] != -1 && rgt[z] != -1)
                    {
                    //  if(x==0 && y==2)cout<<bottom[y][i]<<" "<<top[x][i]<<" "<<rgt[z]<<endl;
                        ans = Math.max(ans, ((double)1/(double)2) *(bottom[y][i] - top[x][i] + 1) *(rgt[z] - i + 1));
                    }
                }
        return ans;
    }
    // Precompute the vertices of top, bottom, l
    // and rgt and then computing the maximum area.
    double maxarea(String[] mat,int r, int c)
    {
        for(int i=0;i<3;i++)
        {
            l[i]=1000000;
            rgt[i]=-1;
            for(int j=0;j<c;j++)
            {
                top[i][j]=1000000;
                bottom[i][j]=-1;
            }
        }
        // finding the r, b, g cells for the l
        // and rgt vertices.
        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                l[mapcolor(mat[i].charAt(j))] =Math.min(l[mapcolor(mat[i].charAt(j))], j);
                rgt[mapcolor(mat[i].charAt(j))] =Math.max(l[mapcolor(mat[i].charAt(j))], j);
            }
        }
        // finding set of {r, g, b} of top and
        // bottom for each column.
        for (int j = 0; j < c; j++)
        {
            for( int i = 0; i < r; i++)
            {
                top[mapcolor(mat[i].charAt(j))][j] =Math.min(top[mapcolor(mat[i].charAt(j))][j], i);
                bottom[mapcolor(mat[i].charAt(j))][j] =Math.max(bottom[mapcolor(mat[i].charAt(j))][j], i);
            }
        }
        return findarea(r,c);
    }
    public int solve(String[] A) {
        double res=maxarea(A,A.length,A[0].length());
        return (int)Math.ceil(res);
    }
    public static void main(String[] args) {

    }
}