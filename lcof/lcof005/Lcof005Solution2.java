package lcof.lcof005;

public class Lcof005Solution2 {
    public String replaceSpace(String s) {
        if (s == null) {
            return null;
        }
        return s.replaceAll(" ", "%20");
    }
}