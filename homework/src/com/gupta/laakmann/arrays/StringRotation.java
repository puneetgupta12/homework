package com.gupta.laakmann.arrays;

/*
String Rotation:Assumeyou have a method isSubstring which checks if one word is a substring of another.
Given two strings, sl and s2, write code to check if s2 is a rotation of sl using only one call to isSubstring
(e.g.,"waterbottle" is a rotation of "erbottlewat").
 */
public class StringRotation {
    public static void main(String[] args) {
        String original = "waterbottle";
        String rotated = "bottlewater";

        isSubstring(original, rotated);
    }

    private static void isSubstring(String orig, String rot) {
        StringBuilder sb = new StringBuilder();
        boolean found = false;

        for (int i=0; i<orig.length(); i++) {
            if (sb != null && sb.length() > 0) {
                orig = sb.toString();
                sb = new StringBuilder();
            }

            String firstChar = orig.substring(0,1);
            String restChars = orig.substring(1);

            sb.append(restChars + firstChar);
            //System.out.println(sb.toString());
            if (rot.equals(sb.toString())) {
                System.out.println(orig + " is rotation of " + rot);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println(orig + " is not a rotation of " + rot);
        }
    }
}
