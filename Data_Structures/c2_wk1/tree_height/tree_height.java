package tree_height;
import java.util.*;
import java.io.*;

public class tree_height {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class TreeHeight {
		int n;
		int parent[];
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
			}
		}

//		5
//      0  1 2 3 4
//		4 -1 4 1 1
		
		int computeHeight() {
        // Replace this code with a faster implementation
			System.out.println("Parent is " + Arrays.toString(parent));
			int maxHeight = 0;
			for (int vertex = 0; vertex < n; vertex++) {
			System.out.println("outer loop is " + vertex);
			
			int height = 0;
			
			for (int i = vertex; i != -1; i = parent[i])
				height++;
				maxHeight = Math.max(maxHeight, height);
				System.out.println("inner loop is " + vertex);
//				System.out.println("inner height is " + height);
//				System.out.println("maxHeight is " + maxHeight);
//				System.out.println("-----------");
			}
			return maxHeight;
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}
