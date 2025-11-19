// The split method in Java’s String class breaks a string into an array of substrings, using a regular expression (regex) as the separator.
//  You can also specify a limit to control how many splits happen.
/*
     * public String[] split(String regex, int limit)
     * public String[] split(String regex)
     */
    class Split {
      public static void main(String args[]) {
        String Str = new String("Welcome-to-Tutorials-of-String");
        //String Str = new String("Welcome to Tutorials of String");

        // Splits at the first - only (because limit is 2).
        // Result: ["Welcome", "to-Tutorials-of-String"]
        System.out.println("Return Value :" );
        String s[] = Str.split("-", 2);
        for (int i = 0; i < s.length; i++) {
          System.out.println(s[i]);
        }
        System.out.println("");

        s = Str.split("-", 3);  //splits the string in 3 subStrings, ["Welcome", "to", "Tutorials-of-String"]
        System.out.println("Return Value :" );
        for (int i = 0; i < s.length; i++) {
          System.out.println(s[i]);
        }
        System.out.println("");

        s = Str.split("-", 0);   //techically no limits, so split at every '-', ["Welcome", "to", "Tutorials", "of", "String"]
        System.out.println("Return Value :" );
        for (int i = 0; i < s.length; i++) {
          System.out.println(s[i]);
        }
        System.out.println("");

        s = Str.split("-");    // same as above
        System.out.println("Return Value :" );
        for (int i = 0; i < s.length; i++) {
          System.out.println(s[i]);
        }
      }
    }