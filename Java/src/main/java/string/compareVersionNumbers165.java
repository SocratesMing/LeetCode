package string;

public class compareVersionNumbers165 {
    public static int solution(String s1, String s2) {
        String[] split1 = s1.split("\\.");
        String[] split2 = s2.split("\\.");

        for (int i = 0; i < split1.length && i < split2.length; i++) {
            int v1 = Integer.parseInt(split1[i]);
            int v2 = Integer.parseInt(split2[i]);

            if (v1 == v2) {

            } else if (v1 < v2) {
                return -1;
            } else {
                return 1;
            }

        }
        return 0;

    }
}
