package covering_segments;
import java.util.*;

public class CoveringSegments {
	
	
    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        public int  getEnd() {
            return this.end;
        }
        
        public int  getStart() {
            return this.start;
        }        

        public String toString() {
            return getStart() + ", " + getEnd() + "|";
        }
    }

    private static int[] optimalPoints(Segment[] segments) {
        //write your code here
//        int[] points = new int[2 * segments.length];
        ArrayList<Integer> points2 = new ArrayList<Integer>();
        Arrays.sort(segments, new Comparator<Segment>() {
            public int compare(Segment o1, Segment o2) {
            	return Integer.compare(o1.getEnd(), o2.getEnd());
            }
        });
        int compare_point = segments[0].getEnd();
        for (int i = 0; i < segments.length; i++) {
        	if (segments[i].getStart() <= compare_point && compare_point <= segments[i].getEnd()){
        		
        	} else {
        		points2.add(compare_point);
        		compare_point = segments[i].getEnd();
        	}
        }
        
        System.out.println("points length is " + points2.size);
        return points;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
