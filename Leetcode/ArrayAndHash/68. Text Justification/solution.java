class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int length = 0; // Sum of word lengths (excluding spaces)
        int i = 0;

        // Iterate through the list
        while(i < words.length){
            // line complete (the work length + 1 space for each word + length of current word)
            if(length + line.size() + words[i].length() > maxWidth){
                // Total spaces needed
                int extraSpace = maxWidth - length; 
                // space go in between words in a line
                int space = extraSpace / Math.max(1, (line.size() - 1)); // should never divide 0
                // Extra spaces for left gaps
                int remainder = extraSpace % Math.max(1, (line.size() - 1));

                // put space between words
                for (int j = 0; j < Math.max(1, line.size() - 1); j++) {
                    // Add base spaces
                    line.set(j, line.get(j) + " ".repeat(space));

                    if(remainder > 0){
                        line.set(j, line.get(j) + " ");// Add extra space to left gaps
                        remainder--;
                    }
                }

                 // Join with no separator (spaces already added)
                result.add(String.join("", line));

                // reset
                line.clear();
                length = 0;
            }

            // If the current word can fit in the line
            line.add(words[i]);
            length += words[i].length();
            i++;
        }

        // handle the last line
        String lastLine = String.join(" ", line);
        int trailSpace = maxWidth - lastLine.length();
        result.add(lastLine + " ".repeat(trailSpace));

        return result;
    }
}
