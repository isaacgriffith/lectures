package edu.isu.cs2235;

import java.util.HashMap;
import java.util.Map;

public class HuffmanDriver {

    public static void main(String args[]) {
        Map<String, Double> freqs = new HashMap<>();
        freqs.put("a", 20d);
        freqs.put("b", 15d);
        freqs.put("c", 5d);
        freqs.put("d", 15d);
        freqs.put("e", 45d);

        HuffmanDriver drive = new HuffmanDriver();
        drive.run(freqs);
    }

    public void run(Map<String, Double> freqs) {
        HuffmanTree t = HuffmanTree.build(freqs);
        Map<Character, String> codes = t.getCodes();

        codes.forEach((k, v) -> System.out.printf("%c = %s\n", k, v));

        String encoded = encode("bad", codes);
        System.out.println("bad = " + encoded);
        System.out.printf("%s = %s\n", encoded, decode(encoded, codes));

    }

    public String encode(String plain, Map<Character, String> codes) {
        StringBuilder builder = new StringBuilder();
        for(char c : plain.toCharArray()) {
            builder.append(codes.get(c));
        }
        return builder.toString();
    }

    public String decode(String encoded, Map<Character, String> codes) {
        Map<String, Character> decodes = new HashMap<>();
        codes.forEach((k, v) -> decodes.put(v, k));

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < encoded.length(); i++) {
            for (int j = i + 1; j <= encoded.length(); j++) {
                String s = encoded.substring(i, j);
                if (decodes.containsKey(s)) {
                    builder.append(decodes.get(s));
                    i = j - 1;
                    break;
                }
            }
        }
        return builder.toString();
    }
}
