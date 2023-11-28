import java.util.*;
public class bard {
    static int getCardinalityInArray(BitSet[] arr, int villager) {
        int count = 0;
        for (BitSet curBitset : arr) {
            boolean boolTemp = curBitset.get(villager);
            if (boolTemp) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();      // num villagers
        int e = scanner.nextInt();      // num evenings
        BitSet[] arrBset = new BitSet[e+1];    // array of bitsets for each night

        // initialize all bitsets in arrBset as empty, but not null
        for (int i = 0; i < e+1; i++) {
            arrBset[i] = new BitSet();
            arrBset[i].set(0,1,false);
        }

        int lastDayBardPresent = -1;
        for (int i = 1; i <= e; i++) { // loop through each evening
            int k = scanner.nextInt();  // num villagers present this evening

            BitSet t = new BitSet(n+1); // temp bitset
            for (int j = 0; j < k; j++) {
                int villagerTemp = scanner.nextInt();
                t.set(villagerTemp);
            }

            if (t.get(1)) { // bard is present
                arrBset[i] = t;
                lastDayBardPresent = i;
            }
            else { // bard not present
                if (lastDayBardPresent >= 1) { // bard has been to any meetings
                    arrBset[lastDayBardPresent].or(t); // logic OR tempBitset & last day bard was present
                }
            }
        }

        int bardinality = getCardinalityInArray(arrBset, 1);
        System.out.println(1);
        for (int i = 2; i <= n; i++) {
            if (getCardinalityInArray(arrBset, i) == bardinality) {
                System.out.println(i);
            }
        }
    }

}