
class Fraction {
    int nidx, didx, nval, dval;

    Fraction(int nidx, int didx, int nval, int dval) {
        this.nidx = nidx;
        this.didx = didx;
        this.nval = nval;
        this.dval = dval;
    }
}

class FractionComparator implements Comparator<Fraction> {
    public int compare(Fraction a, Fraction b) {
        double fracA = (double) a.nval / a.dval;
        double fracB = (double) b.nval / b.dval;
        return Double.compare(fracA, fracB);
    }
}

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Fraction> pq = new PriorityQueue<>(new FractionComparator());
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                pq.add(new Fraction(i, j, arr[i], arr[j]));
            }
        }

        Fraction f = null;
        while (k-- > 0) {
            f = pq.poll();
        }

        int[] res = {arr[f.nidx], arr[f.didx]};
        return res;
    }
}
